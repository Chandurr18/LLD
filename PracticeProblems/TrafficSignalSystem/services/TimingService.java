package PracticeProblems.TrafficSignalSystem.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import PracticeProblems.TrafficSignalSystem.domain.SignalTiming;
import PracticeProblems.TrafficSignalSystem.domain.enums.Direction;

public class TimingService {

    // intersectionId -> (direction -> timing)
    private final Map<Integer, Map<Direction, SignalTiming>> timings;

    public TimingService() {
        this.timings = new ConcurrentHashMap<>();
    }

    public void setSignalTiming(int intersectionId,
                                Direction direction,
                                int greenDuration) {

        if (greenDuration <= 0) {
            System.out.println("Green duration should be greater than 0.");
            return;
        }

        Map<Direction, SignalTiming> intersectionTimings =
                timings.computeIfAbsent(intersectionId,
                        id -> new ConcurrentHashMap<>());

        SignalTiming signalTiming =
                intersectionTimings.computeIfAbsent(
                        direction,
                        dir -> new SignalTiming(intersectionId, dir));

        signalTiming.setGreenDuration(greenDuration);

        System.out.println(
                "Signal timing updated for Intersection "
                        + intersectionId
                        + ", Direction "
                        + direction
                        + " -> "
                        + greenDuration
                        + " seconds");
    }

    public int getSignalTiming(int intersectionId,
                               Direction direction) {

        Map<Direction, SignalTiming> intersectionTimings =
                timings.get(intersectionId);

        if (intersectionTimings == null) {
            return -1;
        }

        SignalTiming signalTiming =
                intersectionTimings.get(direction);

        if (signalTiming == null) {
            return -1;
        }

        return signalTiming.getGreenDuration();
    }
}