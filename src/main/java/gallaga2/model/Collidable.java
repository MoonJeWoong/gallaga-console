package gallaga2.model;

import gallaga2.model.wrapper.Damage;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.HitPoint;
import gallaga2.model.wrapper.Position;
import java.util.List;

public interface Collidable {

    boolean isCollided(Collidable collidable);
    void collide(Damage damage);
//    List<Position> getExpectedRoute();
//    HitPoint getHitPoint();
//    Direction getDirection();
//    Damage getDamage();
}
