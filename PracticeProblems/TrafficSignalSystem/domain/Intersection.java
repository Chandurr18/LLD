package PracticeProblems.TrafficSignalSystem.domain;

import java.util.HashMap;
import java.util.Map;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.domain.state.GreenState;
import PracticeProblems.TrafficSignalSystem.domain.state.RedState;

public class Intersection {
    private int id;
    private String name;
    private Map<Direction, TrafficLight> trafficLights;
    private boolean isEmergencyMode;
    private Direction emergencyDirection;
    private boolean isCyclePaused;

    public Intersection(int id, String name) {
        this.id = id;
        this.name = name;
        this.trafficLights = new HashMap<>();
        this.isEmergencyMode = false;
        this.isCyclePaused = false;

        for (Direction direction : Direction.values()) {
            this.trafficLights.put(direction, new TrafficLight(direction));
        }

        System.out.println("Intersection Created: " + name + " (ID: " + id + ")");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmergencyMode() {
        return isEmergencyMode;
    }

    public void setEmergencyMode(boolean isEmergencyMode) {
        this.isEmergencyMode = isEmergencyMode;
    }

    public Direction getEmergencyDirection() {
        return emergencyDirection;
    }

    public void setEmergencyDirection(Direction emergencyDirection) {
        this.emergencyDirection = emergencyDirection;
    }

    public boolean isCyclePaused() {
        return isCyclePaused;
    }

    public void setCyclePaused(boolean isCyclePaused) {
        this.isCyclePaused = isCyclePaused;
    }

    public void setAllSignalsToRed(){
        for (Direction direction : Direction.values()) {
            TrafficLight light = trafficLights.get(direction);
            light.setState(new RedState());
        }
    }

    public void setSignalToGreen(Direction direction){
        trafficLights.get(direction).setState(new GreenState());
    }

}
