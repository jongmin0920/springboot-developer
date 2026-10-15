package me.jmlee.springdeveloper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    @DisplayName("1 더하기 2는 3이다")
    void additionTest() {
        // given
        int a = 1;
        int b = 2;
        Calculator calc = new Calculator();

        // when
        int result = calc.add(a, b);

        // then
        assertThat(result).isEqualTo(3);
    }
}