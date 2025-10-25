package racingcar.controller;

import racingcar.controller.dto.RoundResultDto;
import racingcar.controller.dto.WinnerDto;
import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.infrastructure.Parser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller implements Runnable{
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        String RacingCarNames = requestRacingCarNames();
        List<String> inputRacingCars = Parser.parseToRacingCars(RacingCarNames);
        RacingCars racingCars = RacingCars.from(inputRacingCars);
        String inputTryNumber = requestTryNumber();
        int tryNumber = Parser.parseToTryNumber(inputTryNumber);
        Racing racing = Racing.of(tryNumber, racingCars);
        Map<Integer, RacingCars> racingResults = racing.playRacing();
        RoundResultDto roundResultDto = new RoundResultDto(racingResults);
        outputView.roundResultPrint(roundResultDto);
        RacingCars winner = racingCars.findWinner();
        WinnerDto winnerDto = new WinnerDto(winner);
        outputView.winnerPrint(winnerDto);

    }

    private String requestRacingCarNames() {
        outputView.initialPrint();
        return inputView.inputNames();
    }

    private String requestTryNumber() {
        outputView.NumberRequestPrint();
        return inputView.inputTryNumber();
    }
}
