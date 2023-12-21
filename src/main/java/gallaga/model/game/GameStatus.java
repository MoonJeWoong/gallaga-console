package gallaga.model.game;

import gallaga.model.board.BoardStatus;
import gallaga.model.collidingbody.CollidingBodyType;

import java.util.List;

/**
 * 게임의 현재 상태를 나타낸다.
 * 현재 게임 보드판의 상황 정보와 점수 정보를 포함한다.
 */
public class GameStatus {

    private final BoardStatus boardStatus;
    private final Score score;

    public GameStatus(BoardStatus boardStatus, Score score) {
        this.boardStatus = boardStatus;
        this.score = score;
    }

    public List<List<CollidingBodyType>> getBoardStatus() {
        return boardStatus.getBoardStatus();
    }

    public Score getScore() {
        return score;
    }
}
