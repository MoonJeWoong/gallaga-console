package gallaga2.model.game;

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
        // Board를 이용해 충돌 과정을 진행한다.
        // 충돌 결과 제거된 적군의 수 만큼 점수를 추가
        // 체력이 0이된 개체들을 제거 후 남은 개체들을 움직임
        // 새로운 적군을 생성
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
