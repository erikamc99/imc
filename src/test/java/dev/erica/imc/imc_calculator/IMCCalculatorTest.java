package dev.erica.imc.imc_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IMCCalculatorTest {
    @Test
    @DisplayName("Test para calcular el IMC")
    public void testIMCCalculator() {
        double weight = 50;
        double height = 1.60;

        assertThat(IMCCalculator.calculateIMC(weight, height), closeTo(19.53, 0.01));
    }
}
