package gallaga2.model.boundary;

import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.*;

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
