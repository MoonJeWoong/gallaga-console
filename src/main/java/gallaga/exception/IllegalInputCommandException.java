package gallaga.exception;

/**
 * 게임 이용자가 잘못된 값을 입력했을 때 발생하는 예외.
 */
public class IllegalInputCommandException extends RuntimeException {

    private static final String MESSAGE = "잘못된 형식의 입력입니다.";

    public IllegalInputCommandException() {
        super(MESSAGE);
    }
}
