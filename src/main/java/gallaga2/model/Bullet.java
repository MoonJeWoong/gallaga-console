package gallaga2.model;

import gallaga2.model.wrapper.Damage;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.Position;

public class Bullet {

    private Position position;
    private Direction direction;
    private Damage damage;

    public Bullet(Position position) {
        this.position = position;
        this.direction = Direction.UP;
    }

    public void move() {}
}
