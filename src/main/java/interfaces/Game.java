package interfaces;

import gallaga2.dto.GameStatusDto;
import gallaga2.model.game.Board;
import gallaga2.model.game.Score;
import gallaga2.model.wrapper.Direction;

public class Game {

    private Board board;
    private Score score;

    public Game() {
    }

    public void init() {
        // 게임을 시작할 수 있도록 게임 상태를 초기화한다.
        this.board = new Board();
        this.score = new Score();
    }

    public void executeFire() {
        // 플레이어가 현재 위치에서 총알을 발사한다.
        // 전체 턴을 진행한다.
        board.generateBullet();
        turnOver();
    }

    public void executeMove(Direction direction) {
        // 플레이어가 주어진 방향으로 움직이도록 설정한다.
        // 전체 턴을 진행한다.
        // 플레이어를 정지시킨다.
        board.readyForMovingPlayer(direction);
        turnOver();
        board.stopPlayer();
    }

    public void executeTurnOver() {
        // 남은 전체 턴을 진행시킨다.
        // 게임에서 움직여야 하는 대상들을 움직인다.
        // 총알에 맞아 사라진 적군들은 점수로 더한다.
        // 게임에서 제거되어야 하는 대상들을 제거한다.
        board.progressCollision();
        score.addScore(board.countEliminatedEnemies());
        board.removeEliminatedCollidingBodies();
        board.moveCollidingBodies();
    }

    public boolean isGameOver() {
        // 게임이 종료되었는지 확인한다.
        return board.isGameOver();
    }

    public GameStatusDto getGameStatus() {
        // 현재 게임 상태를 확인한다.
        return new GameStatusDto();
    }
}
