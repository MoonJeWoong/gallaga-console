package gallaga2.model;

import gallaga2.model.wrapper.*;

public class RightBoundary extends Boundary {

    public RightBoundary(Position position, Direction direction, Velocity velocity, HitPoint hitPoint, Damage damage) {
        super(position, Direction.LEFT, new Velocity(0), new HitPoint(1), new Damage(0));
    }
}
