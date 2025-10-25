package racingcar.infrastructure;

import racingcar.global.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {}

    public static List<String> parseToRacingCars(String inputNames) {
        validateDelimiterUsage(inputNames);
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }

    public static int parseToTryNumber(String inputTryNumber) {
        String trimmedNumber = inputTryNumber.trim();
        return Integer.parseInt(trimmedNumber);
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

}
