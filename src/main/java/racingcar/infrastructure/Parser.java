package racingcar.infrastructure;

import racingcar.global.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static List<String> parseToRacingCars(String inputNames) {
        validateDelimiterUsage(inputNames);
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }

    public static int parseToTryNumber(String inputTryNumber) {
        try {
            return getValidatedNumber(inputTryNumber);
        } catch (NumberFormatException e) {
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

    private static void validateDelimiterUsage(String inputNames) {
        if (inputNames.contains(",,,")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER);
        }
        if (inputNames.contains(",,") || inputNames.startsWith(",") || inputNames.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_EMPTY);
        }
        if (!inputNames.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_DELIMITER);
        }
    }

    private static void validateNotDecimal(String trimmedNumber) {
        if (trimmedNumber.contains(".")) {
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

    private Parser() {}


}
