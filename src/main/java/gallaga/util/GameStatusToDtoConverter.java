package gallaga.util;

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
public class GameStatusToDtoConverter {

    private static final String PLAYER_SYMBOL = "player";
    private static final String BULLET_SYMBOL = "bullet";
    private static final String ENEMY_SYMBOL = "enemy";
    private static final String LEFT_BOUNDARY_SYMBOL = "leftBoundary";
    private static final String RIGHT_BOUNDARY_SYMBOL = "rightBoundary";
    private static final String UPPER_BOUNDARY_SYMBOL = "upperBoundary";
    private static final String ENEMY_GOAL_BOUNDARY_SYMBOL = "enemyGoalBoundary";
    private static final String EMPTY_SYMBOL = "empty";
    private static final Map<CollidingBodyType, String> SYMBOL_MAPPER;

    static {
        SYMBOL_MAPPER = new HashMap<>();
        SYMBOL_MAPPER.put(CollidingBodyType.PLAYER, PLAYER_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.BULLET, BULLET_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.ENEMY, ENEMY_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.LEFT_BOUNDARY, LEFT_BOUNDARY_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.RIGHT_BOUNDARY, RIGHT_BOUNDARY_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.UPPER_BOUNDARY, UPPER_BOUNDARY_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.ENEMY_GOAL_BOUNDARY, ENEMY_GOAL_BOUNDARY_SYMBOL);
        SYMBOL_MAPPER.put(CollidingBodyType.EMPTY, EMPTY_SYMBOL);
    }

    /**
     * gameStatus가 갖고 있는 현재 보드와 점수를 변환하여 GameDto를 생성 및 반환한다.
     * 변환 과정에서 보드 상황을 나타내기 위한 CollidingBodyType 리스트를 View와 사전에 약속된 Symbol들의 리스트로 한 줄씩 변환한다.
     * @param gameStatus 현재 보드와 점수 정보를 포함하는 게임의 상태
     * @return View와 약속한 형태로 변환된 게임 정보
     */
    public static GameDto convertToGameDto(GameStatus gameStatus) {
        List<List<CollidingBodyType>> boardStatus = gameStatus.getBoardStatus();
        int score = gameStatus.getScore().getValue();

        List<List<String>> boardLines = new ArrayList<>();
        for (List<CollidingBodyType> row : boardStatus) {
            boardLines.add(convertRowToSymbolLine(row));
        }
        return new GameDto(boardLines, score);
    }

    /**
     * CollidingBodyType 리스트에 해당하는 하나의 행을 View와 사전에 약속된 Symbol들의 리스트로 변환하여 반환한다.
     * @param row CollidingBodyType으로 구성된 1차원 리스트
     * @return View와 사전에 약속된 Symbol들로 변환된 1차원 문자열 리스트
     */
    private static List<String> convertRowToSymbolLine(List<CollidingBodyType> row) {
        List<String> line = new ArrayList<>();
        for (CollidingBodyType collidingBodyType : row) {
            line.add(SYMBOL_MAPPER.get(collidingBodyType));
        }
        return line;
    }
}
