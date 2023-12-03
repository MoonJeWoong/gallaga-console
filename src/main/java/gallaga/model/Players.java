package gallaga.model;

import gallaga.model.wrapper.Position;
import java.util.Map;

public class Players {

    Map<Position, Player> players;

    public Players(Map<Position, Player> players) {
        this.players = players;
    }
}
