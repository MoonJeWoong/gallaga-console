package interfaces;

import gallaga2.model.enemy.Enemy;

public interface Enemies {

    void add(Enemy enemy);
    void move();
    int countEliminatedEnemies();
    void removeEliminatedEnemies();
}
