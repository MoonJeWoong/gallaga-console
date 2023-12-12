<<<<<<< HEAD
//package gallaga.model;
//
//import gallaga.generator.EnemyGenerator;
//import gallaga.generator.NumberGenerator;
//import gallaga.model.wrapper.Position;
//import gallaga.model.wrapper.Score;
//import java.util.HashMap;
//
//public class Board {
//
//    Enemies enemies;
//    Bullets bullets;
//    Score score;
//    NumberGenerator numberGenerator;
//
//    public Board(NumberGenerator numberGenerator) {
//        this.enemies = new Enemies(new HashMap<>());
//        this.bullets = new Bullets(new HashMap<>());
//        this.score = new Score(0);
//        this.numberGenerator = numberGenerator;
//    }
//
//    public void fire(Position playerPosition) {
//        // 현재 필드에 있는 총탄의 개수를 확인한다.
//        // 현재 필드에 총탄 개수가 2개라면 새로운 총알을 생성하지 않는다. + 턴을 더이상 진행하지 않고 그대로 넘긴다.
//        // 현재 플레이어 위치를 기반으로 새로운 총알을 생성한다.
//        if (bullets.canFire()) {
//            bullets.fire(playerPosition);
//        }
//    }
//
//    public void progressBoard() {
//        // 보드 위에 존재하는 총알들과 적군들을 움직인다.
//        // 총알과 적군들을 어떻게 움직일것인지?
//        // 총알에 피격되었을 때 어떻게 처리할 것인지?
//        // 피격된 총알과 체력이 0이된 적군은 어떻게 제거할 것인지
//        // 화면의 끝에 닿은 총알은 어떻게 제거할 것인지
//
//        Bullets nextPositionBullets = bullets.getNextPositionBullets(); // 남아있는 총알들의 다음 위치를 계산해서 반환한다. + 최상단 라인 도달 총알 제거
////        enemies.hit(nextPositionBullets);   // 내부에서 피격 처리된 총알은 제거 (적군과 일치하는 위치 + 적군의 위치로부터 다음경로에 포함되는 총알)
//        bullets = nextPositionBullets;  // 피격 처리되지 않은 남은 총알들의 상태를 업데이트한다.
//
//        score.add(enemies.countEliminated());  // 체력이 0이된 적군의 개수 카운트 후 점수 추가
//        enemies.removeEliminated();
//
//        enemies.move(); // 남은 적군들을 움직인다.
//        EnemyGenerator enemyGenerator = new EnemyGenerator(numberGenerator);
//        if (bullets.hasBulletBeforeTopLine())
//        enemyGenerator.generateEnemy(enemies); // 새로운 적군을 무작위로 생성한다.
//    }
//
//    public boolean isGameOver() {
//        // 적군이 EndLine에 닿았는지 확인한다.
//        return enemies.doesReachAtEndLine();
//    }
//}
=======
package gallaga.model;

import gallaga.generator.EnemyGenerator;
import gallaga.generator.NumberGenerator;
import gallaga.model.wrapper.Position;
import gallaga.model.wrapper.Score;
import java.util.HashMap;

public class Board {

    Enemies enemies;
    Bullets bullets;
    Score score;
    NumberGenerator numberGenerator;

    public Board(NumberGenerator numberGenerator) {
        this.enemies = new Enemies(new HashMap<>());
        this.bullets = new Bullets(new HashMap<>());
        this.score = new Score(0);
        this.numberGenerator = numberGenerator;
    }

    public void fire(Position playerPosition) {
        // 현재 필드에 있는 총탄의 개수를 확인한다.
        // 현재 필드에 총탄 개수가 2개라면 새로운 총알을 생성하지 않는다. + 턴을 더이상 진행하지 않고 그대로 넘긴다.
        // 현재 플레이어 위치를 기반으로 새로운 총알을 생성한다.
        if (bullets.canFire()) {
            bullets.fire(playerPosition);
        }
    }

    public void progressBoard() {
        // 보드 위에 존재하는 총알들과 적군들을 움직인다.
        // 총알과 적군들을 어떻게 움직일것인지?
        // 총알에 피격되었을 때 어떻게 처리할 것인지?
        // 피격된 총알과 체력이 0이된 적군은 어떻게 제거할 것인지
        // 화면의 끝에 닿은 총알은 어떻게 제거할 것인지

        Bullets nextPositionBullets = bullets.getNextPositionBullets(); // 남아있는 총알들의 다음 위치를 계산해서 반환한다. + 최상단 라인 도달 총알 제거
//        enemies.hit(nextPositionBullets);   // 내부에서 피격 처리된 총알은 제거 (적군과 일치하는 위치 + 적군의 위치로부터 다음경로에 포함되는 총알)
        bullets = nextPositionBullets;  // 피격 처리되지 않은 남은 총알들의 상태를 업데이트한다.

        score.add(enemies.countEliminated());  // 체력이 0이된 적군의 개수 카운트 후 점수 추가
        enemies.removeEliminated();

        enemies.move(); // 남은 적군들을 움직인다.
        EnemyGenerator enemyGenerator = new EnemyGenerator(numberGenerator);
        if (bullets.hasBulletBeforeTopLine())
        enemyGenerator.generateEnemy(enemies); // 새로운 적군을 무작위로 생성한다.
    }

    public boolean isGameOver() {
        // 적군이 EndLine에 닿았는지 확인한다.
        return enemies.doesReachAtEndLine();
    }
}
>>>>>>> 1fddda45d3ac001bd76d0320baed745bffbc64b2
