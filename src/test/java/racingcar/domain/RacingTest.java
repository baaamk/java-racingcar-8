package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingTest {

    @Test
    void 라운드별_스냅샷_독립적_저장테스트() {
        // given
        RacingCar pobi = RacingCar.from("pobi");
        RacingCars racingCars = RacingCars.from(java.util.List.of(pobi));
        Racing racing = Racing.of(3, racingCars);

        // when
        Map<Integer, RacingCars> results = racing.playRacing(3);

        // then
        RacingCars firstRound = results.get(1);
        RacingCars lastRound = results.get(3);

        assertThat(firstRound).isNotSameAs(lastRound);
    }


}