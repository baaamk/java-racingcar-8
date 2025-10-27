package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarPositionTest {

    @Test
    @DisplayName("초기 위치를 생성할 수 있다")
    void 위치_생성() {
        RacingCarPosition position = RacingCarPosition.of(0);
        assertThat(position.getFinalPosition()).isZero();
    }

    @Test
    @DisplayName("move() 호출 시 위치가 1 증가한다")
    void 위치_이동() {
        RacingCarPosition position = RacingCarPosition.of(2);
        RacingCarPosition moved = position.move();

        assertThat(moved.getFinalPosition()).isEqualTo(3);
        assertThat(position.getFinalPosition()).isEqualTo(2); // 불변 확인
    }

    @Test
    @DisplayName("현재 위치가 다른 위치보다 크면 true를 반환한다")
    void 위치_비교_isMoreThan() {
        RacingCarPosition position3 = RacingCarPosition.of(3);
        RacingCarPosition position1 = RacingCarPosition.of(1);

        assertThat(position3.isMoreThan(position1)).isTrue();
        assertThat(position1.isMoreThan(position3)).isFalse();
    }

    @Test
    @DisplayName("두 위치가 같으면 true를 반환한다")
    void 위치_동일_isSameAs() {
        RacingCarPosition positionA = RacingCarPosition.of(2);
        RacingCarPosition positionB = RacingCarPosition.of(2);

        assertThat(positionA.isSameAs(positionB)).isTrue();
    }

    @Test
    @DisplayName("두 위치가 다르면 false를 반환한다")
    void 위치_다름_isSameAs() {
        RacingCarPosition positionA = RacingCarPosition.of(1);
        RacingCarPosition positionB = RacingCarPosition.of(3);

        assertThat(positionA.isSameAs(positionB)).isFalse();
    }
}
