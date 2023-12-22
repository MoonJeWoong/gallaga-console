package gallaga.exception;

/**
 * 플레이어가 이동 중 충돌하여 이동이 불가능한 경우 발생하는 예외.
 */
public class MovingPlayerCollidedException extends RuntimeException {

    public static final String MESSAGE = "이동 중 충돌이 발생하여 플레이어가 더 이동할 수 없습니다.";

    public MovingPlayerCollidedException() {
        super(MESSAGE);
    }
}
