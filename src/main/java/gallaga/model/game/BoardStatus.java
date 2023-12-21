package gallaga.model.game;

import gallaga.model.collidingbody.CollidingBodies;
import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.Column;
import gallaga.model.wrapper.Row;

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
