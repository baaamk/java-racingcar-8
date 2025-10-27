package racingcar.domain;

import java.util.Objects;

public class RacingCar{

    private static final int START_POSITION = 0;

    private final RacingCarName racingCarName;
    private final RacingCarPosition position;

    private RacingCar(RacingCarName racingCarName, RacingCarPosition position) {
        this.racingCarName = racingCarName;
        this.position = position;
    }

    public static RacingCar from(RacingCarName racingCarName) {
        RacingCarPosition position = RacingCarPosition.of(START_POSITION);
        return new RacingCar(racingCarName,position);
    }

    public RacingCar move(int randomNumber) {
        if (randomNumber >= 4) {
            return new RacingCar(racingCarName, position.move());
        }
        return this;
    }

    public boolean isMoreThan(RacingCar otherCar) {
        return position.isMoreThan(otherCar.position);
    }

    public boolean isAtSamePositionAs(RacingCar other) {
        return position.isSameAs(other.position);
    }


    public String getRacingCarName() {
        return racingCarName.getInputName();
    }

    public int getPosition() {
        return position.getFinalPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return Objects.equals(racingCarName, racingCar.racingCarName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(racingCarName);
    }
}
