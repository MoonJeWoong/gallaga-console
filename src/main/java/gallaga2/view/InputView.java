package gallaga2.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static InputCommand inputCommand() {
        return InputCommand.from(scanner.nextLine());
    }
}
