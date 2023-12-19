package gallaga2.model.collidingbody;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

public class CollidingBodies implements Iterable<CollidingBody> {

    Set<CollidingBody> collidingBodies;

    public CollidingBodies() {
        this.collidingBodies = new HashSet<>();
    }

    public void add(CollidingBody collidingBody) {
        collidingBodies.add(collidingBody);
    }

    public void move() {
        for (CollidingBody collidingBody : collidingBodies) {
            collidingBody.move();
        }
    }

    public int countEliminatedBodies() {
        return (int) collidingBodies.stream()
                .filter(CollidingBody::isEliminated)
                .count();
    }

    public void removeEliminatedBodies() {
        collidingBodies = collidingBodies.stream()
                .filter(collidingBody -> !collidingBody.isEliminated())
                .collect(Collectors.toSet());
    }

    public boolean isCollidedWith(CollidingBody other) {
        for(CollidingBody collidingBody : collidingBodies) {
            if (collidingBody.isCollidedWith(other)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<CollidingBody> iterator() {
        return collidingBodies.iterator();
    }
}
