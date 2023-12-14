package interfaces;

import gallaga2.model.Bullet;

public interface Bullets {

    void add(Bullet bullet);
    void move();
    int countEliminatedBullets();
    void removeEliminatedBullets();
}
