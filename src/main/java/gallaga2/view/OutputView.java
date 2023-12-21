package gallaga2.view;

import gallaga2.dto.GameDto;

import java.util.List;

/**
 * 갤러그 프로그램에서 모든 화면 출력을 수행한다.
 */
public class OutputView {

    private static final String SCORE_LINE_FORMAT = "현재 점수 : %d\n";
    private static final String GAME_ENDED_MESSAGE = "적군이 목표 경계선을 돌파해 게임이 종료되었습니다.";
    private static final String ALERT_MESSAGE_FORMAT = """
            **********************************************************
            [SYSTEM] %s
            **********************************************************\n
            """;

    /**
     * 현재 게임에 대한 정보를 기반으로 화면에 게임 현황을 출력한다.
     * @param gameDto 현재 게임에 대한 정보가 담겨있는 dto
     */
    public static void printGameScreen(GameDto gameDto) {
        // 기존 화면 출력 제거
        clearExistedView();

        System.out.printf(SCORE_LINE_FORMAT, gameDto.getScore());
        for (List<String> line : gameDto.getBoardLines()) {
            // gameDto로부터 넘겨받은 심볼 정보들을 출력을 위한 기호로 변환 후 출력한다.
            List<String> convertedLine = SymbolToMarkConverter.convert(line);
            System.out.println(String.join("", convertedLine));
        }
    }

    /**
     * 기존 화면을 지운다.
     */
    private static void clearExistedView() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    /**
     * 게임 진행 도중 발생한 메세지를 출력한다.
     * @param message
     */
    public static void printAlertMessage(String message) {
        // 게임 진행 도중 발생하는 알림 메세지를 출력한다.
        System.out.printf(ALERT_MESSAGE_FORMAT, message);
    }

    /**
     * 게임 종료 메세지를 출력한다.
     */
    public static void printGameEndedMessage() {
        System.out.printf(ALERT_MESSAGE_FORMAT, GAME_ENDED_MESSAGE);
    }
}
