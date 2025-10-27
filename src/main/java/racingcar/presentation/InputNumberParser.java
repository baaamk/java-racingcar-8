package racingcar.presentation;

import racingcar.domain.TryNumber;
import racingcar.global.ErrorMessage;

import java.util.regex.Pattern;

public class InputNumberParser {

    private static final Pattern INTEGER_ONLY = Pattern.compile("^\\d+$");

    public static TryNumber parseToTryNumber(String inputTryNumber) {
        try {
            return getValidatedNumber(inputTryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private static TryNumber getValidatedNumber(String inputTryNumber) {
        if (inputTryNumber == null || !INTEGER_ONLY.matcher(inputTryNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }

        long parsedTryNumber = Long.parseLong(inputTryNumber); // 여기서 공백 없으니 안전
        validateNumberRange(parsedTryNumber);
        return TryNumber.of((int) parsedTryNumber);
    }

    private static void validateNumberRange(long parsedTryNumber) {
        if (parsedTryNumber <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MIN_SIZE);
        }
        if (parsedTryNumber > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MAX_SIZE);
        }
    }
}
