package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingTest {

    @Test
    void 라운드별_스냅샷_독립적_저장테스트() {
        RacingCars racingCars = RacingCars.from(List.of("pobi"));
        Racing racing = Racing.of(3, racingCars);

        Map<Integer, RacingCars> results = racing.playRacing(3);

        RacingCars firstRound = results.get(1);
        RacingCars lastRound = results.get(3);

        assertThat(firstRound).isNotSameAs(lastRound);
    }


}