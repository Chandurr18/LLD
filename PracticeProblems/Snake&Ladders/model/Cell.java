package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Cell {
    private final int position;
    private Obstacle obstacle;

    public boolean hasObstacle() {
        return obstacle != null;
    }

    public int getFinalPosition() {
        return hasObstacle() ? obstacle.movePlayer() : position;
    }
}
