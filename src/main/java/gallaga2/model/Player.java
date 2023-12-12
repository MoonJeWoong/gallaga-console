package gallaga2.model;

import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.Position;

public class Player {

    private Position position;
    private Magazine magazine;

    public Bullet fire() {
        // 플레이어의 탄창에 총알이 남아 있으면 총알을 쏠 수 있다.
        return magazine.loadOneBullet(position);
    }

    public void move(Direction direction) {
        // LEFT or RIGHT 이면 움직이고 UP or DOWN이면 예외처리?
    }
}
