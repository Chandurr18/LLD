package PracticeProblems.TrafficSignalSystem.controller;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.services.TrafficService;

public class TrafficController {
    private TrafficService trafficService;
    public TrafficController(TrafficService trafficService){
        this.trafficService = trafficService;
    }

    public int getVehileCount(Direction direction){
        return trafficService.getVehileCount(direction);
    }

    public void incrementVehicleCount(Direction direction){
        trafficService.incrementVehicleCount(direction);
    }

    public void resetVehicleCount(Direction direction){
        trafficService.resetVehicleCount(direction);
    }
}
