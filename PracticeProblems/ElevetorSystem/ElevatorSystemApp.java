import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// ------------------------------------------------------------
// Enums
// ------------------------------------------------------------
enum Direction { UP, DOWN, IDLE }
enum ElevatorState { MOVING, STOPPED, IDLE }

// ------------------------------------------------------------
// Request (Command Pattern)
// ------------------------------------------------------------
interface Request {
    int getFloor();
    Direction getDirection(); // null for cabin
    void execute(ElevatorController controller);
}

class HallRequest implements Request {
    private final int floor;
    private final Direction direction;

    HallRequest(int floor, Direction direction) {
        this.floor = floor;
        this.direction = direction;
    }
    public int getFloor() { return floor; }
    public Direction getDirection() { return direction; }

    @Override
    public void execute(ElevatorController controller) {
        controller.addHallRequest(this);
    }
}

class CabinRequest implements Request {
    private final int floor;

    CabinRequest(int floor) { this.floor = floor; }

    public int getFloor() { return floor; }
    public Direction getDirection() { return null; }

    @Override
    public void execute(ElevatorController controller) {
        controller.addCabinRequest(floor);
    }
}

// ------------------------------------------------------------
// Elevator (physical car)
// ------------------------------------------------------------
class Elevator {
    final int id;
    volatile int currentFloor;
    volatile Direction direction = Direction.IDLE;
    volatile ElevatorState state = ElevatorState.IDLE;

    Elevator(int id, int startFloor) {
        this.id = id;
        this.currentFloor = startFloor;
    }

    void moveUpOne() { currentFloor++; }
    void moveDownOne() { currentFloor--; }

    void openDoor() {
        // simulate door time
        try { Thread.sleep(150); } catch (Exception ignored) {}
    }

    void closeDoor() {
        try { Thread.sleep(150); } catch (Exception ignored) {}
    }

    @Override
    public String toString() {
        return "Elevator[" + id + "] floor=" + currentFloor +
                " dir=" + direction + " state=" + state;
    }
}

// ------------------------------------------------------------
// Scheduler (Strategy)
// ------------------------------------------------------------
interface Scheduler {
    ElevatorController assignElevator(HallRequest req, List<ElevatorController> controllers);
}

class NearestCarScheduler implements Scheduler {
    @Override
    public ElevatorController assignElevator(HallRequest req, List<ElevatorController> controllers) {
        ElevatorController best = null;
        int bestScore = Integer.MAX_VALUE;

        for (ElevatorController c : controllers) {
            Elevator e = c.getElevator();
            int distance = Math.abs(e.currentFloor - req.getFloor());
            int score = distance;   // simple scoring for interview clarity

            if (score < bestScore) {
                bestScore = score;
                best = c;
            }
        }
        return best;
    }
}

// ------------------------------------------------------------
// ElevatorController
// ------------------------------------------------------------
class ElevatorController {
    private final Elevator elevator;

    private final PriorityQueue<Integer> upQueue =
            new PriorityQueue<>(); // min-heap
    private final PriorityQueue<Integer> downQueue =
            new PriorityQueue<>(Collections.reverseOrder()); // max-heap

    private final Lock lock = new ReentrantLock();
    private final Condition hasWork = lock.newCondition();

    private final Thread worker;
    private volatile boolean shutdown = false;

    ElevatorController(Elevator e) {
        this.elevator = e;
        this.worker = new Thread(this::run, "Elevator-" + e.id);
        this.worker.start();
    }

    Elevator getElevator() { return elevator; }

    void addHallRequest(HallRequest req) {
        lock.lock();
        try {
            if (req.getDirection() == Direction.UP)
                upQueue.offer(req.getFloor());
            else
                downQueue.offer(req.getFloor());

            hasWork.signal();
        } finally {
            lock.unlock();
        }
    }

    void addCabinRequest(int floor) {
        lock.lock();
        try {
            if (floor > elevator.currentFloor) upQueue.offer(floor);
            else if (floor < elevator.currentFloor) downQueue.offer(floor);

            hasWork.signal();
        } finally {
            lock.unlock();
        }
    }

    int pending() {
        return upQueue.size() + downQueue.size();
    }

    void shutdown() {
        shutdown = true;
        worker.interrupt();
    }

    // Main worker loop
    private void run() {
        try {
            while (!shutdown) {
                lock.lock();
                while (!shutdown && upQueue.isEmpty() && downQueue.isEmpty()) {
                    elevator.state = ElevatorState.IDLE;
                    elevator.direction = Direction.IDLE;
                    hasWork.await(200, TimeUnit.MILLISECONDS);
                }

                Integer target = null;

                // Decide direction
                if (elevator.direction == Direction.IDLE) {
                    if (!upQueue.isEmpty()) elevator.direction = Direction.UP;
                    else if (!downQueue.isEmpty()) elevator.direction = Direction.DOWN;
                }

                if (elevator.direction == Direction.UP && !upQueue.isEmpty()) {
                    target = upQueue.peek();
                } else if (elevator.direction == Direction.DOWN && !downQueue.isEmpty()) {
                    target = downQueue.peek();
                }
                lock.unlock();

                if (target == null) continue;

                moveTo(target);

                // remove from queues
                lock.lock();
                upQueue.remove(target);
                downQueue.remove(target);
                lock.unlock();

                serviceFloor();
            }
        } catch (InterruptedException ignored) {
        }
    }

    private void moveTo(int target) throws InterruptedException {
        elevator.state = ElevatorState.MOVING;

        while (elevator.currentFloor != target && !shutdown) {
            if (elevator.currentFloor < target) {
                elevator.direction = Direction.UP;
                elevator.moveUpOne();
            } else {
                elevator.direction = Direction.DOWN;
                elevator.moveDownOne();
            }
            Thread.sleep(400); // travel time
        }
    }

    private void serviceFloor() throws InterruptedException {
        elevator.state = ElevatorState.STOPPED;
        elevator.openDoor();
        Thread.sleep(300);
        elevator.closeDoor();
    }
}

// ------------------------------------------------------------
// ElevatorSystem (Top Level)
// ------------------------------------------------------------
class ElevatorSystem {
    private final List<ElevatorController> controllers = new ArrayList<>();
    private final Scheduler scheduler;

    ElevatorSystem(int elevatorCount, int startFloor, Scheduler scheduler) {
        this.scheduler = scheduler;
        for (int i = 0; i < elevatorCount; i++) {
            Elevator e = new Elevator(i + 1, startFloor);
            controllers.add(new ElevatorController(e));
        }
    }

    void submitHallRequest(int floor, Direction dir) {
        HallRequest req = new HallRequest(floor, dir);
        ElevatorController ec = scheduler.assignElevator(req, controllers);
        req.execute(ec);
    }

    void submitInternalRequest(int elevatorId, int floor) {
        ElevatorController ec = controllers.get(elevatorId - 1);
        new CabinRequest(floor).execute(ec);
    }

    void printStatus() {
        System.out.println("--- STATUS ---");
        for (ElevatorController ec : controllers) {
            System.out.println(ec.getElevator());
        }
        System.out.println("--------------");
    }

    void shutdown() {
        controllers.forEach(ElevatorController::shutdown);
    }
}

// ------------------------------------------------------------
// Main Simulation
// ------------------------------------------------------------
public class ElevatorSystemApp {
    public static void main(String[] args) throws Exception {
        ElevatorSystem system = new ElevatorSystem(3, 1, new NearestCarScheduler());

        ScheduledExecutorService printer = Executors.newSingleThreadScheduledExecutor();
        printer.scheduleAtFixedRate(system::printStatus, 0, 2, TimeUnit.SECONDS);

        system.submitHallRequest(5, Direction.UP);
        Thread.sleep(400);
        system.submitHallRequest(2, Direction.DOWN);
        Thread.sleep(600);

        system.submitInternalRequest(1, 9);

        Thread.sleep(10000);

        printer.shutdownNow();
        system.shutdown();
    }
}
