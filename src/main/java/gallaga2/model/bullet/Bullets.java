package gallaga2.model.bullet;

import java.util.Set;

public class Bullets {

    private Set<Bullet> bullets;

    public Bullets(Set<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void add(Bullet bullet) {
        bullets.add(bullet);
    }

    public void move() {
        // 전체 총알들 움직임
    }

    public int countEliminatedBullets() {
        // 현재 총알 중 체력이 0 이하인 개체 수를 반환
        return 0;
    }

    public void removeEliminatedBullets() {
        // 체력이 0 이하인 총알들 제거
    }

    public Set<Bullet> getBullets() {
        return bullets;
    }
}
