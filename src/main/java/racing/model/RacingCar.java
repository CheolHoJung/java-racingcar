package racing.model;

public class RacingCar implements Comparable<RacingCar>, Cloneable {

    public static final int THRESHOLD_POWER = 4;

    private int position;

    public RacingCar() {

    }

    public RacingCar(int position) {
        this.position = position;
    }

    public int move(int power) {
        if (power >= THRESHOLD_POWER) {
            position++;
        }
        return position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(RacingCar car) {
        return Integer.compare(position, car.position);
    }

    @Override
    public RacingCar clone() {
        try {
            return (RacingCar) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
