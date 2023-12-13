package gallaga2.model;

import gallaga2.model.wrapper.*;

public class Bullet extends CollidingBody {


    public Bullet(Position position) {
        super(position, Direction.UP, new Velocity(1), new HitPoint(1), new Damage(1));
    }
}
