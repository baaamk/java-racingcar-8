package racingcar.presentation;

import racingcar.global.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputRacingCarNamesParser {

    private static final Pattern TRIPLE_COMMA = Pattern.compile(".*,,,.+");
    private static final Pattern DOUBLE_COMMA = Pattern.compile("(^,.*|.*,,.*|.*,$)");

    public static List<String> parseToRacingCars(String inputNames) {
        validateDelimiterUsage(inputNames);
        return Arrays.stream(inputNames.split(","))
                .map(String::trim)
                .toList();
    }

    private static void validateDelimiterUsage(String inputNames) {
        if (TRIPLE_COMMA.matcher(inputNames).find()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER);
        }
        if (DOUBLE_COMMA.matcher(inputNames).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_EMPTY);
        }
    }

    private InputRacingCarNamesParser() {}
}
