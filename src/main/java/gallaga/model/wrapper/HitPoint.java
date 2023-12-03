package gallaga.model.wrapper;

public class HitPoint {

    private final int value;

    public HitPoint(int value) {
        this.value = value;
    }

    public HitPoint decrease(int value) {
        return new HitPoint(value);
    }
}
