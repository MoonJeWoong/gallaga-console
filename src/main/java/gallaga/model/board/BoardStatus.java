package gallaga.model.board;

import gallaga.model.collidingbody.CollidingBodies;
import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.Column;
import gallaga.model.wrapper.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * 현재 보드의 상태를 나타낸다.
 */
public class BoardStatus {

    private final List<List<CollidingBodyType>> boardStatus;

    public BoardStatus() {
        this.boardStatus = initBoardStatus();
    }

    /**
     * 보드 상태를 나타내기 위한 리스트를 초기화한다.
     * 정해진 보드의 행과 열의 크기에 따라 리스트를 초기화하며 모든 요소 값들을 EMPTY 타입으로 생성한다.
     * @return 보드의 행과 열의 크기에 따라 EMPTY 타입으로 모두 초기화된 2차원 리스트
     */
    private List<List<CollidingBodyType>> initBoardStatus() {
        List<List<CollidingBodyType>> initBoardStatus = new ArrayList<>();

        for (int i = Row.MIN.getValue(); i<=Row.MAX.getValue(); i++) {
            List<CollidingBodyType> boardRow = initBoardRow();
            initBoardStatus.add(boardRow);
        }
        return initBoardStatus;
    }

    /**
     * 보드의 행 크기만큼의 리스트를 EMPTY 타입으로 초기화하여 반환한다.
     * @return EMPTY 타입을 요소 값으로 갖는 보드의 행 크기의 리스트
     */
    private List<CollidingBodyType> initBoardRow() {
        List<CollidingBodyType> boardRow = new ArrayList<>();
        for (int j = Column.MIN.getValue(); j<=Column.MAX.getValue(); j++) {
            boardRow.add(CollidingBodyType.EMPTY);
        }
        return boardRow;
    }

    /**
     * 보드에 존재하는 충돌체 그룹을 위치에 맞게 보드 현황에 나타낸다.
     * @param collidingBodies 보드 현황에 나타낼 충돌체 그룹
     */
    public void putCollidingBodies(CollidingBodies collidingBodies) {
        for (CollidingBody collidingBody : collidingBodies) {
            putCollidingBody(collidingBody);
        }
    }

    /**
     * 보드에 존재하는 충돌체를 위치에 맞게 보드 현황에 나타낸다.
     * @param collidingBody 보드 현황에 나타낼 충돌체
     */
    public void putCollidingBody(CollidingBody collidingBody) {
        List<CollidingBodyType> currentRow = boardStatus.get(collidingBody.getRow().getValue());
        currentRow.set(collidingBody.getColumn().getValue(), collidingBody.getType());
    }

    public List<List<CollidingBodyType>> getBoardStatus() {
        return boardStatus;
    }
}
