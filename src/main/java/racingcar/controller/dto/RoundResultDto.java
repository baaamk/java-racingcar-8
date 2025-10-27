package racingcar.controller.dto;

public class RoundResultDto {
    private final String racingCarName;
    private final int position;

    private RoundResultDto(String racingCarName, int position) {
        this.racingCarName = racingCarName;
        this.position = position;
    }

    public static RoundResultDto of(String racingCarName, int position) {
        return new RoundResultDto(racingCarName, position);
    }

    public String getRacingCarName() {
        return racingCarName;
    }
    public int getPosition() {
        return position;
    }
}
