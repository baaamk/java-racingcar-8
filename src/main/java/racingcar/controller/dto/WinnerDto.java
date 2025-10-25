package racingcar.controller.dto;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.List;

public class WinnerDto {
    private final RacingCars racingCars;

    public WinnerDto(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars.getRacingCars();
    }
}
