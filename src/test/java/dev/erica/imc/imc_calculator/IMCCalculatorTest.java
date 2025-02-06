package dev.erica.imc.imc_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

public class IMCCalculatorTest {
    @Test
    @DisplayName("Test para calcular el IMC")
    public void testIMCCalculator() {
        double weight = 50;
        double height = 1.60;

        assertThat((Double) IMCCalculator.calculateIMC(weight, height), closeTo(19.53, 0.01));
    }

    @Test
    @DisplayName("Test para clasificar el resultado según la tabla que establece los rangos")
    public void testIMCClassificator() {
        double imc1 = 15;
        double imc2 = 16;
        double imc3 = 18;
        double imc4 = 21;
        double imc5 = 27;
        double imc6 = 33;
        double imc7 = 37;
        double imc8 = 45;
        double imc9 = 99;

        assertThat(IMCCalculator.classificateIMC(imc1), equalTo("Delgadez severa"));
        assertThat(IMCCalculator.classificateIMC(imc2), equalTo("Delgadez moderada"));
        assertThat(IMCCalculator.classificateIMC(imc3), equalTo("Delgadez leve"));
        assertThat(IMCCalculator.classificateIMC(imc4), equalTo("Peso normal"));
        assertThat(IMCCalculator.classificateIMC(imc5), equalTo("Sobrepeso"));
        assertThat(IMCCalculator.classificateIMC(imc6), equalTo("Obesidad leve"));
        assertThat(IMCCalculator.classificateIMC(imc7), equalTo("Obesidad moderada"));
        assertThat(IMCCalculator.classificateIMC(imc8), equalTo("Obesidad mórbida"));
        assertThat(IMCCalculator.classificateIMC(imc9), equalTo("Clasificación no definida"));
    }
}