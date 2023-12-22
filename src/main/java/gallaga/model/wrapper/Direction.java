package gallaga.model.wrapper;

/**
 * 게임의 충돌체들이 가지는 진행 방향을 나타낸다.
 */
public enum Direction {

    UP("DOWN"),
    DOWN("UP"),
    LEFT("RIGHT"),
    RIGHT("LEFT");

    private final String oppositeDirection;

    Direction(String oppositeDirection) {
        this.oppositeDirection = oppositeDirection;
    }

    /**
     * 주어진 방향이 현재 방향과 반대되는지 여부를 확인한다.
     *
     * @param other
     * @return
     */
    public boolean isOpposite(Direction other) {
        return oppositeDirection.equals(other.name());
    }
}
