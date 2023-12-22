package gallaga.model.collidingbody;

import gallaga.model.wrapper.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 진행하면서 서로 충돌할 수 있는 개념을 나타낸다.
 * 충돌체는 보드 상에서 각자 위치를 가진다.
 * 각자의 방향과 속력을 기반으로 다음 위치로 이동할 수 있다.
 * 충돌 처리 시 다른 충돌체의 파괴력만큼 체력을 감소시킨다.
 */
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

    /**
     * 주어진 다른 충돌체와 충돌 여부를 판단한다.
     * 다른 충돌체와 방향이 반대인지와 서로의 체력이 아직 0이 아닌지를 확인한다.
     * 이후 각 충돌체의 예상 경로가 겹치면 서로 충돌한다고 판단한다.
     * @param other 이 충돌체와 충돌 여부를 확인할 다른 충돌체
     * @return 이 충돌체와 주어진 다른 충돌체가 충돌하는 경우 true를 반환.
     */
    public boolean isCollidedWith(CollidingBody other) {
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

    /**
     * 현재 충돌체의 방향과 속력을 이용해 다음 예상 진행 경로를 계산한다.
     * 예상 진행 경로에는 현재 충돌체의 위치를 항상 포함한다.
     * @return 충돌체의 다음 예상 이동 경로를 반환
     */
    private List<Position> calculateNextPath() {
        List<Position> nextPath = new ArrayList<>();
        nextPath.add(position);
        for (int i=0; i<velocity.getValue(); i++) {
            Position currentPosition = nextPath.get(nextPath.size()-1);
            nextPath.add(currentPosition.move(direction));
        }
        return nextPath;
    }

    /**
     * 다른 충돌체의 파괴력만큼 체력을 감소시켜 충돌 처리를 진행한다.
     * @param other 충돌 처리를 진행할 다른 충돌체
     */
    public void collideWith(CollidingBody other) {
        decreaseHitPoint(other.damage);
    }

    private void decreaseHitPoint(Damage damage) {
        hitPoint = hitPoint.decreaseHitPoint(damage.getValue());
    }

    /**
     * 현재 충돌체의 속력 수치만큼 진행 방향으로 위치를 변경한다.
     */
    public void move() {
        for (int i=0; i<velocity.getValue(); i++) {
            this.position = position.move(direction);
        }
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

    public Row getRow() {
        return position.getRow();
    }

    public Column getColumn() {
        return position.getColumn();
    }

    public CollidingBodyType getType() {
        return collidingBodyType;
    }
}
