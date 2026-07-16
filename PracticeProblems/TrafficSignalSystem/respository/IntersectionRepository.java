package PracticeProblems.TrafficSignalSystem.respository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import PracticeProblems.TrafficSignalSystem.domain.Intersection;
import PracticeProblems.TrafficSignalSystem.domain.IntersectionCycle;

public class IntersectionRepository {
    private final Map<Integer, Intersection> intersections;
    private final Map<Integer, IntersectionCycle> intersectionCycles;

    public IntersectionRepository(){
        this.intersections = new ConcurrentHashMap<>();
        this.intersectionCycles = new ConcurrentHashMap<>();
    }

    public void save(Intersection intersection) {
        intersections.put(intersection.getId(), intersection);
    }

    public Intersection findById(int intersectionId) {
        return intersections.get(intersectionId);
    }

    public IntersectionCycle getIntersectionCycle(int intersectionId) {
        return intersectionCycles.get(intersectionId);
    }

    public void removeTicket(int intersectionId) {
        intersections.remove(intersectionId);
    }

    public boolean exists(int intersectionId){
        return intersections.containsKey(intersectionId);
    }

    public void updateCycle(int id, IntersectionCycle cycle){
        intersectionCycles.put(id, cycle);
    }
}
