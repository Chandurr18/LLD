package PracticeProblems.TrafficSignalSystem.controller;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.services.TimingService;

public class TimingController {
    private TimingService timingService;

    public TimingController(TimingService timingService){
        this.timingService = timingService;
    }

    public void setSignalTiming(int intersectionId, Direction direction, int greenDuration){
        timingService.setSignalTiming(intersectionId, direction, greenDuration);
    }

    public int getSignalTiming(int intersectionId, Direction direction){
        return timingService.getSignalTiming(intersectionId, direction);
    }
}
