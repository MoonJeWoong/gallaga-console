package gallaga.model.wrapper;

import java.util.Objects;

/**
 * 게임의 충돌체들이 가지는 체력의 값을 나타낸다.
 */
public class HitPoint {

    public static final HitPoint MAX = new HitPoint(Integer.MAX_VALUE);

    private final int value;

    public HitPoint(int value) {
        this.value = value;
    }

    public HitPoint decreaseHitPoint(int value) {
        return new HitPoint(this.value - value);
    }

    public boolean isLessOrEqualThanZero() {
        return value <= 0;
    }

    public boolean isGreaterThanZero() {
        return value > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HitPoint hitPoint = (HitPoint) o;
        return value == hitPoint.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
