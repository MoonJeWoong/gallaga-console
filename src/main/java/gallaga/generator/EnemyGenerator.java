package gallaga.generator;

import gallaga.model.Enemies;

public class EnemyGenerator {

    private static final int FIXED_GENERATION_ROW = 1;

    private NumberGenerator numberGenerator;

    public EnemyGenerator(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public void generateEnemy(Enemies enemies) {
        if (isEnemyGenerated()) {
            // 랜덤한 Position + Enemy 생성 후 Enemies 삽입.
        }
    }

    public boolean isEnemyGenerated() {
        int number = numberGenerator.generate(0, 10);
        return number < 5;
    }
}
