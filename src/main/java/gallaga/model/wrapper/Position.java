package gallaga.model.wrapper;

public class Position {

    private Row row;
    private Column column;

    public Position(int row, int column) {
        this.row = new Row(row);
        this.column = new Column(column);
    }

    public void moveUp(int value) {
        Row nextRow = this.row.up(value);
        if (nextRow.isOverTop()) {
            throw new IllegalArgumentException("최상단 행에서 더 위로 갈 수 없습니다.");
        }
        this.row = nextRow;
    }

    public void moveDown(int value) {
        Row nextRow = this.row.down(value);
        if (nextRow.isOverBottom()) {
            throw new IllegalArgumentException("최하단 행에서 더 아래로 갈 수 없습니다.");
        }
        this.row = nextRow;
    }

    public void moveLeft(int value) {
        Column nextColumn = this.column.left(value);
        if (nextColumn.isOverLeftEnd()) {
            throw new IllegalArgumentException("더 왼쪽 열로 갈 수 없습니다.");
        }
        this.column = nextColumn;
    }

    public void moveRight(int value) {
        Column nextColumn = this.column.right(value);
        if (nextColumn.isOverRightEnd()) {
            throw new IllegalArgumentException("더 오른쪽 열로 갈 수 없습니다.");
        }
        this.column = nextColumn;
    }
}
