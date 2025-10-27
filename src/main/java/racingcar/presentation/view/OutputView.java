package racingcar.presentation.view;

import racingcar.controller.dto.RoundResultsDto;
import racingcar.controller.dto.WinnersDto;

public interface OutputView {
    void initialPrint();
    void NumberRequestPrint();
    void roundResultPrint(RoundResultsDto roundResultsDto);
    void winnerPrint(WinnersDto winnersDto);
}
