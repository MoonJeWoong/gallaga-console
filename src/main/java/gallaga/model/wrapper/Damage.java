package gallaga.model.wrapper;

import java.util.Objects;

/**
 * 게임의 충돌체들이 가지는 파괴력의 값을 나타낸다.
 */
public class Damage {

    private final int value;

    public Damage(int value) {
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
        Damage damage = (Damage) o;
        return getValue() == damage.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
