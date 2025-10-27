package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNumberTest {

    @Test
    @DisplayName("양수면 정상 생성된다")
    void 정상_생성() {
        TryNumber tryNumber = TryNumber.of(3);
        assertThat(tryNumber.getTryNumber()).isEqualTo(3);
    }

    @Test
    @DisplayName("0 이하이면 예외 발생")
    void 음수_또는_0_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> TryNumber.of(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );

        assertSimpleTest(() ->
                assertThatThrownBy(() -> TryNumber.of(-5))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );
    }
}
