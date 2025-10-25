package racingcar.infrastructure;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

}