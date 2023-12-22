package interfaces;

public interface CollidingBody {
    boolean isCollidedWith(CollidingBody other);
    void collideWith(CollidingBody other);
    void move();
    boolean isEliminated();
}