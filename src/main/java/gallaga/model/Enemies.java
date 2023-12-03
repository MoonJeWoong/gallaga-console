package gallaga.model;

import gallaga.model.wrapper.Position;
import java.util.Map;

public class Enemies {

    Map<Position, Enemy> enemies;

    public Enemies(Map<Position, Enemy> enemies) {
        this.enemies = enemies;
    }
}
