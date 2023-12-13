package gallaga2.model;

import gallaga2.model.wrapper.Direction;
import gallaga2.util.RandomNumberGenerator;

import java.util.Set;

public class Board {

    private Player player;
    private Bullets bullets;
    private Enemies enemies;
    private Boundaries boundaries;

    public Board() {
        this.player = new Player();
        this.bullets = new Bullets();
        this.enemies = new Enemies();
        this.boundaries = new Boundaries();
    }

    public void fire() {
        // 플레이어가 총알을 발사한다.
        Bullet firedBullet = player.fire();
        bullets.add(firedBullet);
    }

    public void readyForMovingPlayer(Direction direction) {
        // 플레이어를 입력받은 방향으로 1의 속도로 움직이도록 업데이트한다.
        player.readyForMoving(direction);
    }

    public void stopPlayer() {
        // 플레이어가 다시 윗방향으로 0의 속도를 갖도록 업데이트한다.
        player.stopMoving();
    }

    public void progressCollision() {
        // 충돌 처리 메서드 (progressCollision)
            // 적군, 총알의 충돌 처리
            // 경계선과 총알의 충돌 처리
            // 경계선과 적군의 충돌 처리
        Set<Enemy> currentEnemies = enemies.getEnemies();
        Set<Bullet> currentBullets = bullets.getBullets();
        Set<Boundary> currentBoundaries = boundaries.getBoundaries();

        //각각 충돌 진행

        if (enemy.isCollidedWith(bullet)) {
            enemy.collideWith(bullet);
            bullet.collideWith(enemy);
        }

        if (bullet.isCollidedWith(boundary)) {
            bullet.collideWith(boundary);
        }

        if (boundary.isCollidedWith(enemy)) {
            boundary.collideWith(enemy);
        }

        enemies = new Enemies(currentEnemies);
        bullets = new Bullets(currentBullets);
        boundaries = new Boundaries(currentBoundaries);
    }

    public void moveCollidingBodies() {
        enemies.move();
        bullets.move();
        // 플레이어와 경계선의 충돌 여부 검사
        // 충돌하면 플레이어는 움직이지 않음
        // 충돌하지 않으면 플레이어는 움직임
        if (!boundaries.isCollidedWith(player)) {
            player.move();
        }
    }

    public void removeEliminatedCollidingBodies() {
        enemies.removeEliminatedEnemies();
        removeEliminatedBullets();
    }

    private void removeEliminatedBullets() {
        for (int i=0; i< bullets.countEliminatedBullets(); i++) {
            player.reload();
        }
        bullets.removeEliminatedBullets();
    }

    public int countEliminatedEnemies() {
        //현재 적군 중 체력이 0 이하인 개체 수를 반환
        return enemies.countEliminatedEnemies();
    }

    public boolean isGameOver() {
        // 적군 목표 경계선중에 체력이 0이 된 부분이 있는지 여부를 확인한다.
        return boundaries.countEliminatedBoundaries() > 0;
    }

    public void generateEnemy() {
        EnemyGenerator enemyGenerator = new EnemyGenerator(new RandomNumberGenerator());
        Enemy newEnemy = enemyGenerator.generate();
        enemies.add(newEnemy);
    }
}
