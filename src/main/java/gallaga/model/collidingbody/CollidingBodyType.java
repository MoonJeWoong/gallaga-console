package gallaga.model.collidingbody;

/**
 * 충돌체들의 종류를 나타낼 수 있는 타입들.
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
