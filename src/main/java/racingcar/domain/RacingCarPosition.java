package racingcar.domain;

public class RacingCarPosition {
    private final int position;

    private RacingCarPosition(int position) {
        this.position = position;
    }

    public static RacingCarPosition of(int position) {
        return new RacingCarPosition(position);
    }

    public RacingCarPosition move() {
        return new RacingCarPosition(position+1);
    }

    public int getFinalPosition() {
        return position;
    }

    public boolean isMoreThan(RacingCarPosition otherCar) {
        return this.position > otherCar.position;
    }

    public boolean isSameAs(RacingCarPosition otherCar) {
        return this.position == otherCar.position;
    }
}
