package gallaga.model;

import gallaga.model.wrapper.Position;
import java.util.Map;

public class Bullets {

    Map<Position, Bullet> bullets;

    public Bullets(Map<Position, Bullet> bullets) {
        this.bullets = bullets;
    }

    public void remove(Position position) {
        bullets.remove(position);
    }
}
