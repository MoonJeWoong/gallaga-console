package gallaga2.model.game;

import gallaga2.model.wrapper.Position;
import gallaga2.model.collidingbody.CollidingBodies;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import java.util.HashMap;
import java.util.Map;

public class GameStatus {

    private final BoardStatus boardStatus;
    private final Score score;

    public GameStatus(BoardStatus boardStatus, Score score) {
        this.boardStatus = boardStatus;
        this.score = score;
    }


}
