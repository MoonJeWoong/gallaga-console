package gallaga2.model.game;

import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.Position;
import java.util.Map;

public class GameStatus {

    private final BoardStatus boardStatus;
    private final Score score;

    public GameStatus(BoardStatus boardStatus, Score score) {
        this.boardStatus = boardStatus;
        this.score = score;
    }

    public Map<Position, CollidingBodyType> getBoardStatus() {
        return boardStatus.getBoardStatus();
    }

    public Score getScore() {
        return score;
    }
}
