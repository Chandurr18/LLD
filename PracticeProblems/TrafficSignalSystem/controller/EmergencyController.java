package PracticeProblems.TrafficSignalSystem.controller;

import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.services.EmergencyService;

public class EmergencyController {
    private EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    public void requestEmergency(int intersectionId, Direction direction, int duration) {
        emergencyService.requestEmergency(intersectionId, direction, duration);
    }

    public void endEmergency(int intersectionId){
        emergencyService.endEmergency(intersectionId);
    }
}
