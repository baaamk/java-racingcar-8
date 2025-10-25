package racingcar.view;

public class OutputViewImpl implements OutputView {

    @Override
    public void initialPrint() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void NumberRequestPrint() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void roundResultPrint() {
        System.out.println("실행 결과");
    }

    @Override
    public void winnerPrint() {
        System.out.print("최종 우승자 : ");
    }
}
