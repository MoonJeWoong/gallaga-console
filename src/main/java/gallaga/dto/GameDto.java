package gallaga.dto;

import java.util.List;

/**
 * 게임의 현황 정보를 전달하기 위한 dto이다.
 */
public class GameDto {

    private List<List<String>> boardLines;
    private int score;

    public GameDto(List<List<String>> boardLines, int score) {
        this.boardLines = boardLines;
        this.score = score;
    }

    public List<List<String>> getBoardLines() {
        return boardLines;
    }

    public int getScore() {
        return score;
    }
}
