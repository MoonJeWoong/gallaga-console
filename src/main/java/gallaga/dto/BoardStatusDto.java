package gallaga.dto;

import gallaga.model.collidingbody.CollidingBodies;
import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.Column;
import gallaga.model.wrapper.Row;
import java.util.ArrayList;
import java.util.List;

/**
 * 게임 보드판의 현재 상태를 나타낸다.
 * 보드 내 요소들의 위치를 보드 사이즈에 맞게 2차원 리스트로 나타낸다.
 */
public class BoardStatusDto {

    private final List<List<String>> boardLines;

    public BoardStatusDto() {
        this.boardLines = initBoardLines();
    }

    /**
     * 보드 상태를 나타내기 위한 리스트를 초기화한다.
     * 정해진 보드의 행과 열의 크기에 따라 리스트를 초기화하며 모든 요소 값들을 EMPTY 타입으로 생성한다.
     *
     * @return 보드의 행과 열의 크기에 따라 EMPTY 타입으로 모두 초기화된 2차원 리스트
     */
    private List<List<String>> initBoardLines() {
        List<List<String>> initBoardStatus = new ArrayList<>();

        for (int count = Row.MIN_VALUE; count <= Row.MAX_VALUE; count++) {
            List<String> boardRow = initBoardRow();
            initBoardStatus.add(boardRow);
        }
        return initBoardStatus;
    }

    /**
     * 보드의 행 크기만큼의 리스트를 EMPTY 타입으로 초기화하여 반환한다.
     *
     * @return EMPTY 타입을 요소 값으로 갖는 보드의 행 크기의 리스트
     */
    private List<String> initBoardRow() {
        List<String> boardRow = new ArrayList<>();
        for (int count = Column.MIN_VALUE; count <= Column.MAX_VALUE; count++) {
            boardRow.add(CollidingBodyType.EMPTY.getTypeName());
        }
        return boardRow;
    }

    /**
     * 보드에 존재하는 충돌체 그룹을 위치에 맞게 보드 현황에 나타낸다.
     *
     * @param collidingBodies 보드 현황에 나타낼 충돌체 그룹
     */
    public void putCollidingBodies(CollidingBodies collidingBodies) {
        for (CollidingBody collidingBody : collidingBodies) {
            putCollidingBody(collidingBody);
        }
    }

    /**
     * 보드에 존재하는 충돌체를 위치에 맞게 보드 현황에 나타낸다.
     *
     * @param collidingBody 보드 현황에 나타낼 충돌체
     */
    public void putCollidingBody(CollidingBody collidingBody) {
        List<String> currentRow = boardLines.get(collidingBody.getRow().getValue());
        currentRow.set(collidingBody.getColumn().getValue(), collidingBody.getType().getTypeName());
    }

    public List<List<String>> getBoardLines() {
        return boardLines;
    }
}
