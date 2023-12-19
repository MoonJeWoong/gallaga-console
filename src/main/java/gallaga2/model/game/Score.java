package gallaga2.model.game;

public class Score {

    private static final int DEFAULT_ENEMY_SCORE = 100;

    private final int value;

    public Score(int value) {
        this.value = value;
    }

    public Score addScore(int value) {
        return new Score(this.value + value * DEFAULT_ENEMY_SCORE);
    }

    public int getValue() {
        return value;
    }
}
