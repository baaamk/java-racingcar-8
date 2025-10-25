    package racingcar.domain;

    import camp.nextstep.edu.missionutils.Randoms;
    import racingcar.global.ErrorMessage;

    import java.util.List;

    public class RacingCars{
        private final List<RacingCar> racingCars;

        private RacingCars(List<RacingCar> racingCars) {
            validate(racingCars);
            this.racingCars = List.copyOf(racingCars);
        }

        public static RacingCars from(List<RacingCar> racingCars) {
            return new RacingCars(racingCars);
        }

        public void play() {
            for (RacingCar racingCar : racingCars) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                racingCar.move(randomNumber);
            }
        }

        public RacingCars copyRacingCars() {
            List<RacingCar> clonedRacingCars = racingCars.stream()
                    .map(RacingCar::clone)
                    .toList();
            return RacingCars.from(clonedRacingCars);
        }

        private static void validate(List<RacingCar> racingCars) {
            if (racingCars == null || racingCars.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_NULL);
            }

            if (racingCars.size() == 1) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_CARS_COUNT);
            }
        }

        @Override
        public String toString() {
            return racingCars.toString();
        }
    }
