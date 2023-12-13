package gallaga2.model;

import gallaga2.model.wrapper.*;

public class LeftBoundary extends Boundary {

    public LeftBoundary(Position position, Direction direction, Velocity velocity, HitPoint hitPoint, Damage damage) {
        super(position, Direction.RIGHT, new Velocity(0), new HitPoint(1), new Damage(0));
    }
}
