package gallaga.generator;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random random = new Random();

    @Override
    public int generate(int start, int end) {
        return random.nextInt(start, end);
    }
}
