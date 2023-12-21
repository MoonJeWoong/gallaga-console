package gallaga2.model.game;

import gallaga2.model.wrapper.Direction;

/**
 * 갤러그 게임을 진행한다. 플레이어를 좌우로 움직이거나 총알을 발사하는 사용자의 명령을 처리할 수 있다. 게임 진행 요청이 들어오면 게임의 흐름을 진행시킬 수 있다.
 */
public class Game {

    private Board board;
    private Score score;

    public Game() {
        this.board = new Board();
        this.score = new Score(0);
    }

    public void executeMove(Direction direction) {
        board.movePlayer(direction);
    }

    public void executeFire() {
        board.generateBullet();
    }

    public void executeProgress() {
        // Board를 이용해 충돌 과정을 진행한다.
        // 충돌 결과 제거된 적군의 수 만큼 점수를 추가
        // 체력이 0이된 개체들을 제거 후 남은 개체들을 움직임
        // 새로운 적군을 생성
        board.progressCollision();
        System.out.println(board.countEliminatedEnemies());
        this.score = score.addScore(board.countEliminatedEnemies());
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
