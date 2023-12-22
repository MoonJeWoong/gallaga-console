package interfaces;

import gallaga.model.collidingbody.Enemy;
import gallaga.model.wrapper.*;
import gallaga.util.NumberGenerator;

/**
 * 무작위로 결정된 위치, 체력, 속도를 가진 새로운 적군을 생성한다.
 */
public interface EnemyGenerator {
    Enemy generate();
    boolean isGenerable();
}
