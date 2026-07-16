package PracticeProblems.TrafficSignalSystem.domain;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;

public class EmergencyRequest {
    private int id;
    private int intersectionId;
    private Direction direction;
    private long requestTime;
    private int duration;
    private boolean isActive;

    public EmergencyRequest(int id, int intersectionId, Direction direction, int duration) {
        this.id = id;
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.duration = duration;
        this.requestTime = System.currentTimeMillis();
        this.isActive = true;
        System.out.println("EmergencyRequest is created for id: " + id + ", intersectionId: " + intersectionId
                + ", Direction: " + direction + ", duration: " + duration + 's');
    }

    public int getId() {
        return id;
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public Direction getDirection() {
        return direction;
    }

    public long getRequestTime() {
        return requestTime;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

}
