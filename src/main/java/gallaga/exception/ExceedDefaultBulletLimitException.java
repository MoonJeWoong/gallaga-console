package gallaga.exception;

public class ExceedDefaultBulletLimitException extends RuntimeException {

    private static final String MESSAGE = "보드 위의 총알은 %d개를 넘길 수 없습니다.";

    public ExceedDefaultBulletLimitException(int limitOfBullet) {
        super(String.format(MESSAGE, limitOfBullet));
    }
}
