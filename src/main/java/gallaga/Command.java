package gallaga;

import java.util.Arrays;
import java.util.Objects;

public enum Command {
    MOVE_LEFT("1"),
    MOVE_RIGHT("2"),
    TURN_OVER("3"),
    FIRE("4");

    private String inputValue;

    Command(String inputValue) {
        this.inputValue = inputValue;
    }

    public static Command from(String inputValue) {
        return Arrays.stream(values())
                .filter(command -> command.isSameValue(inputValue))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isSameValue(String inputValue) {
        return Objects.equals(this.inputValue, inputValue);
    }
}
