package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car = new Car();

    @DisplayName("이동")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void move(boolean movable, int expected) {
        car.move(() -> movable);
        assertThat(car.getPosition()).isEqualTo(new Position(expected));
    }
}
