package gallaga2.model.wrapper;

public class Row {

    public static final int MAX_VALUE = 20;
    public static final int MIN_VALUE = 0;

    private final int value;

    public Row(int value) {
        this.value = value;
    }

    public Row up() {
        return new Row(value + 1);
    }

    public Row down() {
        return new Row(value - 1);
    }
}
