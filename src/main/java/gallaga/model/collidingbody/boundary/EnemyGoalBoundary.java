package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.Damage;
import gallaga.model.wrapper.Direction;
import gallaga.model.wrapper.HitPoint;
import gallaga.model.wrapper.Position;

/**
 * 게임 내 경계선들 중 적군 목표 경계선을 나타낸다.
 * 적군 목표 경계선은 아랫방향으로 진행하는 적군과 충돌할 수 있기 때문에 기본 진행 방향이 윗쪽이다.
 * 적군과 충돌하면 파괴되어야 하기 때문에 체력이 1이며, 충돌하더라도 피해를 줄 필요가 없기에 파괴력이 0이다.
 * 게임 내에 초기화됐던 적군 목표 경계선이 하나라도 파괴되면 게임이 종료된다.
 */
public class EnemyGoalBoundary extends Boundary {

    public EnemyGoalBoundary(Position position) {
        super(position, Direction.UP, new HitPoint(1), new Damage(0), CollidingBodyType.ENEMY_GOAL_BOUNDARY);
    }
}
