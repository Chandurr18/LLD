package PracticeProblems.TrafficSignalSystem.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import PracticeProblems.TrafficSignalSystem.domain.VehicleCounter;
import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;

public class TrafficService {

    private final Map<Direction, VehicleCounter> vehicleCounters;

    public TrafficService() {
        this.vehicleCounters = new ConcurrentHashMap<>();

        // Initialize counters for all directions
        for (Direction direction : Direction.values()) {
            vehicleCounters.put(direction, new VehicleCounter(direction));
        }
    }

    public int getVehileCount(Direction direction) {
        VehicleCounter counter = vehicleCounters.get(direction);

        if (counter == null) {
            return 0;
        }

        return counter.getCount();
    }

    public void incrementVehicleCount(Direction direction) {
        VehicleCounter counter = vehicleCounters.computeIfAbsent(
                direction,
                VehicleCounter::new);

        counter.incrementCount();
    }

    public void resetVehicleCount(Direction direction) {
        VehicleCounter counter = vehicleCounters.get(direction);

        if (counter != null) {
            counter.resetCount();
        }
    }
}