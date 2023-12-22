package gallaga.model.wrapper;

public enum Direction {

    UP("DOWN"),
    DOWN("UP"),
    LEFT("RIGHT"),
    RIGHT("LEFT");

    private final String oppositeDirection;

    Direction(String oppositeDirection) {
        this.oppositeDirection = oppositeDirection;
    }

    public boolean isOpposite(Direction other) {
        return oppositeDirection.equals(other.name());
    }
}
