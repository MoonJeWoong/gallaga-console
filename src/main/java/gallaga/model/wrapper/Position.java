package gallaga.model.wrapper;

import java.util.Objects;

/**
 * 게임 내 공간의 위치 좌표 값을 나타낸다.
 * 행 좌표와 열 좌표로 구성되며 현재 좌표를 기준으로 특정 방향으로 이동한 좌표를 계산할 수 있다.
 */
public class Position {

    private Row row;
    private Column column;

    public Position(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    /**
     * 현재 좌표 기준에서 주어진 방향으로 움직였을 때 다음 위치를 계산해 반환한다.
     * @param direction 현재 좌표 기준에서 이동할 방향
     * @return 주어진 방향으로 이동했을 때의 위치 좌표
     */
    public Position move(Direction direction) {
        if (direction.equals(Direction.UP)) {
            return new Position(row.up(), column);
        }
        if (direction.equals(Direction.DOWN)) {
            return new Position(row.down(), column);
        }
        if (direction.equals(Direction.LEFT)) {
            return new Position(row, column.left());
        }
        if (direction.equals(Direction.RIGHT)) {
            return new Position(row, column.right());
        }
        throw new IllegalArgumentException("적절하지 못한 방향으로 이동할 수 없습니다.");
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return row.equals(position.row) && column.equals(position.column);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
