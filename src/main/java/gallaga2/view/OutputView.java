package gallaga2.view;

import gallaga2.dto.GameDto;

public class OutputView {

    private static final String SCORE_LINE_FORMAT = "현재 점수 : %d\n";

    public static void printGameScreen(GameDto gameDto) {
        // 현재 게임 상태에 따른 화면을 출력한다.
        // 점수 라인 출력
        // 보드 출력
        System.out.printf(SCORE_LINE_FORMAT, gameDto.getScore());
        for (String line : gameDto.getBoardLines()) {
            System.out.println(line);
        }
    }
    public static void printAlertMessage(String message) {
        // 게임 진행 도중 발생하는 알림 메세지를 출력한다.
    }
}
