package interfaces;

import gallaga2.model.bullet.Bullet;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.player.Magazine;
import gallaga2.model.wrapper.Column;
import gallaga2.model.wrapper.Damage;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.HitPoint;
import gallaga2.model.wrapper.Position;
import gallaga2.model.wrapper.Row;
import gallaga2.model.wrapper.Velocity;

public class Player extends CollidingBody {

    private static final Velocity DEFAULT_STOP_VELOCITY = new Velocity(0);
    private static final Velocity DEFAULT_MOVING_VELOCITY = new Velocity(1);

    private Magazine magazine;

    public Player() {
        super(
                new Position(new Row(5), new Column(5)),
                Direction.UP,
                new Velocity(0),
                new HitPoint(0),
                new Damage(0),
                CollidingBodyType.PLAYER
        );
        this.magazine = new Magazine();
    }

    public Bullet fire() {
        return magazine.makeOneBullet(getPosition());
    }

    public void readyForMoving(Direction direction) {
        changeDirection(direction);
        changeVelocity(DEFAULT_MOVING_VELOCITY);
    }

    public void stopMoving() {
        changeDirection(Direction.UP);
        changeVelocity(DEFAULT_STOP_VELOCITY);
    }

    public void reload() {
        magazine.reloadOneBullet();
    }
}
