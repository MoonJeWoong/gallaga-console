package gallaga.model.game;

import gallaga.model.collidingbody.CollidingBodyType;

import java.util.List;

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
