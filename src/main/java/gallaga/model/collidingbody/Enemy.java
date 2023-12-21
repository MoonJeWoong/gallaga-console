package gallaga.model.collidingbody;

import gallaga.model.wrapper.*;

public class Enemy extends CollidingBody {

    public Enemy(
            Position position,
            Velocity velocity,
            HitPoint hitPoint
    ) {
        super(
                position,
                Direction.DOWN,
                velocity,
                hitPoint,
                new Damage(1),
                CollidingBodyType.ENEMY
        );
    }
}
