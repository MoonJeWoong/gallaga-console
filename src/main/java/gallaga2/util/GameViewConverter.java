package gallaga2.util;

import gallaga2.dto.GameDto;
import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.game.GameStatus;
import gallaga2.model.wrapper.Column;
import gallaga2.model.wrapper.Position;
import gallaga2.model.wrapper.Row;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameViewConverter {

    private static final String PLAYER_SYMBOL = "⭐";
    private static final String BULLET_SYMBOL = "🔷";
    private static final String ENEMY_SYMBOL = "🟥";
    private static final String LEFT_BOUNDARY_SYMBOL = "|";
    private static final String RIGHT_BOUNDARY_SYMBOL = "|";
    private static final String UPPER_BOUNDARY_SYMBOL = "--";
    private static final String ENEMY_GOAL_BOUNDARY_SYMBOL = "--";
    private static final String EMPTY_SYMBOL = "  ";
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
    }

    public static GameDto convertToGameDto(GameStatus gameStatus) {
        // view에 맞게 boardStatus의 CollidingBodyType 변환해주기
        // Score 값 추출하기
        Map<Position, CollidingBodyType> boardStatus = gameStatus.getBoardStatus();
        int score = gameStatus.getScore().getValue();

        List<String> convertedBoardLines = new ArrayList<>();
        for (int i=Row.MIN.getValue(); i<=Row.MAX.getValue(); i++) {
            StringBuilder line = new StringBuilder();
            for (int j= Column.MIN.getValue(); j<=Column.MAX.getValue(); j++) {
                Position position = new Position(new Row(i), new Column(j));
                line.append(SYMBOL_MAPPER.getOrDefault(boardStatus.get(position), EMPTY_SYMBOL));
            }
            convertedBoardLines.add(line.toString());
        }

        return new GameDto(convertedBoardLines, score);
    }
}
