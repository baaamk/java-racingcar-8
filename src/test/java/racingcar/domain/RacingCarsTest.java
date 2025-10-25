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
    void 가장_큰_state를_가진_자동차를_우승자로_반환() {
        RacingCar pobi = RacingCar.from("pobi");
        RacingCar jun = RacingCar.from("jun");
        RacingCar park = RacingCar.from("park");

        RacingCars racingCars = RacingCars.from(List.of(pobi, jun, park));

        pobi.move(4);
        pobi.move(4);
        jun.move(4);
        park.move(3);



        RacingCars winners = racingCars.findWinner();

        assertThat(winners.toString()).contains("pobi");
        assertThat(winners.toString()).doesNotContain("jun", "park");
    }

    @Test
    void 최대값이_동일하면_공동_우승자를_반환() {
        RacingCar pobi = RacingCar.from("pobi");
        RacingCar jun = RacingCar.from("jun");

        pobi.move(4);
        jun.move(4);

        RacingCars racingCars = RacingCars.from(List.of(pobi, jun));

        RacingCars winners = racingCars.findWinner();

        assertThat(winners.toString()).contains("pobi", "jun");
    }
}
