package gallaga2.model.wrapper;

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
        throw new IllegalArgumentException("ERROR : 적절하지 못한 방향으로 이동할 수 없습니다.");
    }
}
