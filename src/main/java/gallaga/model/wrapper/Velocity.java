package gallaga.model.wrapper;

import java.util.Objects;

public class Velocity {
    private int value;

    public Velocity(int value) {
        this.value = value;
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
        Velocity velocity = (Velocity) o;
        return getValue() == velocity.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
