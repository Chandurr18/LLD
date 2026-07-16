package PracticeProblems.TrafficSignalSystem.domain.state;

import PracticeProblems.TrafficSignalSystem.domain.TrafficLight;

public class RedState implements TrafficLightState{
    @Override
    public void turnGreen(TrafficLight light) {
        light.setState(new GreenState());
    }

    @Override
    public void turnRed(TrafficLight light) {
        light.setState(new RedState());
    }

    @Override
    public void turnYellow(TrafficLight light) {
        light.setState(new YellowState());
    }
    
}
