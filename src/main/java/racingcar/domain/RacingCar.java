package racingcar.domain;

import racingcar.global.ErrorMessage;

import java.util.Objects;

public class RacingCar {

    private final String carName;
    private int state;

    private RacingCar(String carName) {
        validateCarName(carName);
        this.carName = carName;
        this.state = 0;
    }

    public static RacingCar from(String carName) {
        return new RacingCar(carName);
    }

    public void move() {
        state++;
    }

    private static void validateCarName(String carName) {
        validateNotNullOrBlank(carName);
        validateMaximumLength(carName);
        validateNoWhiteSpace(carName);
    }

    private static void validateNotNullOrBlank(String name) {
        if (name == null) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_NULL);
        }

        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_EMPTY);
        }

        if (name.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_BLANK);
        }
    }

    private static void validateMaximumLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_MAX_LENGTH);
        }
    }

    private static void validateNoWhiteSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_WHITESPACE);
        }
    }


    @Override
    public String toString() {
        return carName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RacingCar racingCar = (RacingCar) o;
        return state == racingCar.state;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(state);
    }


}
