package gallaga2.model.wrapper;

public class Column {

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
