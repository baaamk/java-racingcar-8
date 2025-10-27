package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.global.ErrorMessage;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarNameTest {

    @Test
    @DisplayName("이름이 1~5자면 생성된다")
    void 이름_정상_생성() {
        RacingCarName pobi = RacingCarName.from("pobi");
        RacingCarName java = RacingCarName.from("java");

        assertThat(pobi.getInputName()).isEqualTo("pobi");
        assertThat(java.getInputName()).isEqualTo("java");
    }

    @Test
    @DisplayName("이름이 6자 이상이면 예외 발생")
    void 이름_6자_이상_예외() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> RacingCarName.from("abcdef"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(ErrorMessage.INVALID_CAR_NAME_MAX_LENGTH)
        );
    }

    @Test
    @DisplayName("같은 이름이면 equals true")
    void 이름_같으면_같다고_판단() {
        RacingCarName pobi = RacingCarName.from("pobi");
        RacingCarName pobi2 = RacingCarName.from("pobi");

        assertThat(pobi).isEqualTo(pobi2);
    }

    @Test
    @DisplayName("다른 이름이면 equals false")
    void 이름_다르면_다르다고_판단() {
        RacingCarName pobi = RacingCarName.from("pobi");
        RacingCarName java = RacingCarName.from("java");

        assertThat(pobi).isNotEqualTo(java);
    }

    @Test
    @DisplayName("같은 이름이면 hashCode도 동일")
    void 이름_같으면_hashcode_동일() {
        RacingCarName pobi = RacingCarName.from("pobi");
        RacingCarName pobi2 = RacingCarName.from("pobi");

        assertThat(pobi.hashCode()).isEqualTo(pobi2.hashCode());
    }
}
