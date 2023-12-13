package gallaga2.model;

import gallaga2.model.wrapper.*;

public class LeftBoundary extends Boundary {

    public LeftBoundary(Position position) {
        super(
                position,
                Direction.RIGHT,
                new Velocity(0),
                new HitPoint(Integer.MAX_VALUE),
                new Damage(0)
        );
    }
}
