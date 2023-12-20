package gallaga2.model.collidingbody;

import gallaga2.model.collidingbody.Bullet;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.*;

public class Player extends CollidingBody {

    private static final Velocity DEFAULT_STOP_VELOCITY = new Velocity(0);
    private static final Velocity DEFAULT_MOVING_VELOCITY = new Velocity(1);

    public Player() {
        super(
                new Position(Row.MAX, new Column(5)),
                Direction.UP,
                new Velocity(0),
                new HitPoint(1),
                new Damage(0),
                CollidingBodyType.PLAYER
        );
    }

    public void readyForMoving(Direction direction) {
        changeDirection(direction);
        changeVelocity(DEFAULT_MOVING_VELOCITY);
    }

    public void stopMoving() {
        changeDirection(Direction.UP);
        changeVelocity(DEFAULT_STOP_VELOCITY);
    }

    public Bullet fire() {
        Position playerPosition = getPosition();
        return new Bullet(playerPosition.move(Direction.UP).move(Direction.UP));
    }
}
