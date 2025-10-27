package racingcar.controller.dto;

public class WinnerDto {
    private final String winnerName;

    private WinnerDto(String winnerName) {
        this.winnerName = winnerName;
    }

    public static WinnerDto from(String winnerName) {
        return new WinnerDto(winnerName);
    }

    public String getWinnerName() {
        return winnerName;
    }

}
