package racingcar.presentation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberParserTest {

    @Test
    void 문자열_숫자로_파싱_테스트() {
        int racingCars= InputNumberParser.parseToTryNumber("5");
        Assertions.assertThat(racingCars).isEqualTo(5);
    }

    @Test
    void 숫자_입력_공백_제거_테스트() {
        int racingCars= InputNumberParser.parseToTryNumber(" 5 ");
        Assertions.assertThat(racingCars).isEqualTo(5);
    }

    @Test
    void 최소_숫자_범위_예외_테스트() {
        assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_MIN_SIZE);
    }

    @Test
    void 최대_숫자_범위_예외_테스트() {
        assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_MAX_SIZE);
    }

    @Test
    void 소수_예외_테스트() {
        assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("5.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 숫자_이외_문자입력_예외_테스트() {
        assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_FORMAT);
    }

}