package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.global.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        validate(racingCars);
        this.racingCars = racingCars;
    }


    public static RacingCars from(List<String> racingCars) {
        return new RacingCars(
                racingCars.stream()
                        .map(name -> RacingCar.from(RacingCarName.from(name)))
                        .toList()
        );
    }

    private static RacingCars fromRacingCars(List<RacingCar> racingCars) {
        return new RacingCars(racingCars);
    }

    public RacingCars play() {
        List<RacingCar> movedCars = racingCars.stream()
                .map(car -> car.move(Randoms.pickNumberInRange(0, 9)))
                .toList();

        return RacingCars.fromRacingCars(movedCars);
    }

    public RacingCars findWinner() {
        RacingCar winner = racingCars.stream()
                .reduce((car1, car2) -> {
                    if (car1.isMoreThan(car2)) return car1;
                    return car2;
                })
                .orElseThrow(() -> new IllegalStateException(ErrorMessage.INVALID_CAR_NAME_NULL));

        List<RacingCar> winners = racingCars.stream()
                .filter(car -> car.isAtSamePositionAs(winner))
                .toList();

        return RacingCars.fromRacingCars(winners);
    }

    private static void validate(List<RacingCar> racingCars) {
        if (racingCars == null || racingCars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_NULL);
        }

        Set<String> uniqueNames = new HashSet<>();
        for (RacingCar racingCar : racingCars) {
            if (!uniqueNames.add(racingCar.getRacingCarName())) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_DUPLICATED_NAME);
            }
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
