package racingcar.view;

import racingcar.controller.dto.RoundResultDto;
import racingcar.controller.dto.WinnerDto;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.List;
import java.util.Map;

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
    public void roundResultPrint(RoundResultDto roundResultDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("실행 결과").append("\n");

        roundResultDto.getRacingResults().entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    RacingCars racingCars = entry.getValue();

                    racingCars.getRacingCars().forEach(car -> {
                        sb.append(car.getCarName())
                                .append(" : ")
                                .append("-".repeat(car.getState()))
                                .append("\n");
                    });

                    sb.append("\n");
                });
        System.out.println(sb);

    }

    @Override
    public void winnerPrint(WinnerDto winnerDto) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        List<String> list = winnerDto.getRacingCars().stream().map(RacingCar::getCarName).toList();
        sb.append(String.join(", ", list));

        System.out.println(sb);
    }
}
