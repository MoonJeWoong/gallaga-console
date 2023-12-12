package gallaga2.model;

import gallaga.model.wrapper.Damage;
import gallaga.model.wrapper.Position;

public class Boundary {

    private Position position;
    private Damage damage;

    public Boundary(Position position, Damage damage) {
        this.position = position;
        this.damage = damage;
    }
}
