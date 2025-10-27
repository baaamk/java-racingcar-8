package racingcar.controller.dto;

import racingcar.domain.RacingCars;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class RoundResultsDto {
    private final Map<Integer, RacingCars> racingResults;

    public RoundResultsDto(Map<Integer, RacingCars> racingResults) {
        this.racingResults = Map.copyOf(racingResults);
    }

    public static RoundResultsDto of(Map<Integer, RacingCars> racingResults) {
        return new RoundResultsDto(racingResults);
    }

    public Map<Integer, List<RoundResultDto>> asViewRows() {
        return racingResults.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        racingCarsEntry -> racingCarsEntry.getValue().getRacingCars().stream()
                                .map(car -> RoundResultDto.of(car.getRacingCarName(), car.getPosition()))
                                .toList(),
                        (roundResultDtos, secondRoundResultDtos) -> roundResultDtos,
                        TreeMap::new
                ));
    }
}
