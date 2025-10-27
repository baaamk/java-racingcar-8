package racingcar.domain;

import static racingcar.global.ErrorMessage.INVALID_NUMBER_FORMAT;

public class TryNumber {
    private final int tryNumber;

    private TryNumber(int tryNumber) {
        validate(tryNumber);
        this.tryNumber = tryNumber;
    }

    public static TryNumber of(int tryNumber) {
        return new TryNumber(tryNumber);
    }

    public int getTryNumber() {
        return tryNumber;
    }

    public void validate(int tryNumber) {
        if (tryNumber <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT);
        }
    }
}
