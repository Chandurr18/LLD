package com.lld.practice.SnakeAndLadders.factory;

import com.lld.practice.SnakeAndLadders.enums.ObstacleType;
import com.lld.practice.SnakeAndLadders.model.Ladder;
import com.lld.practice.SnakeAndLadders.model.Obstacle;
import com.lld.practice.SnakeAndLadders.model.Snake;

public class ObstacleFactory {
    public static Obstacle createObstacle(ObstacleType obstacleType, int src, int dest){
        return switch (obstacleType) {
            case SNAKE -> new Snake(src, dest);
            case LADDER -> new Ladder(src, dest);
            default -> throw new IllegalArgumentException("Invalid Obstacle Type");
        };
    }
}
