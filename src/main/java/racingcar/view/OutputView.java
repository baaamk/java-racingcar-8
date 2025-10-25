package racingcar.view;

import racingcar.controller.dto.RoundResultDto;
import racingcar.controller.dto.WinnerDto;

public interface OutputView {
    public void initialPrint();
    public void NumberRequestPrint();
    public void roundResultPrint(RoundResultDto roundResultDto);
    public void winnerPrint(WinnerDto winnerDto);
}
