package gallaga.model.wrapper;

public class Column {

    private static final int LEFT_END_COLUMN = 0;
    private static final int RIGHT_END_COLUMN = 6;

    private final int value;

    public Column(int value) {
        this.value = value;
    }

    public Column left(int value) {
        return new Column(this.value - value);
    }

    public Column right(int value) {
        return new Column(this.value + value);
    }

    public boolean isOverLeftEnd() {
        return this.value <= LEFT_END_COLUMN;
    }

    public boolean isOverRightEnd() {
        return this.value >= RIGHT_END_COLUMN;
    }
}
