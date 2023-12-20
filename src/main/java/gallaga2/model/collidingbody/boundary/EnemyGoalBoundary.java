package gallaga2.model.collidingbody.boundary;

import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.*;

public class EnemyGoalBoundary extends Boundary {

    public EnemyGoalBoundary(Position position) {
        super(
                position,
                Direction.UP,
                new HitPoint(1),
                new Damage(0),
                CollidingBodyType.ENEMY_GOAL_BOUNDARY
        );
    }
}
