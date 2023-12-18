package gallaga2.model.player;

import gallaga2.model.bullet.Bullet;
import gallaga2.model.wrapper.Position;

public class Magazine {

    private static final int DEFAULT_BULLET_LIMIT = 2;

    private int quantity;

    public Magazine() {
        this.quantity = DEFAULT_BULLET_LIMIT;
    }

    public Bullet makeOneBullet(Position position) {
        if (quantity > 0) {
            quantity--;
            return new Bullet(position);
        }
        throw new IllegalArgumentException("쏠 수 있는 총알이 존재하지 않습니다.");
    }

    public void reloadOneBullet() {
        quantity++;
    }
}
