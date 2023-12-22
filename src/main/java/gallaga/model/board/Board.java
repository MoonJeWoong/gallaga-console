package gallaga.model.board;

import gallaga.exception.ExceedDefaultBulletLimitException;
import gallaga.exception.MovingPlayerCollidedException;
import gallaga.model.collidingbody.boundary.EnemyGoalBoundary;
import gallaga.model.collidingbody.boundary.LeftBoundary;
import gallaga.model.collidingbody.boundary.RightBoundary;
import gallaga.model.collidingbody.boundary.UpperBoundary;
import gallaga.model.collidingbody.CollidingBodies;
import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.Player;
import gallaga.model.wrapper.Column;
import gallaga.model.wrapper.Direction;
import gallaga.model.wrapper.Position;
import gallaga.model.wrapper.Row;
import gallaga.util.RandomNumberGenerator;

/**
 * 갤러그 게임이 진행되는 공간이다. 플레이어, 총알, 적군, 경계선들로 구성되어 있다.
 * 게임 이용자의 명령에 따라 플레이어는 움직일 수 있어야 하고 적군과 발사된 총알은 게임의 흐름이 진행될 때 자동으로 움직인다.
 */
public class Board {

    private static final int DEFAULT_BULLET_LIMIT = 3;

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

    /**
     * 보드를 초기화하는 과정에서 상단, 좌우, 적군 목표 경계선들을 각 위치에 맞춰 생성한다.
     */
    private void initBoundaries() {
        for (int i = Column.MIN.getValue() + 1; i<Column.MAX.getValue(); i++) {
            boundaries.add(new UpperBoundary(new Position(new Row(0), new Column(i))));
            boundaries.add(new EnemyGoalBoundary(new Position(Row.MAX.up(), new Column(i))));
        }

        for (int i = Row.MIN.getValue(); i<=Row.MAX.getValue(); i++) {
            boundaries.add(new LeftBoundary(new Position(new Row(i), Column.MIN)));
            boundaries.add(new RightBoundary(new Position(new Row(i), Column.MAX)));
        }
    }

    /**
     * 플레이어를 주어진 방향으로 1칸 이동한다.
     * @param direction 플레이어를 1칸 이동시킬 방향
     */
    public void movePlayer(Direction direction) {
        player.readyForMoving(direction);
        if (boundaries.isCollidedWith(player)) {
            throw new MovingPlayerCollidedException();
        }
        player.move();
        player.stopMoving();
    }

    /**
     * 새로운 총알을 하나 생성한다.
     * 보드에 이미 존재하는 총알의 개수가 상한이라면 예외처리된다.
     */
    public void generateBullet() {
        if (DEFAULT_BULLET_LIMIT <= bullets.size()) {
            throw new ExceedDefaultBulletLimitException(DEFAULT_BULLET_LIMIT);
        }
        bullets.add(player.fire());
    }

    /**
     * 게임의 흐름이 한 번 진행되는 과정에서 수행되어야 할 충돌처리를 진행한다.
     * 적군과 총알의 충돌처리를 진행한다.
     * 이후 경계선과 총알, 적군과 경계선의 충돌을 각각 진행한다.
     */
    public void progressCollision() {
        progressEnemyBulletCollisions();
        progressBoundaryCollisions();
    }

    /**
     * 보드에 현재 존재하는 적군과 총알들의 충돌처리를 진행한다.
     */
    private void progressEnemyBulletCollisions() {
        for (CollidingBody enemy : enemies) {
            for (CollidingBody bullet : bullets) {
                if (enemy.isCollidedWith(bullet)) {
                    enemy.collideWith(bullet);
                    bullet.collideWith(enemy);
                }
            }
        }
    }

    /**
     * 보드에 현재 존재하는 경계선들과 적군, 총알들의 충돌처리를 각각 진행한다.
     */
    private void progressBoundaryCollisions() {
        for (CollidingBody boundary : boundaries) {
            for (CollidingBody bullet: bullets) {
                if (boundary.isCollidedWith(bullet)) {
                    bullet.collideWith(boundary);
                }
            }
            for (CollidingBody enemy : enemies) {
                if (boundary.isCollidedWith(enemy)) {
                    boundary.collideWith(enemy);
                }
            }
        }
    }

    /**
     * 적군과 총알을 다음 위치로 움직인다.
     */
    public void moveEnemiesBullets() {
        //
        enemies.move();
        bullets.move();
    }

    /**
     * 체력이 0이하가 된 적군과 총알들을 보드에서 제거한다.
     */
    public void removeEliminatedEnemiesBullets() {
        enemies.removeEliminatedBodies();
        bullets.removeEliminatedBodies();
    }

    /**
     * 적군들 중 체력이 0 이하가 된 수를 반환한다.
     * @return 체력이 0 이하인 적군의 수
     */
    public int countEliminatedEnemies() {
        return enemies.countEliminatedBodies();
    }

    /**
     * 게임이 종료되었는지 판별한다.
     * 적군에 의해 파괴된 적군 목표 경계선이 존재한다면, 게임이 종료된다.
     * @return 현재 파괴된 적군 목표 경계선이 존재한다면 true를 반환
     */
    public boolean isGameOver() {
        return boundaries.countEliminatedBodies() > 0;
    }

    /**
     * 일정 확률에 따라 보드에 새로운 적군을 생성한다.
     */
    public void generateEnemy() {
        EnemyGenerator enemyGenerator = new EnemyGenerator(new RandomNumberGenerator());
        if (enemyGenerator.isGenerable()) {
            enemies.add(enemyGenerator.generate());
        }
    }

    /**
     * 현재 보드의 상태를 반환한다.
     * 보드의 현재 상태는 플레이어, 적군, 총알, 경계선들의 위치와 타입을 포함한다.
     * @return 플레이어, 적군, 총알, 경계선들의 위치와 타입을 포함하는 보드의 현재 상태
     */
    public BoardStatus getBoardStatus() {
        BoardStatus currentStatus = new BoardStatus();
        currentStatus.putCollidingBody(player);
        currentStatus.putCollidingBodies(bullets);
        currentStatus.putCollidingBodies(enemies);
        currentStatus.putCollidingBodies(boundaries);
        return currentStatus;
    }
}
