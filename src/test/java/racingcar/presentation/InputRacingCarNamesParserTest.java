package racingcar.presentation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputRacingCarNamesParserTest {

    @Test
    void 문자열로_리스트로_파싱_테스트() {
        List<String> racingCars= InputRacingCarNamesParser.parseToRacingCars("pobi,java");
        Assertions.assertThat(racingCars).isEqualTo(List.of("pobi","java"));
    }

    @Test
    void 문자_앞_뒤_공백_제거_테스트() {
        List<String> racingCars= InputRacingCarNamesParser.parseToRacingCars(" pobi ,java");
        Assertions.assertThat(racingCars).isEqualTo(List.of("pobi","java"));
    }



    @Test
    void 이름_구분자_동일_예외_테스트() {
        assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars(",pobi,,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER);
    }

    @Test
    void 빈_이름_예외_테스트() {
        assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars(",pobi,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_EMPTY);
    }

    @Test
    void 잘못된_구분자_예외_테스트() {
        assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars("pobi.java.suji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_DELIMITER);
    }

    @Test
    void 빈_이름_예외_테스트2() {
        assertThatThrownBy(() -> InputRacingCarNamesParser.parseToRacingCars(",,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER);
    }



}
