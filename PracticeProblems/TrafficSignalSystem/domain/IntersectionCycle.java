package PracticeProblems.TrafficSignalSystem.domain;

public class IntersectionCycle {
    private int intersectionId;
    private int currentPhase; // 0: NORTH, 1: EAST, 2: SOUTH, 3: WEST
    private boolean isPaused;
    private int pausedAtPhase;
    private long phaseStartTime;
    private long pauseStartTime;
    private long totalPauseTime;

    public IntersectionCycle(int intersectionId){
        this.intersectionId = intersectionId;
        this.currentPhase = 0;
        this.isPaused = false;
        this.pausedAtPhase = 0;
        this.phaseStartTime = System.currentTimeMillis();
        this.pauseStartTime = 0;
        this.totalPauseTime = 0;
        System.out.println("Intersection Cycle created for intersection: " + intersectionId);
    }

    public int getIntersectionId() {
        return intersectionId;
    }

    public int getCurrentPhase() {
        return currentPhase;
    }

    public void setCurrentPhase(int currentPhase) {
        this.currentPhase = currentPhase;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }

    public int getPausedAtPhase() {
        return pausedAtPhase;
    }

    public void setPausedAtPhase(int pausedAtPhase) {
        this.pausedAtPhase = pausedAtPhase;
    }

    public long getPhaseStartTime() {
        return phaseStartTime;
    }

    public void setPhaseStartTime(long phaseStartTime) {
        this.phaseStartTime = phaseStartTime;
    }

    public long getPauseStartTime() {
        return pauseStartTime;
    }

    public void setPauseStartTime(long pauseStartTime) {
        this.pauseStartTime = pauseStartTime;
    }

    public long getTotalPauseTime() {
        return totalPauseTime;
    }

    public void setTotalPauseTime(long totalPauseTime) {
        this.totalPauseTime = totalPauseTime;
    }
    

}
