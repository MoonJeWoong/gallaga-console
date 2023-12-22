package gallaga.model.collidingbody;

import gallaga.model.wrapper.*;

/**
 * 게임 내 총알을 나타낸다.
 * 총알은 기본 진행 방향이 위쪽이고, 속력, 체력, 파괴력 모두 1인 충돌체이다.
 * 위치는 총알을 발사한 플레이어의 위치를 기준으로 외부에서 계산되어 생성된다.
 */
public class Bullet extends CollidingBody {

    public Bullet(Position position) {
        super(position, Direction.UP, new Velocity(1), new HitPoint(1), new Damage(1), CollidingBodyType.BULLET);
    }
}
