package gallaga.model.wrapper;

public class Score {

    private final int value;

    public Score(int value) {
        this.value = value;
    }

    public Score addScore(int value) {
        return new Score(this.value + value);
    }
}
