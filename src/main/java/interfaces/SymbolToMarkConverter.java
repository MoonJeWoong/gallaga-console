package interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 게임 수행 결과로 넘겨받은 심볼들을 화면에 출력하기 위해 기호로 변환한다.
 */
public interface SymbolToMarkConverter {

    List<String> convert(List<String> symbols);
}
