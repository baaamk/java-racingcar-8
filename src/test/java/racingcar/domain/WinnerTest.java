package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

    @Test
    @DisplayName("RacingCars로부터 Winner 생성 가능")
    void 우승자_생성() {
        RacingCars racingCars = RacingCars.from(List.of("pobi", "java"));

        Winner winner = Winner.from(racingCars);

        assertThat(winner.winners()).isEqualTo(racingCars);
        assertThat(winner.winners().getRacingCars()).hasSize(2);
        assertThat(winner.winners().getRacingCars().getFirst().getRacingCarName()).isEqualTo("pobi");
    }

    @Test
    @DisplayName("Winner 내부의 RacingCars는 불변이다")
    void 우승자_불변성_확인() {
        RacingCars before = RacingCars.from(List.of("pobi", "java"));
        Winner winner = Winner.from(before);

        RacingCars after = winner.winners();

        assertThat(after).isEqualTo(before);
        assertThat(after).isNotNull();
    }
}
