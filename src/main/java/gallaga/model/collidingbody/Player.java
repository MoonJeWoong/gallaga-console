package gallaga.model.collidingbody;

import gallaga.model.wrapper.*;

/**
 * 게임 내 플레이어를 나타낸다.
 * 플레이어는 기본 진행 방향이 위쪽이고, 속력과 파괴력이 0, 체력이 1인 충돌체이다.
 */
public class Player extends CollidingBody {

    private static final Velocity DEFAULT_STOP_VELOCITY = new Velocity(0);
    private static final Velocity DEFAULT_MOVING_VELOCITY = new Velocity(1);

    public Player() {
        super(new Position(Row.MAX, new Column(5)), Direction.UP, new Velocity(0), new HitPoint(1), new Damage(0),
                CollidingBodyType.PLAYER);
    }

    /**
     * 플레이어가 움직일 준비를 한다.
     * 진행 방향은 주어진 방향으로, 속력은 기본 이동 속력으로 업데이트한다.
     * @param direction 업데이트할 진행 방향
     */
    public void readyForMoving(Direction direction) {
        changeDirection(direction);
        changeVelocity(DEFAULT_MOVING_VELOCITY);
    }

    /**
     * 플레이어를 다시 정지된 상태로 업데이트한다.
     * 진행 방향은 위쪽으로, 속력은 0으로 업데이트한다.
     */
    public void stopMoving() {
        changeDirection(Direction.UP);
        changeVelocity(DEFAULT_STOP_VELOCITY);
    }

    /**
     * 플레이어가 총알을 발사한다.
     * 발사된 총알은 플레이어의 현재 위치를 기준으로 2칸 윗 행 위치에 생성된다.
     * @return 플레이어 위치를 기준으로 생성된 새로운 총알
     */
    public Bullet fire() {
        Position playerPosition = getPosition();
        return new Bullet(playerPosition.move(Direction.UP).move(Direction.UP));
    }
}
