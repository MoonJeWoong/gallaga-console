package gallaga2.view;

import gallaga2.exception.IllegalInputCommandException;

import java.util.Arrays;
import java.util.Objects;

/**
 * 갤러그 게임에서 이용자가 입력할 수 있는 명령들의 종류이다.
 */
public enum InputCommand {
    MOVE_LEFT("1"),
    MOVE_RIGHT("2"),
    FIRE("3");

    private String value;

    InputCommand(String value) {
        this.value = value;
    }

    /**
     * 주어진 입력 값과 매핑되는 명령이 존재하는지 확인한다. 존재한다면 해당 명령어 enum 객체를 반환하고 없다면 예외를 발생시킨다.
     * @param inputValue 입력 값
     * @return 입력 값과 매핑되는 InputCommand
     */
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
