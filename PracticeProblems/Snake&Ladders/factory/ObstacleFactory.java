package factory;

import enums.ObstacleType;
import model.Ladder;
import model.Obstacle;
import model.Snake;

public class ObstacleFactory {
    public static Obstacle createObstacle(ObstacleType obstacleType, int src, int dest){
        return switch (obstacleType) {
            case SNAKE -> new Snake(src, dest);
            case LADDER -> new Ladder(src, dest);
            default -> throw new IllegalArgumentException("Invalid Obstacle Type");
        };
    }
}
