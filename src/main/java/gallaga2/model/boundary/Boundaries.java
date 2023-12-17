package gallaga2.model.boundary;

import gallaga2.model.collidingbody.CollidingBody;

import java.util.Iterator;
import java.util.Set;

public class Boundaries implements Iterable<Boundary>{

    Set<Boundary> boundaries;

    public Boundaries(Set<Boundary> boundaries) {
        this.boundaries = boundaries;
        // 각 경계선들 초기화해서 넣어주기...
    }

    public boolean isCollidedWith(CollidingBody other) {
        // 충돌체가 경계선에 부딫혔는지 확인한다.
        for(Boundary boundary : boundaries) {
            if (boundary.isCollidedWith(other)) {
                return true;
            }
        }
        return false;
    }

    public int countEliminatedBoundaries() {
        return 0;
    }

    public Set<Boundary> getBoundaries() {
        return boundaries;
    }

    @Override
    public Iterator<Boundary> iterator() {
        return boundaries.iterator();
    }
}
