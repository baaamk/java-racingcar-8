package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.Map;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingTest {

    @Test
    @DisplayName("자동차 경주가 지정된 횟수만큼 실행된다")
    void 경주_횟수만큼_진행_확인() {
        RacingCars racingCars = RacingCars.from(
                java.util.List.of("pobi", "crong", "honux")
        );
        TryNumber tryNumber = TryNumber.of(3);
        Racing racing = Racing.of(tryNumber, racingCars);

        Map<Integer, RacingCars> result = racing.playRacing();

        assertThat(result).hasSize(3);
        assertThat(result.keySet()).containsExactly(1, 2, 3);
    }

    @Test
    @DisplayName("시도 횟수가 0이면 예외가 발생한다")
    void 시도횟수_0_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> TryNumber.of(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_NUMBER_FORMAT)
        );
    }

    @Test
    @DisplayName("자동차 이름이 없으면 예외가 발생한다")
    void 자동차_없음_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        RacingCars.from(java.util.List.of())
                )
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_NULL)
        );
    }

    @Test
    @DisplayName("라운드 결과가 비어 있지 않다")
    void 라운드_결과_검증() {
        RacingCars racingCars = RacingCars.from(java.util.List.of("pobi", "crong"));
        TryNumber tryNumber = TryNumber.of(5);
        Racing racing = Racing.of(tryNumber, racingCars);

        Map<Integer, RacingCars> result = racing.playRacing();

        assertThat(result).isNotEmpty();
        assertThat(result.get(1)).isNotNull();
    }
}
