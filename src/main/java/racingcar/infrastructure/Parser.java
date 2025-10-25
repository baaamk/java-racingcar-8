package racingcar.infrastructure;

import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {}

    public static List<String> parseToRacingCars(String inputNames) {
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }

    public static int parseToTryNumber(String inputTryNumber) {
        String trimmedNumber = inputTryNumber.trim();
        return Integer.parseInt(trimmedNumber);
    }
}
