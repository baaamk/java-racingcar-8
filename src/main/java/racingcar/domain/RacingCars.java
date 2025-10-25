package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.ErrorMessage;

import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        validate(racingCars);
        this.racingCars = racingCars;
    }

    public static RacingCars from(List<String> racingCars) {
        return new RacingCars(
                racingCars.stream()
                        .map(RacingCar::from)
                        .toList()
        );
    }

    public void play() {
        for (RacingCar racingCar : racingCars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            racingCar.move(randomNumber);
        }
    }

    public RacingCars findWinner() {
        int maxState = racingCars.stream()
                .mapToInt(RacingCar::getState)
                .max()
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.INVALID_CAR_NAME_NULL));

        List<String> winners = racingCars.stream()
                .filter(racingCar -> racingCar.getState() == maxState)
                .map(RacingCar::getCarName)
                .toList();

        // 문자열 기반 from()만 사용
        return RacingCars.from(winners);
    }

    public RacingCars copyRacingCars() {
        List<RacingCar> clonedRacingCars = racingCars.stream()
                .map(RacingCar::clone)
                .toList();
        return new RacingCars(clonedRacingCars);
    }

    private static void validate(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_NULL);
        }
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    @Override
    public String toString() {
        return racingCars.toString();
    }
}
