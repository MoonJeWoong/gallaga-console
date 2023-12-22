package gallaga.controller;

import gallaga.dto.GameDto;
import gallaga.model.game.Game;
import gallaga.model.wrapper.Direction;
import gallaga.util.GameStatusToDtoConverter;
import gallaga.view.InputCommand;
import gallaga.view.InputView;
import gallaga.view.OutputView;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 갤러그 프로그램의 시작 지점이 되는 클래스다.
 * View와 Model을 이용해 갤러그 프로그램의 전체 흐름을 제어한다.
 */
public class Controller {

    /**
     * 갤러그 프로그램 실행 메서드다.
     * 새로운 게임을 초기화하고 시작한다.
     */
    public void run() {
        Game game = new Game();
        start(game);
    }

    /**
     * 주어진 게임을 게임 종료 판정이 나기 전까지 계속 진행시킨다.
     * 사용자의 입력을 받아 처리하는 부분 외에 일정 주기로 자동 수행되어야 하는 작업들은 Scheduler를 통해 수행한다.
     *
     * @param game 진행할 게임
     */
    private void start(Game game) {
        // 게임을 자동 진행하기 위한 스케쥴러를 시작한다.
        startAutoScheduler(game);

        while (!game.isGameOver()) {
            try {
                InputCommand inputCommand = InputView.inputCommand();

                // InputCommand 값에 따른 메서드 수행 분기 처리
                executeCommand(game, inputCommand);
                displayGameStatus(game);
            } catch (Exception e) {
                OutputView.printAlertMessage(e.getMessage());
            }
        }
    }

    /**
     * 주어진 게임에 대해 2초 주기로 자동 수행할 작업을 설정하고 스케쥴러를 시작한다. 해당 작업은 메인 스레드와 별개의 스레드에서 동작한다.
     * @param game 스케쥴러를 동작시킬 대상이 되는 게임
     */
    private void startAutoScheduler(Game game) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(schedulerTask(game, scheduler), 2000, 2000, TimeUnit.MILLISECONDS);
    }

    /**
     * 주어진 게임에 대해 일정 주기로 수행할 작업 내용을 반환한다.
     * 일정 주기마다 게임을 한 번 진행시키고, 게임의 현재 상태를 화면에 출력한다.
     * 한 번 게임을 진행한 뒤 게임의 종료 여부를 확인한다.
     * 게임이 종료되었을 시에는, 실행중이던 스케쥴러를 종료하고 게임 종료 메세지를 출력한 뒤 전체 프로그램을 종료한다.
     * @param game 스케쥴러를 동작시킬 대상이 되는 게임
     * @param scheduler 이 작업 내용을 수행할 스케쥴러
     * @return Scheduler가 주기적으로 수행할 작업의 내용
     */
    private Runnable schedulerTask(Game game, ScheduledExecutorService scheduler) {
        return () -> {
            game.executeProgress();
            displayGameStatus(game);

            if (game.isGameOver()) {
                scheduler.shutdown();
                OutputView.printGameEndedMessage();
                System.exit(0);
            }
        };
    }

    /**
     * 게임의 현재 상태를 화면에 출력한다.
     * @param game 현재 상태를 출력할 게임
     */
    private void displayGameStatus(Game game) {
        GameDto gameDto = GameStatusToDtoConverter.convertToGameDto(game.getGameStatus());
        OutputView.printGameScreen(gameDto);
    }

    /**
     * 주어지는 inputCommand에 따라 game에게 요청할 방식을 선택한다.
     * @param game inputCommand에 해당하는 작업을 처리할 게임
     * @param inputCommand 게임 이용자가 입력한 명령
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
