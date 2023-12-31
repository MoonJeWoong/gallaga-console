package gallaga.model.collidingbody;

/**
 * 충돌체들의 종류를 나타낼 수 있는 타입들. 외부에 타입을 표현하기 위한 이름을 포함한다.
 * EMPTY는 충돌체가 존재하지 않는다는 것을 표현하기 위한 타입이다.
 */
public enum CollidingBodyType {
    PLAYER("player"),
    ENEMY("enemy"),
    BULLET("bullet"),
    LEFT_BOUNDARY("leftBoundary"),
    RIGHT_BOUNDARY("rightBoundary"),
    UPPER_BOUNDARY("upperBoundary"),
    ENEMY_GOAL_BOUNDARY("enemyGoalBoundary"),
    EMPTY("empty");

    private final String typeName;

    CollidingBodyType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }
}
