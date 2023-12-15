package gallaga2.model.game;

import gallaga2.model.boundary.Boundary;
import gallaga2.model.wrapper.*;

public class EnemyGoalBoundary extends Boundary {

    public EnemyGoalBoundary(Position position) {
        super(
                position,
                Direction.UP,
                new Velocity(0),
                new HitPoint(1),
                new Damage(0)
        );
    }
}
