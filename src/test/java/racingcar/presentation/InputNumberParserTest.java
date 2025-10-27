package racingcar.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.TryNumber;
import racingcar.global.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputNumberParserTest {

    @Test
    @DisplayName("정상적인 숫자 문자열이면 TryNumber로 변환된다")
    void 정상입력_변환성공() {
        TryNumber result = InputNumberParser.parseToTryNumber("3");
        assertThat(result.getTryNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("앞뒤 공백이 있으면 예외 발생")
    void 공백입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputNumberParser.parseToTryNumber(" 3 "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );
    }

    @Test
    @DisplayName("문자 입력 시 예외 발생")
    void 문자입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );
    }

    @Test
    @DisplayName("소수 입력 시 예외 발생")
    void 소수입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("3.5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );
    }

    @Test
    @DisplayName("0 이하 입력 시 예외 발생")
    void 음수또는0입력_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_MIN_SIZE)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("-5"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );
    }

    @Test
    @DisplayName("int 범위를 초과하면 예외 발생")
    void int범위초과_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputNumberParser.parseToTryNumber("9999999999"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_MAX_SIZE)
        );
    }
}
