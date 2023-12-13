package gallaga2.model;

import gallaga2.model.wrapper.*;

public class Player extends CollidingBody {

    private Magazine magazine;

    public Player() {
        super(new Position(new Row(0), new Column(0)), Direction.UP, new Velocity(0), new HitPoint(1), new Damage(0));
    }

    public Bullet fire() {
        // 플레이어의 탄창에 총알이 남아 있으면 총알을 쏠 수 있다.
        return magazine.makeOneBullet(getPosition());
    }

    public void reload() {
        magazine.reloadOneBullet();
    }

    public void readyForMoving(Direction direction) {
        // LEFT or RIGHT 이면 움직이고 UP or DOWN이면 예외처리?
        this.direction = direction;
        this.velocity = new Velocity(1);
    }

    public void stopMoving() {
        this.direction = Direction.UP;
        this.velocity = new Velocity(0);
    }
}
