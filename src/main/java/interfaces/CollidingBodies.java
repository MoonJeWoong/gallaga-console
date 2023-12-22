package interfaces;

import gallaga.model.collidingbody.CollidingBody;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 여러 충돌체들을 그룹으로 관리한다.
 */
public interface CollidingBodies {
    void add(CollidingBody collidingBody);
    void move();
    int countEliminatedBodies();
    void removeEliminatedBodies();
    boolean isCollidedWith(CollidingBody other);
    int size();
}
