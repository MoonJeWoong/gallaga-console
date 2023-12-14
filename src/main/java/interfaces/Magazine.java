package interfaces;

import gallaga2.model.Bullet;
import gallaga2.model.wrapper.Position;

public interface Magazine {

    Bullet takeOneBullet(Position position);
    void reloadOneBullet();
    boolean isBulletLeft();
}
