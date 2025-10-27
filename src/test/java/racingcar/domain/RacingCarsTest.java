package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {

    @Test
    @DisplayName("names로부터 RacingCars 생성")
    void 생성_from_문자열리스트() {
        RacingCars cars = RacingCars.from(List.of("pobi", "java"));
        assertThat(cars.getRacingCars()).hasSize(2);
        assertThat(cars.getRacingCars().get(0).getRacingCarName()).isEqualTo("pobi");
        assertThat(cars.getRacingCars().get(1).getRacingCarName()).isEqualTo("java");
    }

    @Test
    @DisplayName("중복 이름이면 예외")
    void 중복_이름_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCars.from(List.of("pobi", "pobi")))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_DUPLICATED_NAME)
        );
    }

    @Test
    @DisplayName("빈 목록이면 예외")
    void 빈목록_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCars.from(List.of()))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_NULL)
        );
    }

    @Test
    @DisplayName("play() 한 라운드에서 랜덤이 4 이상인 차만 전진한다")
    void 한라운드_전진규칙() {
        RacingCars before = RacingCars.from(List.of("pobi", "java"));

        assertRandomNumberInRangeTest(
                () -> {
                    RacingCars after = before.play();
                    List<RacingCar> list = after.getRacingCars();
                    assertThat(list.get(0).getPosition()).isEqualTo(1); // pobi
                    assertThat(list.get(1).getPosition()).isEqualTo(0); // java
                },
                4, 3
        );
    }

    @Test
    @DisplayName("play()는 불변 — 새 인스턴스를 반환하고 기존은 그대로")
    void 불변성_보장() {
        RacingCars before = RacingCars.from(List.of("pobi", "java"));

        assertRandomNumberInRangeTest(
                () -> {
                    RacingCars after = before.play();

                    assertThat(before.getRacingCars().get(0).getPosition()).isEqualTo(0);
                    assertThat(before.getRacingCars().get(1).getPosition()).isEqualTo(0);

                    assertThat(after.getRacingCars().get(0).getPosition()).isEqualTo(1);
                    assertThat(after.getRacingCars().get(1).getPosition()).isEqualTo(0);

                    assertThat(after).isNotSameAs(before);
                },
                9, 0
        );
    }

    @Test
    @DisplayName("findWinner()는 최대 위치와 같은 모든 자동차를 반환한다(공동우승)")
    void 우승자_공동우승() {
        RacingCars cars = RacingCars.from(List.of("pobi", "java", "honux"));

        assertRandomNumberInRangeTest(
                () -> {
                    RacingCars after1 = cars.play();
                    RacingCars winners = after1.findWinner();

                    List<RacingCar> w = winners.getRacingCars();
                    assertThat(w).extracting(RacingCar::getRacingCarName)
                            .containsExactlyInAnyOrder("pobi", "honux");
                    assertThat(w.get(0).getPosition()).isEqualTo(1);
                    assertThat(w.get(1).getPosition()).isEqualTo(1);
                },
                4, 3, 7
        );
    }
}
