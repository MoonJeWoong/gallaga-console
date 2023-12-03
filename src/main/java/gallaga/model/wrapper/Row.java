package gallaga.model.wrapper;

public class Row {

    private static final int TOP_ROW = 0;
    private static final int BOTTOM_ROW = 11;

    private final int value;

    public Row(int value) {
        this.value = value;
    }

    public Row up(int value) {
        return new Row(this.value - value);
    }

    public Row down(int value) {
        return new Row(this.value + value);
    }

    public boolean isOverTop() {
        return this.value <= TOP_ROW;
    }

    public boolean isOverBottom() {
        return this.value >= BOTTOM_ROW;
    }
}
