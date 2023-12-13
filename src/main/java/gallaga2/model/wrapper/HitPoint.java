package gallaga2.model.wrapper;

public class HitPoint {

    private final int value;

    public HitPoint(int value) {
        this.value = value;
    }

    public HitPoint decreaseHitPoint(int value) {
        return new HitPoint(this.value - value);
    }

    public boolean isGreaterThanZero() {
        return value > 0;
    }
}
