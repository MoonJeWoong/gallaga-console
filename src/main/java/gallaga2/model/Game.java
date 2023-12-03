package gallaga2.model;

public class Game {

    private Board board;
    private Score score;

    public Game() {
    }

    // 커맨드를 받아서 내부적으로 명령을 수행하도록 해야하나?

    void fire() {}

    void progressTurn() {}

    void movePlayer() {}

    boolean isGameOver() {return false;}
}
