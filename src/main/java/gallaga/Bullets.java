package gallaga;

import gallaga.model.wrapper.Position;

import java.util.List;

public interface Bullets {
    void remove(Position position);
    boolean canFire();
    void fire(Position playerPosition);
    Bullets getNextPositionBullets();
    List<Position> getCurrentPositions();
}
