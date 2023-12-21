package gallaga.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 게임 수행 결과로 넘겨받은 Symbol들을 화면에 출력하기 위해 Mark로 변환한다.
 */
public class SymbolToMarkConverter {

    private static final String PLAYER_SYMBOL = "player";
    private static final String BULLET_SYMBOL = "bullet";
    private static final String ENEMY_SYMBOL = "enemy";
    private static final String LEFT_BOUNDARY_SYMBOL = "leftBoundary";
    private static final String RIGHT_BOUNDARY_SYMBOL = "rightBoundary";
    private static final String UPPER_BOUNDARY_SYMBOL = "upperBoundary";
    private static final String ENEMY_GOAL_BOUNDARY_SYMBOL = "enemyGoalBoundary";
    private static final String EMPTY_SYMBOL = "empty";

    private static final String PLAYER_MARK = "⭐";
    private static final String BULLET_MARK = "🔷";
    private static final String ENEMY_MARK = "🟥";
    private static final String LEFT_BOUNDARY_MARK = "|";
    private static final String RIGHT_BOUNDARY_MARK = "|";
    private static final String UPPER_BOUNDARY_MARK = "--";
    private static final String ENEMY_GOAL_BOUNDARY_MARK = "--";
    private static final String EMPTY_MARK = "  ";
    private static final Map<String, String> MARK_MAPPER;

    static {
        MARK_MAPPER = new HashMap<>();
        MARK_MAPPER.put(PLAYER_SYMBOL, PLAYER_MARK);
        MARK_MAPPER.put(BULLET_SYMBOL, BULLET_MARK);
        MARK_MAPPER.put(ENEMY_SYMBOL, ENEMY_MARK);
        MARK_MAPPER.put(LEFT_BOUNDARY_SYMBOL, LEFT_BOUNDARY_MARK);
        MARK_MAPPER.put(RIGHT_BOUNDARY_SYMBOL, RIGHT_BOUNDARY_MARK);
        MARK_MAPPER.put(UPPER_BOUNDARY_SYMBOL, UPPER_BOUNDARY_MARK);
        MARK_MAPPER.put(ENEMY_GOAL_BOUNDARY_SYMBOL, ENEMY_GOAL_BOUNDARY_MARK);
        MARK_MAPPER.put(EMPTY_SYMBOL, EMPTY_MARK);
    }

    public static List<String> convert(List<String> symbols) {
        return symbols.stream()
                .map(MARK_MAPPER::get)
                .collect(Collectors.toList());
    }
}
