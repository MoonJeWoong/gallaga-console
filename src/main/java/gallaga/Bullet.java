package gallaga;

import gallaga.model.wrapper.Position;
import java.util.List;

public interface Bullet {

    List<Position> calculatePath(Position start);
}
