package gallaga2.model.wrapper;

public class HitPoint {

    private final int value;

    public HitPoint(int value) {
        this.value = value;
    }

    public boolean isLessOrEqualThanZero() {
        return value <= 0;
    }

    public HitPoint decreaseHitPoint(int value) {
        return new HitPoint(this.value - value);
    }

    public boolean isGreaterThanZero() {
        return value > 0;
    }
}
