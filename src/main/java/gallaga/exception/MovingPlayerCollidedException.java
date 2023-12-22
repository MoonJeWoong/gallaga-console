package gallaga.exception;

public class MovingPlayerCollidedException extends RuntimeException {

    public static final String MESSAGE = "이동 중 충돌이 발생하여 플레이어가 더 이동할 수 없습니다.";

    public MovingPlayerCollidedException() {
        super(MESSAGE);
    }
}
