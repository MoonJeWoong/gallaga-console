package interfaces;

import gallaga.exception.ExceedDefaultBulletLimitException;
import gallaga.exception.MovingPlayerCollidedException;
import gallaga.model.board.BoardStatus;
import gallaga.model.board.EnemyGenerator;
import gallaga.model.collidingbody.CollidingBodies;
import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.Player;
import gallaga.model.collidingbody.boundary.EnemyGoalBoundary;
import gallaga.model.collidingbody.boundary.LeftBoundary;
import gallaga.model.collidingbody.boundary.RightBoundary;
import gallaga.model.collidingbody.boundary.UpperBoundary;
import gallaga.model.wrapper.Column;
import gallaga.model.wrapper.Direction;
import gallaga.model.wrapper.Position;
import gallaga.model.wrapper.Row;
import gallaga.util.RandomNumberGenerator;

/**
 * 갤러그 게임이 진행되는 공간이다. 플레이어, 총알, 적군, 경계선들로 구성되어 있다.
 * 게임 이용자의 명령에 따라 플레이어는 움직일 수 있어야 하고 적군과 발사된 총알은 게임의 흐름이 진행될 때 자동으로 움직인다.
 */
public interface Board {
    void movePlayer(Direction direction);
    void generateBullet();

    void progressCollision();
    void moveEnemiesBullets();
    void removeEliminatedEnemiesBullets();
    int countEliminatedEnemies();

    boolean isGameOver();
    void generateEnemy();
    BoardStatus getBoardStatus();
}
