package gallaga2.model;

import gallaga2.model.wrapper.Position;

public class Magazine {

    private static final int DEFAULT_BULLET_LIMIT = 2;

    private int quantity;

    public Magazine() {
        this.quantity = DEFAULT_BULLET_LIMIT;
    }

    public Bullet loadOneBullet(Position position) {
        return new Bullet(position);
    }

    public void reloadOneBullet() {}
}
