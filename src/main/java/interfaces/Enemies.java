package interfaces;

import gallaga2.model.Enemy;

public interface Enemies {

    void add(Enemy enemy);
    void move();
    int countEliminatedEnemies();
    void removeEliminatedEnemies();
}
