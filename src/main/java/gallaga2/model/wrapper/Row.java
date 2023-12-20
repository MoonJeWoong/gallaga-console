package gallaga2.model.wrapper;

import java.util.Objects;

public class Row {

    public static final Row MAX = new Row(15);
    public static final Row MIN = new Row(0);

    private final int value;

    public Row(int value) {
        this.value = value;
    }

    public Row up() {
        return new Row(value - 1);
    }

    public Row down() {
        return new Row(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Row row = (Row) o;
        return getValue() == row.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
