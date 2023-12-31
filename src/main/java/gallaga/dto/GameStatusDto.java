package gallaga.dto;

import gallaga.model.game.Score;
import java.util.List;

/**
 * 게임의 현재 상태를 나타낸다.
 * 현재 게임 보드의 상황 정보와 점수 정보를 포함한다.
 */
public class GameStatusDto {

    private final List<List<String>> boardLines;
    private final int score;

    public GameStatusDto(BoardStatusDto boardStatusDto, Score score) {
        this.boardLines = boardStatusDto.getBoardLines();
        this.score = score.getValue();
    }

    public List<List<String>> getBoardLines() {
        return boardLines;
    }

    public int getScore() {
        return score;
    }
}
