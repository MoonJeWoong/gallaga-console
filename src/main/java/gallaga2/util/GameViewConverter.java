package gallaga2.util;

import gallaga2.dto.GameDto;
import gallaga2.model.game.GameStatus;

public class GameViewConverter {

    public static GameDto convertToGameDto(GameStatus gameStatus) {
        // view에 맞게 boardStatus의 CollidingBodyType 변환해주기
        // Score 값 추출하기
        return new GameDto();
    }
}
