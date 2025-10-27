package racingcar.presentation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputRacingCarNamesParserTest {

    @Test
    @DisplayName("정상 입력은 이름 리스트로 파싱된다 (trim 적용)")
    void 정상_파싱() {
        List<String> names = InputRacingCarNamesParser.parseToRacingCars("pobi, java,honux");
        assertThat(names).containsExactly("pobi", "java", "honux");

        List<String> names2 = InputRacingCarNamesParser.parseToRacingCars("pobi");
        assertThat(names2).containsExactly("pobi");
    }

    @Test
    @DisplayName("시작이 구분자면 예외")
    void 시작_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars(",pobi,java"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_EMPTY)
        );
    }

    @Test
    @DisplayName("끝이 구분자면 예외")
    void 끝_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars("pobi,java,"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_EMPTY)
        );
    }

    @Test
    @DisplayName("연속 구분자(빈 이름)가 있으면 예외")
    void 연속_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars("pobi,,java"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_EMPTY)
        );
    }

    @Test
    @DisplayName("이름에 구분자만 있으면 예외")
    void 이름이_구분자_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars("pobi,,,java"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER)
        );
    }
}
