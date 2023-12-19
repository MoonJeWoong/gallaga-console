package gallaga2.controller;

import gallaga2.dto.CommandDto;
import gallaga2.dto.GameDto;
import gallaga2.model.game.Game;
import gallaga2.model.wrapper.Direction;
import gallaga2.util.GameViewConverter;
import gallaga2.view.InputCommand;
import gallaga2.view.InputView;
import gallaga2.view.OutputView;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    public void run() {
        // 게임 상태 초기화
        Game game = new Game();
        GameDto gameDto = GameViewConverter.convertToGameDto(game.getGameStatus());
        OutputView.printGameScreen(gameDto);


        // 타이머 시작
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                OutputView.printGameScreen(GameViewConverter.convertToGameDto(game.getGameStatus()));
            }
        };
        timer.schedule(timerTask, 2000, 2000);


        // 게임 시작
        while (game.isGameOver()) {  // 게임 종료 전까지 반복
            CommandDto commandDto = InputView.inputCommand();
            InputCommand inputCommand = commandDto.getCommand();

            // Command 값에 따른 메서드 수행 분기 처리
            executeCommand(game, inputCommand);

            gameDto = GameViewConverter.convertToGameDto(game.getGameStatus());
            OutputView.printGameScreen(gameDto);
        }
    }

    private void executeCommand(Game game, InputCommand inputCommand) {
        if (inputCommand.equals(InputCommand.MOVE_LEFT)) {
            game.executeMove(Direction.LEFT);
            return;
        }
        if (inputCommand.equals(InputCommand.MOVE_RIGHT)) {
            game.executeMove(Direction.RIGHT);
            return;
        }
        if (inputCommand.equals(InputCommand.TURN_OVER)) {
            game.executeTurnOver();
            return;
        }
        if (inputCommand.equals(InputCommand.FIRE)) {
            game.executeFire();
        }
    }



    // 게임 상태 초기화
    // 게임 첫 화면 출력
    // 반복문 진입
    // 사용자 입력 대기
    // Command 값에 따른 메서드 수행 분기 처리
    // 처리된 결과를 OutputView로 출력
    // 게임이 끝나지 않았다면 반복
}
