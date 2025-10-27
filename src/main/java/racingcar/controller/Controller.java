package racingcar.controller;

import racingcar.controller.dto.RoundResultsDto;
import racingcar.controller.dto.WinnersDto;
import racingcar.domain.Racing;
import racingcar.domain.RacingCars;
import racingcar.domain.TryNumber;
import racingcar.domain.Winner;
import racingcar.presentation.InputNumberParser;
import racingcar.presentation.InputRacingCarNamesParser;
import racingcar.presentation.view.InputView;
import racingcar.presentation.view.OutputView;

import java.util.List;
import java.util.Map;

public class Controller implements Runnable {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {
        RacingCars racingCars = createRacingCars();
        TryNumber tryNumber = createTryNumber();
        Racing racing = Racing.of(tryNumber, racingCars);
        Map<Integer, RacingCars> racingResults = racing.playRacing();
        printRoundResults(racingResults);
        printWinners(racingCars);

    }

    private void printWinners(RacingCars racingCars) {
        RacingCars winner = racingCars.findWinner();
        Winner result = Winner.from(winner);
        WinnersDto winnersDto = WinnersDto.from(result.winners());
        outputView.winnerPrint(winnersDto);
    }

    private void printRoundResults(Map<Integer, RacingCars> racingResults) {
        RoundResultsDto roundResultsDto = RoundResultsDto.of(racingResults);
        outputView.roundResultPrint(roundResultsDto);
    }

    private TryNumber createTryNumber() {
        outputView.NumberRequestPrint();
        String parsedTryNumber = inputView.inputTryNumber();
        return InputNumberParser.parseToTryNumber(parsedTryNumber);
    }

    private RacingCars createRacingCars() {
        outputView.initialPrint();
        String inputNames = inputView.inputNames();
        List<String> parsedRacingCars = InputRacingCarNamesParser.parseToRacingCars(inputNames);
        return RacingCars.from(parsedRacingCars);
    }
}

