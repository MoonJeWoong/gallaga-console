package interfaces;

import gallaga.model.collidingbody.Bullet;
import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

/**
 * 게임 내 플레이어를 나타낸다.
 * 플레이어는 기본 진행 방향이 위쪽이고, 속력과 파괴력이 0, 체력이 1인 충돌체이다.
 */
public interface Player {
    void readyForMoving(Direction direction);
    void stopMoving();
    Bullet fire();
}
