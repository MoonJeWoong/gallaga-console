package gallaga.util;

import gallaga.dto.GameDto;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.game.GameStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static GameDto convertToGameDto(GameStatus gameStatus) {
        // view에 맞게 boardStatus의 CollidingBodyType 변환해주기
        // Score 값 추출하기
        List<List<CollidingBodyType>> boardStatus = gameStatus.getBoardStatus();
        int score = gameStatus.getScore().getValue();

        List<List<String>> boardLines = new ArrayList<>();
        for (List<CollidingBodyType> row : boardStatus) {
            boardLines.add(convertRowToSymbolLine(row));
        }
        return new GameDto(boardLines, score);
    }

    private static List<String> convertRowToSymbolLine(List<CollidingBodyType> row) {
        List<String> line = new ArrayList<>();
        for (int index = 0; index < row.size(); index++) {
            line.add(SYMBOL_MAPPER.get(row.get(index)));
        }
        return line;
    }
}
