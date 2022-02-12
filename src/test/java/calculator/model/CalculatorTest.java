package calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.Calculator;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 덧셈() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateByOperator(Arrays.asList("2", "+", "3"));
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 뺄셈() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateByOperator(Arrays.asList("3", "-", "2"));
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 곱셉() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateByOperator(Arrays.asList("2", "*", "3"));
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        Calculator calculator = new Calculator();
        double result = calculator.calculateByOperator(Arrays.asList("3", "/", "2"));
        assertThat(result).isEqualTo(1.5);
    }
}