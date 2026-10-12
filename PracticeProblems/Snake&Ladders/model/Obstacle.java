package model;

import enums.ObstacleType;
import lombok.Getter;

@Getter
public abstract class Obstacle {
    protected int source;
    protected int destination;

    public Obstacle(int source, int destination){
        this.source = source;
        this.destination = destination;
    }

    public int movePlayer() {
        return destination;
    }

    public abstract ObstacleType getObstacleType();
}
