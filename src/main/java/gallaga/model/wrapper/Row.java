package gallaga.model.wrapper;

import java.util.Objects;

/**
 * 게임 내 공간의 행 좌표 값을 나타낸다.
 */
public class Row {

    public static final Row MAX = new Row(15);
    public static final Row MIN = new Row(0);

    private final int value;

    public Row(int value) {
        this.value = value;
    }

    /**
     * 윗쪽 행 좌표를 반환한다.
     * @return 현재 행 좌표를 기준으로 윗쪽 행 좌표를 반환.
     */
    public Row up() {
        return new Row(value - 1);
    }

    /**
     * 아랫쪽 행 좌표를 반환한다.
     * @return 현재 행 좌표를 기준으로 아랫쪽 행 좌표를 반환.
     */
    public Row down() {
        return new Row(value + 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Row row = (Row) o;
        return getValue() == row.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
