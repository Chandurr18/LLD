package PracticeProblems.TrafficSignalSystem.domain;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;

public class VehicleCounter {
    private Direction direction;
    private int count;
    private long lastUpdate;

    public VehicleCounter(Direction direction) {
        this.direction = direction;
        this.count = 0;
        this.lastUpdate = System.currentTimeMillis();
        System.out.println("VehicleCounter created for Direction: " + direction);
    }

    public Direction getDirection() {
        return direction;
    }

    public int getCount() {
        return count;

    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setCount(int count) {
        this.count = count;
        this.lastUpdate = System.currentTimeMillis();
        System.out.println("Vehicle Count updated for direction: " + direction + ": " + count);
    }

    public void incrementCount() {
        this.count++;
        this.lastUpdate = System.currentTimeMillis();
        System.out.println("Vehicle Count incremented for direction: " + direction + " - " + count);
    }

    public void resetCount() {
        this.count = 0;
        this.lastUpdate = System.currentTimeMillis();
        System.out.println("Vehicle Count reseted for direction: " + direction);
    }

}
