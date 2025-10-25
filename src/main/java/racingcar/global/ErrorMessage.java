package racingcar.global;

public class ErrorMessage {
    public static final String INVALID_CAR_NAME_NULL = "이름이 NULL이여서는 안됩니다.";
    public static final String INVALID_CAR_NAME_EMPTY = "이름이 입력되지 않았습니다.(1자 미만 입력)";
    public static final String INVALID_CAR_NAME_MAX_LENGTH = "문자 길이는 1자 이상 5자 이하여야 합니다.(5자 초과 입력)";
    public static final String INVALID_CAR_NAME_WHITESPACE = "이름 사이에 공백이 있어서는 안됩니다.";
    public static final String INVALID_CAR_NAME_BLANK = "이름이 비어있으면 안됩니다.";
    public static final String INVALID_CAR_NAME_AS_DELIMITER = "이름이 구분자와 동일하면 안됩니다.";
    public static final String INVALID_CAR_NAME_DELIMITER = "구분자로만 이름을 구별해야 합니다.";
    public static final String INVALID_NUMBER_FORMAT = "0 이상의 정수만 입력해 주세요";
    public static final String INVALID_NUMBER_MIN_SIZE = "0이하의 숫자가 입력되면 안됩니다.";
    public static final String INVALID_NUMBER_MAX_SIZE = "입력 가능한 숫자 크기가 아닙니다.";

    private ErrorMessage() {
    }
}
