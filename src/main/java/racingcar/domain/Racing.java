package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Racing {
    private final TryNumber totalRound;
    private final RacingCars racingCars;
    private final Map<Integer, RacingCars> roundResults;

    private Racing(TryNumber totalRound, RacingCars racingCars, Map<Integer, RacingCars> roundResults) {
        this.totalRound = totalRound;
        this.racingCars = racingCars;
        this.roundResults = roundResults;
    }

    public static Racing of(TryNumber totalRound, RacingCars racingCars) {
        Map<Integer, RacingCars> roundResult = new HashMap<>();
        return new Racing(totalRound, racingCars, roundResult);
    }

    public Map<Integer, RacingCars> playRacing() {
        RacingCars currentCars = racingCars;
        for (int i = 1; i <= totalRound.getTryNumber(); i++) {
            currentCars = currentCars.play();
            roundResults.put(i, currentCars);
        }
        return roundResults;
    }

}
