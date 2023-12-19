package gallaga2.model.game;

import gallaga2.model.collidingbody.CollidingBodies;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.Position;
import java.util.HashMap;
import java.util.Map;

public class BoardStatus {

    private final Map<Position, CollidingBodyType> boardStatus;

    public BoardStatus() {
        this.boardStatus = new HashMap<>();
    }

    public void putCollidingBodies(CollidingBodies collidingBodies) {
        for (CollidingBody collidingBody : collidingBodies) {
            putCollidingBody(collidingBody);
        }
    }

    public void putCollidingBody(CollidingBody collidingBody) {
        boardStatus.put(collidingBody.getPosition(), collidingBody.getType());
    }

    public Map<Position, CollidingBodyType> getBoardStatus() {
        return boardStatus;
    }
}
