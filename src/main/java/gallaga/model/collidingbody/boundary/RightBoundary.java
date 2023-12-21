package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

public class RightBoundary extends Boundary {

    public RightBoundary(Position position) {
        super(
                position,
                Direction.LEFT,
                new HitPoint(Integer.MAX_VALUE),
                new Damage(0),
                CollidingBodyType.RIGHT_BOUNDARY
        );
    }
}
