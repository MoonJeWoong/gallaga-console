package gallaga.model.game;

import gallaga.model.collidingbody.Enemy;
import gallaga.model.wrapper.*;
import gallaga.util.NumberGenerator;

public class EnemyGenerator {

    private static final int GENERATE_PROBABILITY = 30;
    public static final Row DEFAULT_ENEMY_GRENRATED_ROW = new Row(1);

    private NumberGenerator numberGenerator;

    public EnemyGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public Enemy generate() {
        // 무작위로 적군을 생성한다.
        Column randomlyGeneratedColumn = new Column(numberGenerator.generate(1, 10));
        Velocity randomlyGeneratedVelocity = new Velocity(numberGenerator.generate(1, 3));
        HitPoint randomlyGeneratedHitPoint = new HitPoint(numberGenerator.generate(1, 3));

        return new Enemy(new Position(DEFAULT_ENEMY_GRENRATED_ROW, randomlyGeneratedColumn),
                randomlyGeneratedVelocity, randomlyGeneratedHitPoint);
    }

    public boolean isGenerable() {
        int result = numberGenerator.generate(0, 100);
        return result < GENERATE_PROBABILITY;
    }
}
