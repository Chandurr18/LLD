package PracticeProblems.TrafficSignalSystem.domain;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;

public class SignalTiming {
    private int intersectionId;
    private Direction direction;
    private int greenDuration;

    public static final int YELLOW_DURATION = 3;

    public SignalTiming(int intersectionId, Direction direction){
        this.intersectionId = intersectionId;
        this.direction = direction;
        this.greenDuration = 45; // default 45sec
        System.out.println("SignalTiming created for intersection: " + intersectionId + ", Direction: " + direction);
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public static int getYellowDuration() {
        return YELLOW_DURATION;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }    
}
