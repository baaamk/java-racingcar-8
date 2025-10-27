package racingcar.domain;

public class Winner {
    private final RacingCars winners;

    private Winner(RacingCars winners) {
        this.winners = winners;
    }

    public static Winner from(RacingCars racingCars) {
        return new Winner(racingCars);
    }

    public RacingCars winners() {
        return winners;
    }

}
