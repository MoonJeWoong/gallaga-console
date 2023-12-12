package gallaga2.model;

import gallaga2.model.wrapper.Damage;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.HitPoint;
import gallaga2.model.wrapper.Position;
import java.util.List;

public abstract class CollidingBody implements Collidable {

    private Position position;
    private HitPoint hitPoint;
    private Direction direction;
    private Damage damage;

    @Override
    public boolean isCollided(Collidable collidable) {
        return false;
    }

    @Override
    public void collide(Damage damage) {

    }

    public boolean isCollidedWithOther(CollidingBody other) {
        return false;
    }

//    public List<Position> getExpectedRoute() {
//        return null;
//    }
//
//    public HitPoint getHitPoint() {
//        return null;
//    }
//
//    public Direction getDirection() {
//        return null;
//    }
//
//    public Damage getDamage() {
//        return null;
//    }
}
