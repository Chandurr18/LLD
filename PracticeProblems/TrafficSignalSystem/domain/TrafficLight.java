package PracticeProblems.TrafficSignalSystem.domain;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.domain.state.RedState;
import PracticeProblems.TrafficSignalSystem.domain.state.TrafficLightState;

public class TrafficLight {
    private Direction direction;
    private TrafficLightState currentState;

    public TrafficLight(Direction direction){
        this.direction = direction;
        this.currentState= new RedState();

        System.out.println("Traffic Light created for direction:" + direction + " in Red State");
    }

    public Direction getDirection() {
        return direction;
    }

    public TrafficLightState getCurrentState() {
        return currentState;
    }

    public void setState(TrafficLightState newState) {
        this.currentState = newState;
    }

    public void turnGreen(){
        currentState.turnGreen(this);
    }


}


