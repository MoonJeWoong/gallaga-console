package interfaces;

import gallaga2.model.boundary.EnemyGoalBoundary;
import gallaga2.model.boundary.LeftBoundary;
import gallaga2.model.boundary.RightBoundary;
import gallaga2.model.boundary.UpperBoundary;
import gallaga2.model.collidingbody.CollidingBodies;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.game.BoardStatus;
import gallaga2.model.game.EnemyGenerator;
import gallaga2.model.player.Player;
import gallaga2.model.wrapper.Column;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.Position;
import gallaga2.model.wrapper.Row;
import gallaga2.util.RandomNumberGenerator;

public class Board {

    private Player player;
    private CollidingBodies bullets;
    private CollidingBodies enemies;
    private CollidingBodies boundaries;

    public Board() {
        this.player = new Player();
        this.bullets = new CollidingBodies();
        this.enemies = new CollidingBodies();
        this.boundaries = new CollidingBodies();
        initBoundaries();
    }

    private void initBoundaries() {
        // 상단 경계선, 좌우 경계선, 적군 목표 경계선 생성 및 초기화
    }

    public void generateBullet() {
        bullets.add(player.fire());
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
        // 충돌 처리 메서드
        // 플레이어가 좌우 경계선과 충돌했다면, 예외를 발생시키고 더 이상 충돌처리를 진행하지 않는다.
        // 적군, 총알의 충돌 처리
        // 경계선과 총알의 충돌 처리
        // 경계선과 적군의 충돌 처리
    }

    public void moveCollidingBodies() {
        // 플레이어와 경계선의 충돌 여부 검사 후 움직임
        // 적군과 총알을 움직인다.

        if (!boundaries.isCollidedWith(player)) {
            player.move();
        }
        enemies.move();
        bullets.move();
    }

    public void removeEliminatedCollidingBodies() {
        // 사라져야 하는 충돌체들을 제거한다.
        enemies.removeEliminatedBodies();

        // 보드에서 사라져야 하는 총알들을 제거하고
        // 플레이어를 재장전 시킨다.
        removeEliminatedBullets();
    }

    private void removeEliminatedBullets() {
        reloadPlayerBullets();
        bullets.removeEliminatedBodies();
    }

    private void reloadPlayerBullets() {
        for (int i=0; i< bullets.countEliminatedBodies(); i++) {
            player.reload();
        }
    }

    public int countEliminatedEnemies() {
        //현재 적군 중 체력이 0 이하인 개체 수를 반환
        return enemies.countEliminatedBodies();
    }

    public boolean isGameOver() {
        // 적군 목표 경계선중에 체력이 0이 된 부분이 있는지 여부를 확인한다.
        return boundaries.countEliminatedBodies() > 0;
    }

    public BoardStatus getBoardStatus() {
        BoardStatus currentStatus = new BoardStatus();
        currentStatus.putCollidingBody(player);
        currentStatus.putCollidingBodies(bullets);
        currentStatus.putCollidingBodies(enemies);
        currentStatus.putCollidingBodies(boundaries);
        return currentStatus;
    }

    public void generateEnemy() {
        EnemyGenerator enemyGenerator = new EnemyGenerator(new RandomNumberGenerator());
        enemies.add(enemyGenerator.generate());
    }
}
