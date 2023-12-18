package interfaces;

import gallaga2.model.game.GameStatus;
import gallaga2.model.wrapper.Direction;

public interface Model {

    void gameInit();
    GameStatus getGameStatus();
    boolean isGameOver();
    void executeMove(Direction direction);
    void executeTurnOver();
    void executeFire();
}
