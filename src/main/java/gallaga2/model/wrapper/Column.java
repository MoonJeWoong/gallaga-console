package gallaga2.model.wrapper;

import java.util.Objects;

public class Column {

    public static final Column MAX = new Column(10);
    public static final Column MIN = new Column(0);

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
        Column column = (Column) o;
        return getValue() == column.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
