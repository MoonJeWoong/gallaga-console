package gallaga.model.wrapper;

import java.util.Objects;

/**
 * 게임 내 공간의 열 좌표 값을 나타낸다.
 * 플레이어 관점 기준으로 가장 왼쪽이 0의 열좌표에 해당한다.
 */
public class Column {

    public static final int MAX_VALUE = 10;
    public static final int MIN_VALUE = 0;
    public static final Column MAX = new Column(MAX_VALUE);
    public static final Column MIN = new Column(MIN_VALUE);

    private final int value;

    public Column(int value) {
        this.value = value;
    }

    /**
     * 왼쪽 열 좌표를 반환한다.
     *
     * @return 현재 열 좌표를 기준으로 왼쪽 열 좌표를 반환.
     */
    public Column left() {
        return new Column(value - 1);
    }

    /**
     * 오른쪽 열 좌표를 반환한다.
     *
     * @return 현재 열 좌표를 기준으로 오른쪽 열 좌표를 반환.
     */
    public Column right() {
        return new Column(value + 1);
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
        Column column = (Column) o;
        return getValue() == column.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
