package gallaga.util;

import java.util.Random;

/**
 * 주어진 수의 범위 내에서 무작위로 수를 선택해 반환한다.
 * 수를 선택할 때 시작하는 수는 포함하고 끝 수는 포함하지 않는다.
 */
public class RandomNumberGenerator implements NumberGenerator {

    public static final Random random = new Random();

    @Override
    public int generate(int start, int end) {
        return random.nextInt(start, end);
    }
}
