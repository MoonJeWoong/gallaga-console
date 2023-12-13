package gallaga2.model;

import gallaga2.model.wrapper.Direction;

public class Game {

    private Board board;
    private Score score;

    public Game() {
    }

    public void fire() {
        board.fire();
        turnOver();
    }

    public void move(Direction direction) {
        board.readyForMovingPlayer(direction);
        turnOver();
        board.stopPlayer();
    }

    public void turnOver() {
        // 여기에서 Board를 이용해 턴을 진행하고
        // 결과에서 적군이 피격되어 사라졌을 때 점수를 추가해야 한다.
        board.progressCollision();
        score.addScore(board.countEliminatedEnemies());
        board.removeEliminatedCollidingBodies();
        board.moveCollidingBodies();
    }

    boolean isGameOver() {
        return board.isGameOver();
    }
}
