package gallaga2.controller;

import gallaga2.dto.GameDto;
import gallaga2.model.game.Game;
import gallaga2.model.wrapper.Direction;
import gallaga2.util.GameViewConverter;
import gallaga2.view.InputCommand;
import gallaga2.view.InputView;
import gallaga2.view.OutputView;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * View와 Model을 이용해 갤러그 프로그램의 전체 흐름을 제어한다.
 */

public class Controller {


    /**
     * 갤러그 프로그램의 시작점
     *
     * 게임 상태 초기화
     * 게임 첫 화면 출력
     * 게임 턴 자동 진행 타이머 시작
     * 반복문 진입
     * 사용자 입력 대기
     * Command 값에 따른 메서드 수행 분기 처리
     * 처리된 결과를 OutputView로 출력
     * 게임이 종료될 때까지 반복
     */
    public void run() {
        // 게임 상태 초기화
        Game game = new Game();
        GameDto gameDto = GameViewConverter.convertToGameDto(game.getGameStatus());
        OutputView.printGameScreen(gameDto);

        // 게임 자동 진행 타이머 시작
        startAutoTurnOverScheduler(game);

        // 게임 시작
        while (!game.isGameOver()) {  // 게임 종료 전까지 반복
            try {
                InputCommand inputCommand = InputView.inputCommand();

                // Command 값에 따른 메서드 수행 분기 처리
                executeCommand(game, inputCommand);

                gameDto = GameViewConverter.convertToGameDto(game.getGameStatus());
                OutputView.printGameScreen(gameDto);
            } catch (Exception e) {
                OutputView.printAlertMessage(e.getMessage());
            }
        }
        OutputView.printGameEndedMessage();
    }

    /**
     *
     * @param game
     */
    private void startAutoTurnOverScheduler(Game game) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            game.executeTurnOver();
            OutputView.printGameScreen(GameViewConverter.convertToGameDto(game.getGameStatus()));
            if (game.isGameOver()) {
                scheduler.shutdown();
                OutputView.printGameEndedMessage();
                System.exit(0);
            }
        }, 2000, 2000, TimeUnit.MILLISECONDS);
    }

    /**
     *
     *
     * @param game
     * @param inputCommand
     */
    private void executeCommand(Game game, InputCommand inputCommand) {
        if (inputCommand.equals(InputCommand.MOVE_LEFT)) {
            game.executeMove(Direction.LEFT);
            return;
        }
        if (inputCommand.equals(InputCommand.MOVE_RIGHT)) {
            game.executeMove(Direction.RIGHT);
            return;
        }
        if (inputCommand.equals(InputCommand.FIRE)) {
            game.executeFire();
        }
    }
}
