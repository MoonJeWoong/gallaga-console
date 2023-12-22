package interfaces;

import gallaga.model.board.Board;
import gallaga.model.game.GameStatus;
import gallaga.model.game.Score;
import gallaga.model.wrapper.Direction;

/**
 * 갤러그 게임을 진행한다.
 * 플레이어를 좌우로 움직이거나 총알을 발사하는 사용자의 명령을 처리할 수 있다.
 * 게임 진행 요청이 들어오면 게임의 흐름을 진행시킬 수 있다.
 */
public interface Game {
    void executeMove(Direction direction);
    void executeFire();
    void executeProgress();
    boolean isGameOver();
    GameStatus getGameStatus();
}
