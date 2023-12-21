package gallaga.view;

import java.util.Scanner;

/**
 * 갤러그 프로그램에서 모든 화면 입력을 수행한다.
 */
public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * 게임 이용자의 입력을 받아 적합한 InputCommand가 존재하면 이를 반환한다.
     * @return 입력한 값과 매핑되는 InputCommand
     * @throws IllegalArgumentException 사용자 입력 값에 매핑되는 InputCommand가 없을 경우 발생.
     */
    public static InputCommand inputCommand() {
        return InputCommand.from(scanner.nextLine());
    }
}
