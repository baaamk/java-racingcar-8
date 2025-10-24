package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RacingCarTest{

    @Test
    void 자동차_이름이_1자_이상_5자_이하_통과_테스트() {
        RacingCar racingCar = RacingCar.from("pobi");
        assertEquals("pobi",racingCar.toString());
    }

    @Test
    void 자동차가_전진한_자동차와_그렇지_않은_자동차는_위치가_다르다() {
        RacingCar pobi = RacingCar.from("pobi");
        RacingCar java = RacingCar.from("java");
        pobi.move();
        Assertions.assertThat(pobi).isNotEqualTo(java);
    }


    @Test
    void 자동차_이름이_5자_초과_에러_테스트() {
        assertThatThrownBy(()-> RacingCar.from("fdsafsad"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_MAX_LENGTH);
    }

    @Test
    void 자동차_이름이_공백_포함_에러_테스트() {
        assertThatThrownBy(()-> RacingCar.from("fds a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_WHITESPACE);
    }

    @Test
    void 자동차_이름이_1자_미만_에러_테스트() {
        assertThatThrownBy(()-> RacingCar.from(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_EMPTY);
    }

    @Test
    void 자동차_이름이_없을때_에러_테스트() {
        assertThatThrownBy(()-> RacingCar.from(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_NULL);
    }

    @Test
    void 자동차_이름이_공백일_때_에러_테스트() {
        assertThatThrownBy(()-> RacingCar.from(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_BLANK);
    }



}