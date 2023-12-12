package gallaga2.model;

public class Board {

    private Player player;
    private Bullet bullet;
    private Enemy enemy;

    public Board(Player player, Bullet bullet, Enemy enemy) {
        this.player = player;
        this.bullet = bullet;
        this.enemy = enemy;
    }

    void fire() {}

    void progressTurn() {}

    void movePlayer() {}
}
