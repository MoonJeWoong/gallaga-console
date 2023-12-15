package gallaga2.util;

import gallaga2.dto.GameDto;
import gallaga2.dto.GameStatusDto;

public class GameViewConverter {

    public static GameDto convertToGameDto(GameStatusDto gameStatusDto) {
        return new GameDto();
    }
}
