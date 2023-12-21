package gallaga.model.game;

import gallaga.model.board.Board;
import gallaga.model.wrapper.Direction;

/**
 * 갤러그 게임을 진행한다.
 * 플레이어를 좌우로 움직이거나 총알을 발사하는 사용자의 명령을 처리할 수 있다.
 * 게임 진행 요청이 들어오면 게임의 흐름을 진행시킬 수 있다.
 */
public class Game {

    private Board board;
    private Score score;

    public Game() {
        this.board = new Board();
        this.score = new Score(0);
    }

    /**
     * 플레이어를 특정 방향으로 움직이라는 명령을 처리한다.
     * @param direction 플레이어를 움직이는 방향
     */
    public void executeMove(Direction direction) {
        board.movePlayer(direction);
    }

    /**
     * 총알을 발사하라는 명령을 처리한다.
     */
    public void executeFire() {
        board.generateBullet();
    }

    /**
     * 게임의 흐름을 한 번 진행하라는 명령을 수행한다.
     * 게임에서 한 번의 흐름이 진행될 때, 보드에 현재 존재하는 총알과 적군을 충돌처리하고 점수를 계산한다.
     * 제거되어야 하는 적군과 총알을 제거하고 남은 적군과 총알들을 이동시킨다.
     * 이후 새로운 적군을 생성한다.
     */
    public void executeProgress() {
        board.progressCollision();
        this.score = score.addScore(board.countEliminatedEnemies());
        board.removeEliminatedEnemiesBullets();
        board.moveEnemiesBullets();
        board.generateEnemy();
    }

    /**
     * 게임이 종료되었는지 여부를 확인한다.
     * @return 게임이 종료되었다면 true를 반환한다.
     */
    public boolean isGameOver() {
        return board.isGameOver();
    }

    /**
     * 게임이 현재까지 진행된 상태를 반환한다.
     * @return 게임 보드와 점수 현황 정보
     */
    public GameStatus getGameStatus() {
        return new GameStatus(board.getBoardStatus(), score);
    }
}
