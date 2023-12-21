package gallaga.model.game;

/**
 * 게임에서 획득한 점수를 나타낸다.
 */
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
