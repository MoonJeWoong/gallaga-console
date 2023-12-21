package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

public class UpperBoundary extends Boundary {

    public UpperBoundary(Position position) {
        super(
                position,
                Direction.DOWN,
                new HitPoint(Integer.MAX_VALUE),
                new Damage(1),
                CollidingBodyType.UPPER_BOUNDARY
        );
    }
}
