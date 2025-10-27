package racingcar.presentation.view;

import racingcar.controller.dto.RoundResultsDto;
import racingcar.controller.dto.WinnersDto;

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
    public void roundResultPrint(RoundResultsDto roundResultsDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append("\n");

        roundResultsDto.asViewRows().forEach((round, roundResultDtos) -> {
            roundResultDtos.forEach(roundResultDto -> sb.append(roundResultDto.getRacingCarName())
                    .append(" : ")
                    .append("-".repeat(roundResultDto.getPosition()))
                    .append("\n"));
            sb.append("\n");
        });
        System.out.println(sb);
    }

    @Override
    public void winnerPrint(WinnersDto winnersDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        sb.append(winnersDto.toString());

        System.out.println(sb);
    }
}
