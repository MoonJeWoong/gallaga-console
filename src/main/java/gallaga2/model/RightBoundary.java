package gallaga2.model;

import gallaga2.model.wrapper.*;

public class RightBoundary extends Boundary {

    public RightBoundary(Position position) {
        super(
                position,
                Direction.LEFT,
                new Velocity(0),
                new HitPoint(Integer.MAX_VALUE),
                new Damage(0)
        );
    }
}
