package gallaga2.model.collidingbody.boundary;

import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.*;

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
