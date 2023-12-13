package gallaga2.model;

import gallaga2.model.wrapper.*;

public class Player extends CollidingBody {

    public Player() {
        super(
                new Position(new Row(5), new Column(5)),
                Direction.UP,
                new Velocity(0),
                new HitPoint(0),
                new Damage(0)
        );
    }
}
