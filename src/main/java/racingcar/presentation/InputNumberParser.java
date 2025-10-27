package racingcar.presentation;

import racingcar.global.ErrorMessage;

import java.util.regex.Pattern;

public class InputNumberParser {

    private static final Pattern DECIMAL_PATTERN = Pattern.compile("^\\d*\\.\\d+$");


    public static int parseToTryNumber(String inputTryNumber) {
        try {
            return getValidatedNumber(inputTryNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private static void validateNumberRange(long inputTryNumber) {
        if (inputTryNumber <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MIN_SIZE);
        }

        if (inputTryNumber > 2147483647) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MAX_SIZE);
        }
    }

    private static void validateNotDecimal(String trimmedNumber) {
        if (DECIMAL_PATTERN.matcher(trimmedNumber).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_FORMAT);
        }
    }

    private static int getValidatedNumber(String inputTryNumber) {
        String trimmedNumber = inputTryNumber.trim();
        validateNotDecimal(trimmedNumber);
        long tryNumber = Long.parseLong(trimmedNumber);
        validateNumberRange(tryNumber);
        return (int) tryNumber;
    }
}
