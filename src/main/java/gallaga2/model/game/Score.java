package gallaga2.model.game;

public class Score {

    private final int value;

    public Score(int value) {
        this.value = value;
    }

    public Score addScore(int value) {
        // 점수 합산
        return new Score(this.value + value);
    }

    public void init() {
        // 점수 초기화
    }
}
