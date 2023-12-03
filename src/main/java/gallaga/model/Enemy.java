package gallaga.model;

import gallaga.model.wrapper.HitPoint;
import gallaga.model.wrapper.Position;
import gallaga.model.wrapper.Velocity;
import java.util.ArrayList;
import java.util.List;

public class Enemy {

    private HitPoint hitPoint;
    private Velocity velocity;

    public Enemy(HitPoint hitPoint, Velocity velocity) {
        this.hitPoint = hitPoint;
        this.velocity = velocity;
    }

    public void hit(Bullet bullet) {
        this.hitPoint = this.hitPoint.decrease(bullet.getDamage());
    }

    public List<Position> calculatePath(Position start) {
        List<Position> path = new ArrayList<>();
        for (int i=1; i<velocity.getValue(); i++) {
            path.add();
        }
    }
}
