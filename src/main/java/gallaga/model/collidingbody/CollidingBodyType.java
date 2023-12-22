package gallaga.model.collidingbody;

/**
 * 충돌체들의 종류를 나타낼 수 있는 타입들.
 * EMPTY는 충돌체가 존재하지 않는다는 것을 표현하기 위한 타입이다.
 */
public enum CollidingBodyType {
    PLAYER,
    ENEMY,
    BULLET,
    LEFT_BOUNDARY,
    RIGHT_BOUNDARY,
    UPPER_BOUNDARY,
    ENEMY_GOAL_BOUNDARY,
    EMPTY
}
