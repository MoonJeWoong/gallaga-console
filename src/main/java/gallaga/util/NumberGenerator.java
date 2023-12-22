package gallaga.util;

/**
 * 시작하는 수와 끝 수가 주어지면 해당 범위 내에서 숫자를 선택해 반환하는 인터페이스.
 * 수를 선택할 때 시작하는 수는 포함하고 끝 수는 포함하지 않는다.
 */
public interface NumberGenerator {
    int generate(int start, int end);
}
