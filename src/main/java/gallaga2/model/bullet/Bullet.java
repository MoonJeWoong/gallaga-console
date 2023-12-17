package gallaga2.model.bullet;

import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.*;

public class Bullet extends CollidingBody {

    public Bullet(Position position) {
        super(
                position,
                Direction.UP,
                new Velocity(1),
                new HitPoint(1),
                new Damage(1),
                CollidingBodyType.BULLET
        );
    }
}
