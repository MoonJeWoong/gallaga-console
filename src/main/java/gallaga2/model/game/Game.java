package gallaga2.model.game;

import gallaga2.dto.GameStatusDto;
import gallaga2.model.wrapper.Direction;

public class Game {

    private Board board;
    private Score score;

    public Game() {
        this.board = new Board();
        this.score = new Score(0);
    }

    public void executeFire() {
        board.generateBullet();
        executeTurnOver();
    }

    public void executeMove(Direction direction) {
        board.readyForMovingPlayer(direction);
        executeTurnOver();
        board.stopPlayer();
    }

    public void executeTurnOver() {
        // 여기에서 Board를 이용해 턴을 진행하고
        // 결과에서 적군이 피격되어 사라졌을 때 점수를 추가해야 한다.
        board.progressCollision();
        score.addScore(board.countEliminatedEnemies());
        board.removeEliminatedCollidingBodies();
        board.moveCollidingBodies();
        board.generateEnemy();
    }

    public boolean isGameOver() {
        return board.isGameOver();
    }

    public GameStatus getGameStatus() {
        return new GameStatus(board.getBoardStatus(), score);
    }
}
