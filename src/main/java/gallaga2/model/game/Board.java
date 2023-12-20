package gallaga2.model.game;

import gallaga2.model.collidingbody.boundary.EnemyGoalBoundary;
import gallaga2.model.collidingbody.boundary.LeftBoundary;
import gallaga2.model.collidingbody.boundary.RightBoundary;
import gallaga2.model.collidingbody.boundary.UpperBoundary;
import gallaga2.model.collidingbody.CollidingBodies;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.player.Player;
import gallaga2.model.wrapper.Column;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.Position;
import gallaga2.model.wrapper.Row;
import gallaga2.util.RandomNumberGenerator;

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

    private void initBoundaries() {
        // 상단 경계선, 좌우 경계선, 적군 목표 경계선 생성
        for (int i = Column.MIN.getValue() + 1; i<Column.MAX.getValue(); i++) {
            boundaries.add(new UpperBoundary(new Position(new Row(0), new Column(i))));
            boundaries.add(new EnemyGoalBoundary(new Position(Row.MAX.up(), new Column(i))));
        }

        for (int i = Row.MIN.getValue(); i<=Row.MAX.getValue(); i++) {
            boundaries.add(new LeftBoundary(new Position(new Row(i), Column.MIN)));
            boundaries.add(new RightBoundary(new Position(new Row(i), Column.MAX)));
        }
    }

    public void movePlayer(Direction direction) {
        player.readyForMoving(direction);
        if (boundaries.isCollidedWith(player)) {
            throw new IllegalArgumentException("플레이어는 경계선을 넘어 이동할 수 없습니다.");
        }
        player.move();
        player.stopMoving();
    }

    public void generateBullet() {
        if (DEFAULT_BULLET_LIMIT <= bullets.size()) {
            throw new IllegalArgumentException(String.format("보드 위의 총알은 %d개를 넘길 수 없습니다.", DEFAULT_BULLET_LIMIT));
        }
        bullets.add(player.fire());
    }

    public void progressCollision() {
        // 플레이어가 좌우 경계선과 충돌했다면, 예외를 발생시키고 더 이상 충돌처리를 진행하지 않는다.
        // 적군, 총알의 충돌 처리
        // 경계선과 총알의 충돌 처리
        // 경계선과 적군의 충돌 처리

        //각각 충돌 진행
        for (CollidingBody enemy : enemies) {
            for (CollidingBody bullet : bullets) {
                if (enemy.isCollidedWith(bullet)) {
                    enemy.collideWith(bullet);
                    bullet.collideWith(enemy);
                }
            }
        }

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

    public void moveCollidingBodies() {
        // 적군과 총알을 다음 위치로 움직인다.
        enemies.move();
        bullets.move();
    }

    public void removeEliminatedCollidingBodies() {
        enemies.removeEliminatedBodies();
        bullets.removeEliminatedBodies();
    }

    public int countEliminatedEnemies() {
        //현재 적군 중 체력이 0 이하인 개체 수를 반환
        return enemies.countEliminatedBodies();
    }

    public boolean isGameOver() {
        // 적군 목표 경계선중에 체력이 0이 된 부분이 있는지 여부를 확인한다.
        return boundaries.countEliminatedBodies() > 0;
    }

    public void generateEnemy() {
        EnemyGenerator enemyGenerator = new EnemyGenerator(new RandomNumberGenerator());
        if (enemyGenerator.isGenerable()) {
            enemies.add(enemyGenerator.generate());
        }
    }

    public BoardStatus getBoardStatus() {
        BoardStatus currentStatus = new BoardStatus();
        currentStatus.putCollidingBody(player);
        currentStatus.putCollidingBodies(bullets);
        currentStatus.putCollidingBodies(enemies);
        currentStatus.putCollidingBodies(boundaries);
        return currentStatus;
    }
}
