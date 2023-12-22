package gallaga.model.wrapper;

import java.util.Objects;

public class Position {

    private Row row;
    private Column column;

    public Position(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

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
