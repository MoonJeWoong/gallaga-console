package gallaga2.model.wrapper;

public class Column {

    public static final int MAX_VALUE = 10;
    public static final int MIN_VALUE = 0;

    private final int value;

    public Column(int value) {
        this.value = value;
    }

    public Column left() {
        return new Column(value - 1);
    }

    public Column right() {
        return new Column(value + 1);
    }
}
