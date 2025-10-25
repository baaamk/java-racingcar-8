package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Racing {
    private final int totalRound;
    private final RacingCars racingCars;
    private final Map<Integer, RacingCars> roundResult;

    private Racing(int totalRound, RacingCars racingCars, Map<Integer, RacingCars> roundResult) {
        this.totalRound = totalRound;
        this.racingCars = racingCars;
        this.roundResult = roundResult;
    }

    public static Racing of(int totalRound, RacingCars racingCars) {
        Map<Integer, RacingCars> roundResult = new HashMap<>();
        return new Racing(totalRound, racingCars, roundResult);
    }

    public Map<Integer, RacingCars> playRacing(int totalRound) {
        for (int i = 1; i <= totalRound; i++) {
            racingCars.play();
            roundResult.put(i, racingCars.copyRacingCars());
        }
        return roundResult;
    }



}
