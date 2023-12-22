package interfaces;

import gallaga.dto.GameDto;
import gallaga.view.SymbolToMarkConverter;

import java.util.List;

public interface OutputView {

    void printGameScreen(GameDto gameDto);
    void printAlertMessage(String message);
    void printGameEndedMessage();
}
