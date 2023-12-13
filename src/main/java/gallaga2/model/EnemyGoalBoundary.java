package gallaga2.model;

import gallaga2.model.wrapper.*;

public class EnemyGoalBoundary extends Boundary {

    public EnemyGoalBoundary(Position position, Direction direction, Velocity velocity, HitPoint hitPoint, Damage damage) {
        super(position, Direction.UP, new Velocity(0), new HitPoint(1), new Damage(0));
    }
}
