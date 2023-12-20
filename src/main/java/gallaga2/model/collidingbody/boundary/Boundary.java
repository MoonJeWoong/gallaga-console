package gallaga2.model.collidingbody.boundary;

import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.*;

public abstract class Boundary extends CollidingBody {

    public Boundary(
            Position position,
            Direction direction,
            HitPoint hitPoint,
            Damage damage,
            CollidingBodyType collidingBodyType
    ) {
        super(
                position,
                direction,
                new Velocity(0),
                hitPoint,
                damage,
                collidingBodyType
        );
    }
}
