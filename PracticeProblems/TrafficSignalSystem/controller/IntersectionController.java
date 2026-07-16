package PracticeProblems.TrafficSignalSystem.controller;

import PracticeProblems.TrafficSignalSystem.domain.Intersection;
import PracticeProblems.TrafficSignalSystem.services.IntersectionService;

public class IntersectionController {
    private IntersectionService intersectionService;

    public IntersectionController(IntersectionService intersectionService){
        this.intersectionService = intersectionService;
    }

    public void createIntersection(int id, String name){
        intersectionService.createIntersection(id, name);
    }

    public Intersection getIntersection(int intersectionId){
        return intersectionService.getIntersection(intersectionId);
    }

    public void startCycle(int intersectionId){
        intersectionService.startCycle(intersectionId);
    }
}       
