package racingcar.domain;

import racingcar.global.ErrorMessage;

import java.util.Objects;
import java.util.regex.Pattern;

public class RacingCarName {
    private final static Pattern NAME_LENGTH = Pattern.compile("^.{1,5}$");

    private final String inputName;

    private RacingCarName(String inputName) {
        validate(inputName);
        this.inputName = inputName;
    }

    public static RacingCarName from(String inputName) {
        return new RacingCarName(inputName);
    }

    public String getInputName() {
        return inputName;
    }

    private void validate(String inputName) {
        if (!NAME_LENGTH.matcher(inputName).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_MAX_LENGTH);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RacingCarName that = (RacingCarName) o;
        return Objects.equals(getInputName(), that.getInputName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getInputName());
    }
}
