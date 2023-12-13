package gallaga2.model;

import gallaga2.model.wrapper.*;

public class UpperBoundary extends Boundary {

    public UpperBoundary(Position position, Direction direction, Velocity velocity, HitPoint hitPoint, Damage damage) {
        super(position, Direction.DOWN, new Velocity(0), new HitPoint(1), new Damage(0));
    }
}
