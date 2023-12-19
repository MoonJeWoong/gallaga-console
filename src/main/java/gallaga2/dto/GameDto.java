package gallaga2.dto;

import java.util.List;

public class GameDto {

    private List<String> boardLines;
    private int score;

    public GameDto(List<String> boardLines, int score) {
        this.boardLines = boardLines;
        this.score = score;
    }

    public List<String> getBoardLines() {
        return boardLines;
    }

    public int getScore() {
        return score;
    }
}
