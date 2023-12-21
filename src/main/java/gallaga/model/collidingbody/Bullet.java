package gallaga.model.collidingbody;

import gallaga.model.wrapper.*;

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
