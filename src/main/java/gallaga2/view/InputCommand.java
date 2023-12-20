package gallaga2.view;

import gallaga2.exception.IllegalInputCommandException;

import java.util.Arrays;
import java.util.Objects;

public enum InputCommand {
    MOVE_LEFT("1"),
    MOVE_RIGHT("2"),
    FIRE("3");

    private String value;

    InputCommand(String value) {
        this.value = value;
    }

    public static InputCommand from(String inputValue) {
        return Arrays.stream(values())
                .filter(inputCommand -> inputCommand.isSameValue(inputValue))
                .findFirst()
                .orElseThrow(IllegalInputCommandException::new);
    }

    private boolean isSameValue(String inputValue) {
        return Objects.equals(this.value, inputValue);
    }
}
