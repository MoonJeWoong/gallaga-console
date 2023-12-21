package gallaga.model.collidingbody;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 여러 충돌체들을 그룹으로 관리한다.
 */
public class CollidingBodies implements Iterable<CollidingBody> {

    Set<CollidingBody> collidingBodies;

    public CollidingBodies() {
        this.collidingBodies = new HashSet<>();
    }

    public void add(CollidingBody collidingBody) {
        collidingBodies.add(collidingBody);
    }

    /**
     * 그룹에 속한 충돌체들을 각각 다음 위치로 움직인다.
     */
    public void move() {
        for (CollidingBody collidingBody : collidingBodies) {
            collidingBody.move();
        }
    }

    /**
     * 그룹에 속한 충돌체들 중 제거되어야 하는 것들의 개수를 반환한다.
     * @return 그룹에서 제거되어야 하는 충돌체의 수
     */
    public int countEliminatedBodies() {
        return (int) collidingBodies.stream()
                .filter(CollidingBody::isEliminated)
                .count();
    }

    /**
     * 그룹에 속한 충돌체들 중 제거되어야 하는 것들을 제거한다.
     */
    public void removeEliminatedBodies() {
        collidingBodies = collidingBodies.stream()
                .filter(collidingBody -> !collidingBody.isEliminated())
                .collect(Collectors.toSet());
    }

    /**
     * 그룹에 속한 충돌체들 중에서 주어진 다른 충돌체와 충돌하는지 여부를 판단한다.
     * @param other 그룹에 속한 충돌체들과 충돌 여부를 판단할 다른 충돌체
     * @return 그룹에 속한 충돌체들 중 하나라도 주어진 다른 충돌체와 충돌하면 true를 반환
     */
    public boolean isCollidedWith(CollidingBody other) {
        for(CollidingBody collidingBody : collidingBodies) {
            if (collidingBody.isCollidedWith(other)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return collidingBodies.size();
    }

    @Override
    public Iterator<CollidingBody> iterator() {
        return collidingBodies.iterator();
    }
}
