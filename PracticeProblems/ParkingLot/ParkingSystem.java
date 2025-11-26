import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* ============================
   Vehicle
   ============================ */
enum VehicleType {
    CAR, BIKE, TRUCK
}

class Vehicle {
    String licenseNumber;
    VehicleType type;

    Vehicle(String num, VehicleType type) {
        this.licenseNumber = num;
        this.type = type;
    }
}

/* ============================
   ParkingSpot
   ============================ */
class ParkingSpot {
    int id;
    VehicleType type;
    Vehicle parkedVehicle;

    ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
    }

    synchronized boolean isFree() {
        return parkedVehicle == null;
    }

    synchronized boolean park(Vehicle v) {
        if (!isFree() || v.type != type) return false;
        parkedVehicle = v;
        return true;
    }

    synchronized void removeVehicle() {
        parkedVehicle = null;
    }
}

/* ============================
   Floor
   ============================ */
class Floor {
    int id;
    List<ParkingSpot> spots;

    Floor(int id, List<ParkingSpot> spots) {
        this.id = id;
        this.spots = spots;
    }

    ParkingSpot getFreeSpot(VehicleType type) {
        for (ParkingSpot s : spots) {
            if (s.type == type && s.isFree()) return s;
        }
        return null;
    }
}

/* ============================
   Ticket
   ============================ */
class Ticket {
    String ticketId;
    Vehicle vehicle;
    ParkingSpot spot;
    long entryTime;

    Ticket(String id, Vehicle v, ParkingSpot spot) {
        this.ticketId = id;
        this.vehicle = v;
        this.spot = spot;
        this.entryTime = System.currentTimeMillis();
    }
}

/* ============================
   Strategy: Spot Allocation
   ============================ */
interface SpotAllocationStrategy {
    ParkingSpot findSpot(List<Floor> floors, Vehicle v);
}

class NearestSpotStrategy implements SpotAllocationStrategy {
    public ParkingSpot findSpot(List<Floor> floors, Vehicle v) {
        for (Floor f : floors) {
            ParkingSpot s = f.getFreeSpot(v.type);
            if (s != null && s.park(v)) return s;
        }
        return null;
    }
}

/* ============================
   Strategy: Fee Calculator
   ============================ */
interface FeeCalculator {
    double calculate(Ticket t);
}

class HourlyFeeCalculator implements FeeCalculator {
    public double calculate(Ticket t) {
        long durationMs = System.currentTimeMillis() - t.entryTime;
        long hours = Math.max(1, durationMs / (1000 * 60 * 60));
        return hours * 10; // flat 10/hour
    }
}

/* ============================
   ParkingLot (Singleton)
   ============================ */
class NoSpotAvailableException extends Exception{
    NoSpotAvailableException(String message){
        super(message);
    }
}
class ParkingLot {
    private static ParkingLot instance;

    List<Floor> floors = new ArrayList<>();
    SpotAllocationStrategy strategy = new NearestSpotStrategy();
    FeeCalculator feeCalculator = new HourlyFeeCalculator();
    Map<String, Ticket> activeTickets = new ConcurrentHashMap<>();
    private final AtomicInteger tid = new AtomicInteger(101);

    private ParkingLot() {}

    // Bill Pugh Singleton
    public static class Holder{
        private static final ParkingLot INSTANCE = new ParkingLot();
    }
    public static ParkingLot getInstance() {
        return Holder.INSTANCE;
    }

    void addFloor(Floor f) {
        floors.add(f);
    }

    synchronized Ticket generateTicket(Vehicle v) throws NoSpotAvailableException {
        ParkingSpot spot = strategy.findSpot(floors, v);
        if (spot == null) throw new NoSpotAvailableException("No spot available for vehicle: " + v.licenseNumber);

        String ticketId = "T-" + tid.getAndIncrement();
        Ticket t = new Ticket(ticketId, v, spot);
        activeTickets.put(ticketId, t);
        return t;
    }

    synchronized double processExit(String ticketId) {
        Ticket t = activeTickets.remove(ticketId);
        if (t == null) return -1;

        double fee = feeCalculator.calculate(t);
        t.spot.removeVehicle();
        return fee;
    }
}

/* ============================
   Gates
   ============================ */
class EntryGate {
    ParkingLot lot = ParkingLot.getInstance();

    Ticket enter(Vehicle v) throws NoSpotAvailableException {
        return lot.generateTicket(v);
    }
}

class ExitGate {
    ParkingLot lot = ParkingLot.getInstance();

    double exit(String ticketId) {
        return lot.processExit(ticketId);
    }
}

/* ============================
   Demo (Optional)
   ============================ */
public class ParkingSystem {
    public static void main(String[] args) {
        try {
            ParkingLot lot = ParkingLot.getInstance();

            // Floor 1
            List<ParkingSpot> f1spots = Arrays.asList(
                    new ParkingSpot(1, VehicleType.CAR),
                    new ParkingSpot(2, VehicleType.CAR),
                    new ParkingSpot(3, VehicleType.BIKE)
            );
            lot.addFloor(new Floor(1, f1spots));

            // Gates
            EntryGate entry = new EntryGate();
            ExitGate exit = new ExitGate();

            // Vehicles arriving
            Ticket t1 = entry.enter(new Vehicle("KA01", VehicleType.CAR));
            System.out.println("Ticket issued: " + t1.ticketId + " Spot: " + t1.spot.id);

            Ticket t2 = entry.enter(new Vehicle("KA02", VehicleType.BIKE));
            System.out.println("Ticket issued: " + t2.ticketId + " Spot: " + t2.spot.id);

            // Exit
            double fee = exit.exit(t1.ticketId);
            System.out.println("Fee for ticket " + t1.ticketId + ": " + fee);
        }
        catch(NoSpotAvailableException e){
            System.out.println(e.getMessage());
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
