package gallaga2.model.collidingbody;

import gallaga2.model.wrapper.*;

import java.util.ArrayList;
import java.util.List;

public abstract class CollidingBody {

    private Position position;
    protected Direction direction;
    protected Velocity velocity;
    private HitPoint hitPoint;
    private Damage damage;
    private CollidingBodyType collidingBodyType;

    public CollidingBody(Position position, Direction direction, Velocity velocity, HitPoint hitPoint, Damage damage, CollidingBodyType collidingBodyType) {
        this.position = position;
        this.direction = direction;
        this.velocity = velocity;
        this.hitPoint = hitPoint;
        this.damage = damage;
        this.collidingBodyType = collidingBodyType;
    }

    public boolean isCollidedWith(CollidingBody other) {
        // 서로 방향이 반대인지, 체력은 각자 0을 초과하는지 확인
        // 각자의 예상 경로 리스트 확인
        // 예상 경로에 겹치는 좌표가 존재하면 충돌
        // 아니면 비충돌
        if (direction.isOpposite(other.direction)
                && hitPoint.isGreaterThanZero()
                && other.hitPoint.isGreaterThanZero()
        ) {
            List<Position> nextPath = calculateNextPath();
            List<Position> otherNextPath = other.calculateNextPath();
            for (Position position : nextPath) {
                if (otherNextPath.contains(position)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void collideWith(CollidingBody other) {
        decreaseHitPoint(other.damage);
    }

    public void move() {
        for (int i=0; i<velocity.getValue(); i++) {
            position.move(direction);
        }
    }

    private void decreaseHitPoint(Damage damage) {
        hitPoint = hitPoint.decreaseHitPoint(damage.getValue());
    }

    private List<Position> calculateNextPath() {
        List<Position> nextPath = new ArrayList<>();
        nextPath.add(position);
        for (int i=0; i<velocity.getValue(); i++) {
            Position currentPosition = nextPath.get(nextPath.size()-1);
            nextPath.add(currentPosition.move(direction));
        }
        return nextPath;
    }

    public boolean isEliminated() {
        return hitPoint.isLessOrEqualThanZero();
    }

    protected void changeDirection(Direction direction) {
        this.direction = direction;
    }

    protected void changeVelocity(Velocity velocity) {
        this.velocity = velocity;
    }

    public Position getPosition() {
        return position;
    }

    public CollidingBodyType getType() {
        return collidingBodyType;
    }
}