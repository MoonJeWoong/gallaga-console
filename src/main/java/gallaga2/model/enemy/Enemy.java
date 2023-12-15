package gallaga2.model.enemy;

import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.wrapper.*;

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
                new Damage(1)
        );
    }
}
