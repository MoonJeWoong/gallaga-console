package interfaces;

import gallaga2.model.wrapper.Direction;

public interface Game {

    void gameInit();
    void getGameStatus();
    boolean isGameOver();
    void move(Direction direction);
    void turnOver();
    void fire();
}
