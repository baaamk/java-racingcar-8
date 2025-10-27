package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    private RacingCar createCarForTest(String name, int position) {
        try {
            Constructor<RacingCar> constructor =
                    RacingCar.class.getDeclaredConstructor(RacingCarName.class, RacingCarPosition.class);
            constructor.setAccessible(true);
            return constructor.newInstance(RacingCarName.from(name), RacingCarPosition.of(position));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("자동차는 이름과 초기 위치(0)로 생성된다")
    void 자동차_생성_테스트() {
        RacingCarName pobiName = RacingCarName.from("pobi");

        RacingCar pobi = RacingCar.from(pobiName);

        assertThat(pobi.getRacingCarName()).isEqualTo("pobi");
        assertThat(pobi.getPosition()).isZero();
    }

    @Test
    @DisplayName("랜덤 숫자가 4 이상일 경우 자동차는 전진한다")
    void 자동차_전진_테스트() {
        RacingCar pobi = RacingCar.from(RacingCarName.from("pobi"));

        RacingCar movedPobi = pobi.move(4);

        assertThat(movedPobi.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 숫자가 4 미만일 경우 자동차는 전진하지 않는다")
    void 자동차_정지_테스트() {
        RacingCar pobi = RacingCar.from(RacingCarName.from("pobi"));

        RacingCar stoppedPobi = pobi.move(3);

        assertThat(stoppedPobi.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 위치 비교 테스트 (private 생성자 유지)")
    void 자동차_비교_테스트() {
        RacingCar pobi = createCarForTest("pobi", 3);
        RacingCar java = createCarForTest("java", 1);

        assertThat(pobi.isMoreThan(java)).isTrue();
        assertThat(java.isMoreThan(pobi)).isFalse();
    }

    @Test
    @DisplayName("자동차 동일 위치 비교 테스트 (private 생성자 유지)")
    void 자동차_동일위치_테스트() {
        RacingCar pobi = createCarForTest("pobi", 2);
        RacingCar java = createCarForTest("java", 2);

        assertThat(pobi.isAtSamePositionAs(java)).isTrue();
    }

    @Test
    @DisplayName("자동차 이름이 같으면 equals가 true를 반환한다")
    void 자동차_이름_기준_동등성_테스트() {
        RacingCar pobi = RacingCar.from(RacingCarName.from("pobi"));
        RacingCar pobi2 = RacingCar.from(RacingCarName.from("pobi"));
        RacingCar java = RacingCar.from(RacingCarName.from("java"));

        assertThat(pobi).isEqualTo(pobi2);
        assertThat(pobi).isNotEqualTo(java);
    }

    @Test
    @DisplayName("자동차 이름이 같으면 hashCode도 동일해야 한다")
    void 자동차_hashCode_테스트() {
        RacingCar pobi = RacingCar.from(RacingCarName.from("pobi"));
        RacingCar pobi2 = RacingCar.from(RacingCarName.from("pobi"));

        assertThat(pobi.hashCode()).isEqualTo(pobi2.hashCode());
    }
}
