package PracticeProblems.TrafficSignalSystem.domain.state;

import PracticeProblems.TrafficSignalSystem.domain.TrafficLight;

public interface TrafficLightState {
    void turnGreen(TrafficLight light);
    void turnRed(TrafficLight light);
    void turnYellow(TrafficLight light);
}
