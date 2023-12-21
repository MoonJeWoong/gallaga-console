package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

/**
 * 게임 내 경계선들 중 상단 경계선을 나타낸다.
 * 상단 경계선은 윗방향으로 진행하는 총알과 충돌할 수 있기 때문에 기본 진행 방향이 아랫쪽이다.
 * 파괴될 일이 없기 때문에 체력은 무한대이고 총알과 충돌시 총알을 파괴하기 때문에 파괴력이 1이다.
 */
public class UpperBoundary extends Boundary {

    public UpperBoundary(Position position) {
        super(
                position,
                Direction.DOWN,
                new HitPoint(Integer.MAX_VALUE),
                new Damage(1),
                CollidingBodyType.UPPER_BOUNDARY
        );
    }
}
