package PracticeProblems.TrafficSignalSystem.services;

import java.util.concurrent.atomic.AtomicInteger;

import PracticeProblems.TrafficSignalSystem.domain.EmergencyRequest;
import PracticeProblems.TrafficSignalSystem.domain.Intersection;
import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;

public class EmergencyService {
    IntersectionService intersectionService;
    AtomicInteger id = new AtomicInteger(100);

    public EmergencyService(IntersectionService intersectionService) {
        this.intersectionService = intersectionService;
    }

    public void requestEmergency(int intersectionId, Direction direction, int duration) {
        if (intersectionService.getIntersection(intersectionId) == null) {
            System.out.println("Invalid Intersection Id");
            return;
        }

        int requestId = id.getAndIncrement();

        EmergencyRequest request = new EmergencyRequest(requestId, intersectionId, direction, duration);
        //save this in Emergencyrepository;

        intersectionService.pauseCycle(intersectionId);
        intersectionService.setAllSignalsToRed(intersectionId);

        intersectionService.setSignalToGreen(intersectionId, direction);

        intersectionService.getIntersection(intersectionId).setEmergencyMode(true);
        intersectionService.getIntersection(intersectionId).setEmergencyDirection(direction);

        System.out.println("Emergency Request Created");
    }

    public void endEmergency(int intersectionId) {
        Intersection intersection = intersectionService.getIntersection(intersectionId);

        if (intersection == null) {
            System.out.println("Invalid Intersection Id");
            return;
        }

        if (!intersection.isEmergencyMode()) {
            System.out.println("No active emergency for this intersection.");
            return;
        }

        intersection.setEmergencyMode(false);
        intersection.setEmergencyDirection(null);

        intersectionService.setAllSignalsToRed(intersectionId);
        intersectionService.startCycle(intersectionId);

        System.out.println("Emergency ended for Intersection " + intersectionId);
    }
}
