package interfaces;

import gallaga.dto.GameDto;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.game.GameStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * GameStatus를 GameDto로 변환한다.
 * 현재 게임에 존재하는 플레이어, 총알, 적군, 경계선, 빈 공간들울 View와 사전에 약속된 Symbol들로 변환하여 표현한다.
 */
public interface GameStatusToDtoConverter {
    GameDto convertToGameDto(GameStatus gameStatus);
}
