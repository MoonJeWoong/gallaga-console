package gallaga2.model;

import gallaga2.model.wrapper.*;

public class Enemy {

    private Position position;
    private HitPoint hitPoint;
    private Damage damage;
    private Direction direction;
    private Velocity velocity;

    public Enemy(Position position) {
        this.position = position;
    }

    public void move() {}


}
