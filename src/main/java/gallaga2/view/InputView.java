package gallaga2.view;

import gallaga2.dto.CommandDto;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static CommandDto inputCommand() {
        InputCommand inputCommand = InputCommand.from(scanner.nextLine());
        return new CommandDto(inputCommand);
    }
}
