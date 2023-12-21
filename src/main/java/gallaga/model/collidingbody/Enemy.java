package gallaga.model.collidingbody;

import gallaga.model.wrapper.*;

/**
 * 게임 내 적군을 나타낸다.
 * 적군은 기본 진행 방향이 아래쪽이고, 파괴력은 1이지만 위치, 속력, 체력이 외부에서 결정되어 주입되는 충돌체이다.
 */
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
                new Damage(1),
                CollidingBodyType.ENEMY
        );
    }
}
