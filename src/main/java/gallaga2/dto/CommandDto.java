package gallaga2.dto;

import gallaga2.view.InputCommand;

public class CommandDto {

    private final InputCommand inputCommand;

    public CommandDto(InputCommand inputCommand) {
        this.inputCommand = inputCommand;
    }

    public InputCommand getCommand() {
        return inputCommand;
    }
}
