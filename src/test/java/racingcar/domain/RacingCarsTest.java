package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    void play_호출시_자동차중_일부는_상태가_변할_수_있다() {
        RacingCars racingCars = RacingCars.from(List.of("pobi", "java"));

        racingCars.play();

        // 각 자동차의 상태가 0 이상인지 확인
        racingCars.getRacingCars().forEach(car ->
                assertThat(car.getState()).isGreaterThanOrEqualTo(0)
        );
    }

    @Test
    void 비어있는_자동차리스트_생성_예외() {
        assertThatThrownBy(() -> RacingCars.from(List.of()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CAR_NAME_NULL);
    }

    @Test
    void 가장_큰_state를_가진_자동차를_우승자로_반환() {
        RacingCars racingCars = RacingCars.from(List.of("pobi", "jun", "park"));

        // 상태 직접 조작 (move 호출)
        racingCars.getRacingCars().get(0).move(4);
        racingCars.getRacingCars().get(0).move(4);
        racingCars.getRacingCars().get(1).move(4);
        racingCars.getRacingCars().get(2).move(3);

        RacingCars winners = racingCars.findWinner();

        assertThat(winners.toString()).contains("pobi");
        assertThat(winners.toString()).doesNotContain("jun", "park");
    }

    @Test
    void 최대값이_동일하면_공동_우승자를_반환() {
        RacingCars racingCars = RacingCars.from(List.of("pobi", "jun"));

        racingCars.getRacingCars().get(0).move(4);
        racingCars.getRacingCars().get(1).move(4);

        RacingCars winners = racingCars.findWinner();

        assertThat(winners.toString()).contains("pobi", "jun");
    }
}
