package gallaga.model.board;

import gallaga.model.collidingbody.Enemy;
import gallaga.model.wrapper.*;
import gallaga.util.NumberGenerator;

/**
 * 무작위로 결정된 위치, 체력, 속도를 가진 새로운 적군을 생성한다.
 */
public class EnemyGenerator {

    private static final int GENERATE_PROBABILITY = 30;
    public static final Row DEFAULT_ENEMY_GRENRATED_ROW = new Row(1);

    private NumberGenerator numberGenerator;

    public EnemyGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    /**
     * 적군의 위치, 속력, 체력을 무작위로 결정해 새로운 적군을 생성한다.
     *
     * @return 새롭게 생성된 적군
     */
    public Enemy generate() {
        Column randomlyGeneratedColumn = new Column(numberGenerator.generate(1, 10));
        Velocity randomlyGeneratedVelocity = new Velocity(numberGenerator.generate(1, 3));
        HitPoint randomlyGeneratedHitPoint = new HitPoint(numberGenerator.generate(1, 3));

        return new Enemy(new Position(DEFAULT_ENEMY_GRENRATED_ROW, randomlyGeneratedColumn),
                randomlyGeneratedVelocity, randomlyGeneratedHitPoint);
    }

    /**
     * 일정 확률에 따라 적군을 생성할 것인지 아닌지를 결정한다.
     *
     * @return 적군을 생성할 확률보다 낮은 수가 뽑힌다면 true를 반환
     */
    public boolean isGenerable() {
        int result = numberGenerator.generate(0, 100);
        return result < GENERATE_PROBABILITY;
    }
}
