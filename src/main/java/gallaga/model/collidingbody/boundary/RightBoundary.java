package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

/**
 * 게임 내 경계선들 중 우측 경계선을 나타낸다.
 * 우측 경계선은 우측 방향으로 움직이는 플레이어와 충돌할 수 있기 때문에 기본 진행 방향이 왼쪽이다.
 * 파괴될 일이 없기 때문에 체력은 무한대이고 플레이어와 충돌하더라도 피해를 주지 않기 때문에 파괴력이 0이다.
 */
public class RightBoundary extends Boundary {

    public RightBoundary(Position position) {
        super(
                position,
                Direction.LEFT,
                new HitPoint(Integer.MAX_VALUE),
                new Damage(0),
                CollidingBodyType.RIGHT_BOUNDARY
        );
    }
}
