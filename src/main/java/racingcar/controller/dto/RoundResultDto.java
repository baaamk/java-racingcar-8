package racingcar.controller.dto;

import racingcar.domain.RacingCars;

import java.util.Map;

public class RoundResultDto {
    private final Map<Integer, RacingCars> racingResults;

    public RoundResultDto(Map<Integer, RacingCars> racingResults) {
        this.racingResults = racingResults;
    }

    public Map<Integer, RacingCars> getRacingResults() {
        return racingResults;
    }
}
