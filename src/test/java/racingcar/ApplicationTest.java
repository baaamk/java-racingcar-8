package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("기능: 2대 1라운드 — 첫 번째만 전진, pobi 우승")
    void 기능_1라운드_전진정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("pobi : -")
                            .contains("woni : ")
                            .contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("기능: 2대 2라운드 — 서로 1번씩 전진, 공동 우승(pobi,woni)")
    void 기능_2라운드_공동우승() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "2");
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("pobi : -")
                            .contains("woni : -")
                            .contains("최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("기능: 이름 하나만 입력해도 동작하며 우승자는 단일 이름")
    void 기능_이름하나_허용() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi", "1");
                    assertThat(output())
                            .contains("실행 결과")
                            .contains("pobi : -")
                            .contains("최종 우승자 : pobi");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("예외: 자동차 이름 길이 6자 이상")
    void 예외_이름길이_초과() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: 숫자 입력 앞뒤 공백")
    void 예외_숫자앞뒤공백() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", " 1 "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: 소수 입력")
    void 예외_소수입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1.0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외: 0 입력(0 이하는 불가)")
    void 예외_0입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
