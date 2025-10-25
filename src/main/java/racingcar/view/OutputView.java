package racingcar.view;

import racingcar.controller.dto.RoundResultDto;
import racingcar.controller.dto.WinnerDto;

public interface OutputView {
    void initialPrint();
    void NumberRequestPrint();
    void roundResultPrint(RoundResultDto roundResultDto);
    void winnerPrint(WinnerDto winnerDto);
}
