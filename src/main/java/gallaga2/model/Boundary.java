package gallaga2.model;

import gallaga2.model.wrapper.*;

public abstract class Boundary extends CollidingBody {

    public Boundary(
            Position position,
            Direction direction,
            Velocity velocity,
            HitPoint hitPoint,
            Damage damage
    ) {
        super(
                position,
                direction,
                velocity,
                hitPoint,
                damage
        );
    }
}
