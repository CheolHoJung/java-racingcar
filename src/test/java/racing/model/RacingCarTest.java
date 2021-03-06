package racing.model;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;


public class RacingCarTest {

    @Test
    public void test_이동_임계점미달() {
        RacingCar car = new RacingCar();

        assertThat(car.move(0))
                .isEqualTo(0);
    }

    @Test
    public void test_이동_임계점통과() {
        RacingCar car = new RacingCar();

        assertThat(car.move(RacingCar.THRESHOLD_POWER))
                .isEqualTo(1);
    }

    @Test
    public void test_초기_위치_3에서_이동() {
        RacingCar car = new RacingCar(3);

        assertThat(car.move(RacingCar.THRESHOLD_POWER))
                .isEqualTo(4);
    }

    @Test
    public void test_위치_대소비교_추이성() {
        RacingCar carPositionedAt2 = new RacingCar(2);
        RacingCar carPositionedAt1 = new RacingCar(1);
        RacingCar carPositionedAt0 = new RacingCar();

        assertThat(carPositionedAt2.compareTo(carPositionedAt1))
                .isEqualTo(1);
        assertThat(carPositionedAt2.compareTo(carPositionedAt0))
                .isEqualTo(1);
    }

    @Test
    public void test_복사_참조_불일치() {
        RacingCar origin = new RacingCar();
        RacingCar copy = origin.copy();

        assertThat(origin)
                .isNotSameAs(copy);
    }

    @Test
    public void test_복사_위치_일치() {
        RacingCar origin = new RacingCar(3);
        RacingCar copy = origin.copy();

        assertThat(origin.getPosition())
                .isEqualTo(copy.getPosition());
    }
}