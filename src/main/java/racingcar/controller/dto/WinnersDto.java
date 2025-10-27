package racingcar.controller.dto;

import racingcar.domain.RacingCars;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersDto {
    private final List<WinnerDto> winnersDto;

    private WinnersDto(List<WinnerDto> winnersDto) {
        this.winnersDto = winnersDto;
    }

    public static WinnersDto from(RacingCars winners) {
        List<WinnerDto> winnersDto = winners.getRacingCars().stream()
                .map(racingCar -> WinnerDto.from(racingCar.getRacingCarName()))
                .toList();
        return new WinnersDto(winnersDto);
    }

    @Override
    public String toString() {
        return winnersDto.stream().map(WinnerDto::getWinnerName).collect(Collectors.joining(", "));
    }
}
