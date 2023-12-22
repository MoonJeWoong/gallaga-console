package gallaga.exception;

/**
 * 보드에 정해진 개수의 총알을 넘겨서 총알을 발사할려는 경우 발생하는 예외.
 */
public class ExceedDefaultBulletLimitException extends RuntimeException {

    private static final String MESSAGE = "보드 위의 총알은 %d개를 넘길 수 없습니다.";

    public ExceedDefaultBulletLimitException(int limitOfBullet) {
        super(String.format(MESSAGE, limitOfBullet));
    }
}
