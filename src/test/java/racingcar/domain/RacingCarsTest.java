package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class RacingCarsTest {

    @Test
    void play_호출시_자동차중_일부는_상태가_변할_수_있다() {
        RacingCar pobi = RacingCar.from("pobi");
        RacingCar java = RacingCar.from("java");
        RacingCars racingCars = RacingCars.from(List.of(pobi, java));

        racingCars.play();

        assertThat(pobi.getState()).isGreaterThanOrEqualTo(0);
        assertThat(java.getState()).isGreaterThanOrEqualTo(0);

    }

    @Test
    void 비어있는_자동차리스트_생성_예외() {
        assertThatThrownBy(() -> RacingCars.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_NULL);
    }

    @Test
    void 한개의_자동차_생성_예외() {
        RacingCar pobi = RacingCar.from("pobi");
        assertThatThrownBy(() -> RacingCars.from(List.of(pobi)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CARS_COUNT);
    }

}
