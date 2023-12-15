package gallaga2.model.boundary;

import gallaga2.model.collidingbody.CollidingBody;
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
