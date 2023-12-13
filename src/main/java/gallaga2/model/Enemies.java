package gallaga2.model;

import java.util.Set;

public class Enemies {

    private Set<Enemy> enemies;

    public Enemies(Set<Enemy> enemies) {
        this.enemies = enemies;
    }

    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    public void move() {
        // 전체 적군들 움직임
    }

    public int countEliminatedEnemies() {
        //현재 적군 중 체력이 0 이하인 개체 수를 반환
        return 0;
    }

    public void removeEliminatedEnemies() {
        // 체력이 0 이하인 적군 제거
    }

    public Set<Enemy> getEnemies() {
        return enemies;
    }
}
