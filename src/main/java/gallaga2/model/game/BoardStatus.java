package gallaga2.model.game;

import gallaga2.model.collidingbody.CollidingBodies;
import gallaga2.model.collidingbody.CollidingBody;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.Column;
import gallaga2.model.wrapper.Row;

import java.util.ArrayList;
import java.util.List;

public class BoardStatus {

    private final List<List<CollidingBodyType>> boardStatus;

    public BoardStatus() {
        this.boardStatus = initBoardStatus();
    }

    private List<List<CollidingBodyType>> initBoardStatus() {
        List<List<CollidingBodyType>> initBoardStatus = new ArrayList<>();

        for (int i = Row.MIN.getValue(); i<=Row.MAX.getValue(); i++) {

            List<CollidingBodyType> boardRow = new ArrayList<>();
            for (int j = Column.MIN.getValue(); j<=Column.MAX.getValue(); j++) {
                boardRow.add(CollidingBodyType.EMPTY);
            }
            initBoardStatus.add(boardRow);
        }
        return initBoardStatus;
    }

    public void putCollidingBodies(CollidingBodies collidingBodies) {
        for (CollidingBody collidingBody : collidingBodies) {
            putCollidingBody(collidingBody);
        }
    }

    public void putCollidingBody(CollidingBody collidingBody) {
        List<CollidingBodyType> currentRow = boardStatus.get(collidingBody.getRow().getValue());
        currentRow.set(collidingBody.getColumn().getValue(), collidingBody.getType());
    }

    public List<List<CollidingBodyType>> getBoardStatus() {
        return boardStatus;
    }
}
