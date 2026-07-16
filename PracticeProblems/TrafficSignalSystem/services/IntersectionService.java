package PracticeProblems.TrafficSignalSystem.services;

import PracticeProblems.TrafficSignalSystem.domain.Intersection;
import PracticeProblems.TrafficSignalSystem.domain.IntersectionCycle;
import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;
import PracticeProblems.TrafficSignalSystem.respository.IntersectionRepository;

public class IntersectionService {
    IntersectionRepository intersectionRepository;

    public IntersectionService(IntersectionRepository intersectionRepository) {
        this.intersectionRepository = intersectionRepository;
    }

    public void createIntersection(int id, String name) {
        if (intersectionRepository.exists(id)) {
            System.out.println("Intersection already present with given id");
            return;
        }

        Intersection intersection = new Intersection(id, name);
        intersectionRepository.save(intersection);

        IntersectionCycle cycle = new IntersectionCycle(id);
        intersectionRepository.updateCycle(id, cycle);

        startAutomaticCycle(id);

        System.out.println("Intersection created Succesfully");
    }

    public Intersection getIntersection(int intersectionId) {
        Intersection intersection = intersectionRepository.findById(intersectionId);

        return intersection;
    }

    public void startAutomaticCycle(int intersectionId) {
        Intersection intersection = getIntersection(intersectionId);

        if (intersection == null) {
            System.out.println("Cannot Start Cycle with given intersectionId: " + intersectionId);

            return;
        }

        IntersectionCycle cycle = intersectionRepository.getIntersectionCycle(intersectionId);
        if (cycle == null) {
            System.out.println("Invalid IntersectionCycle for given IntersectionId");
            return;
        }

        cycle.setPaused(false);
        intersection.setCyclePaused(false);

        System.out.println("Automatic Cycle start for IntersectionId: " + intersectionId);
    }

    public void startCycle(int intersectionId) {
        startAutomaticCycle(intersectionId);
    }

    public void pauseCycle(int intersectionId) {
        Intersection intersection = intersectionRepository.findById(intersectionId);
        IntersectionCycle cycle = intersectionRepository.getIntersectionCycle(intersectionId);
        if (cycle == null || intersection == null) {
            System.out.println("Invalid IntersectionCycle for given IntersectionId");
            return;
        }

        cycle.setPaused(true);
        intersection.setCyclePaused(true);
    }

    public void setAllSignalsToRed(int intersectionId) {
        Intersection intersection = intersectionRepository.findById(intersectionId);
        if (intersection == null) {
            System.out.println("Invalid Intersection for given IntersectionId");
            return;
        }

        intersection.setAllSignalsToRed();
    }

    public void setSignalToGreen(int intersectionId, Direction direction){
        Intersection intersection = intersectionRepository.findById(intersectionId);
        if (intersection == null) {
            System.out.println("Invalid Intersection for given IntersectionId");
            return;
        }

        intersection.setSignalToGreen(direction);
    }

}
