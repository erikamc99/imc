package dev.erica.imc.imc_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class IMCCalculatorTest {
    @Test
    @DisplayName("Test para calcular el IMC")
    public void testIMCCalculator() {
        double weight = 50;
        double height = 1.60;

        assertThat((Double) IMCCalculator.calculateIMC(weight, height), closeTo(19.53, 0.01));
    }
}
