package racingcar.infrastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserTest {

    @Test
    void 문자열로_리스트로_파싱_테스트() {
        List<String> racingCars= Parser.parseToRacingCars("pobi,java");
        Assertions.assertThat(racingCars).isEqualTo(List.of("pobi","java"));
    }

    @Test
    void 문자_앞_뒤_공백_제거_테스트() {
        List<String> racingCars= Parser.parseToRacingCars(" pobi ,java");
        Assertions.assertThat(racingCars).isEqualTo(List.of("pobi","java"));
    }

    @Test
    void 문자열_숫자로_파싱_테스트() {
        int racingCars= Parser.parseToTryNumber("5");
        Assertions.assertThat(racingCars).isEqualTo(5);
    }

    @Test
    void 숫자_입력_공백_제거_테스트() {
        int racingCars= Parser.parseToTryNumber(" 5 ");
        Assertions.assertThat(racingCars).isEqualTo(5);
    }

    @Test
    void 이름_구분자_동일_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToRacingCars(",pobi,,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER);
    }

    @Test
    void 빈_이름_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToRacingCars(",pobi,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_EMPTY);
    }

    @Test
    void 잘못된_구분자_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToRacingCars("pobi.java.suji"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_DELIMITER);
    }

    @Test
    void 빈_이름_예외_테스트2() {
        assertThatThrownBy(() -> Parser.parseToRacingCars(",,,"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_AS_DELIMITER);
    }

    @Test
    void 최소_숫자_범위_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToTryNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_MIN_SIZE);
    }

    @Test
    void 최대_숫자_범위_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToTryNumber("2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_MAX_SIZE);
    }

    @Test
    void 소수_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToTryNumber("5.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_FORMAT);
    }

    @Test
    void 숫자_이외_문자입력_예외_테스트() {
        assertThatThrownBy(() -> Parser.parseToTryNumber("pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_FORMAT);
    }

}
