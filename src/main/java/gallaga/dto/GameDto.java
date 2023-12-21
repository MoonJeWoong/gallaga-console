package gallaga.dto;

import java.util.List;

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