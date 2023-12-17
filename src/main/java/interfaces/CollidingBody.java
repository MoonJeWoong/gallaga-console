package interfaces;

import gallaga2.model.collidingbody.CollidingBodyType;
import gallaga2.model.wrapper.Damage;
import gallaga2.model.wrapper.Direction;
import gallaga2.model.wrapper.Position;
import gallaga2.model.wrapper.Velocity;
import java.util.ArrayList;
import java.util.List;

public interface CollidingBody {

    // 다른 충돌체와의 충돌 여부 확인
    boolean isCollidedWith(CollidingBody other);
    // 다른 충돌체와의 충돌 처리 진행
    void collideWith(CollidingBody other);
    // 방향과 속력대로 위치를 이동
    void move();
    // 체력이 0이하가 되어 제거되었는지 여부를 확인
    boolean isEliminated();

    Position getPosition();
    CollidingBodyType getType();
}
