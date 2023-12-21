package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

public class LeftBoundary extends Boundary {

    public LeftBoundary(Position position) {
        super(
                position,
                Direction.RIGHT,
                new HitPoint(Integer.MAX_VALUE),
                new Damage(0),
                CollidingBodyType.LEFT_BOUNDARY
        );
    }
}
