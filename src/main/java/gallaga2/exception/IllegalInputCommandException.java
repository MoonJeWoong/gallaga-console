package gallaga2.exception;

public class IllegalInputCommandException extends RuntimeException {

    private static final String MESSAGE = "잘못된 형식의 입력입니다.";

    public IllegalInputCommandException() {
        super(MESSAGE);
    }
}
