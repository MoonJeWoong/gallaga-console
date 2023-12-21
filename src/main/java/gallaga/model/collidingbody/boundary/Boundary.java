package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

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
