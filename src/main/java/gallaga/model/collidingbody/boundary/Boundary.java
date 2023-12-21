package gallaga.model.collidingbody.boundary;

import gallaga.model.collidingbody.CollidingBody;
import gallaga.model.collidingbody.CollidingBodyType;
import gallaga.model.wrapper.*;

/**
 * 게임 내 경계선을 나타낸다.
 * 경계선은 기본적으로 속력이 0이며 나머지 상태들은 어떤 종류의 경계선인지에 따라 달라진다.
 */
public abstract class Boundary extends CollidingBody {

    public Boundary(
            Position position,
            Direction direction,
            HitPoint hitPoint,
            Damage damage,
            CollidingBodyType collidingBodyType
    ) {
        super(
                position,
                direction,
                new Velocity(0),
                hitPoint,
                damage,
                collidingBodyType
        );
    }
}
