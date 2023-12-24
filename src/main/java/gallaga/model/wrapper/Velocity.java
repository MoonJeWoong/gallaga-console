package gallaga.model.wrapper;

import java.util.Objects;

/**
 * 게임의 충돌체들이 가지는 속력의 값을 나타낸다.
 */
public class Velocity {

    public static final Velocity ZERO = new Velocity(0);

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
