package dev.erica.imc.imc_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IMCCalculatorTest {
    @Test
    @DisplayName("Test para calcular el IMC")
    public void testIMCCalculator() {
        double weight = 50;
        double height = 1.60;
        double weight2 = 70;
        double height2 = 1.75;
        double weight3 = 10;
        double height3 = 1.20;

        assertThat(IMCCalculator.calculateIMC(weight, height), closeTo(19.53, 0.01));
        assertThat(IMCCalculator.calculateIMC(weight2, height2), closeTo(22.86, 0.01));
        assertThat(IMCCalculator.calculateIMC(weight3, height3), equalTo(-1.0));
        assertThat(IMCCalculator.calculateIMC(weight3, height), equalTo(-1.0));
        assertThat(IMCCalculator.calculateIMC(weight, height3), equalTo(-1.0));
    }

    @Test
    @DisplayName("Test para verificar el mensaje de error")
    public void testIMCErrorMessage() {
        ByteArrayOutputStream errorMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(errorMessage));

        IMCCalculator.calculateIMC(20, 1.8);

        assertThat(errorMessage.toString().trim(), equalTo("Valores inválidos, por favor consulte con su médico para un correcto cálculo si mide menos de 1,40 metros."));
        System.setOut(System.out);
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
        assertThat(IMCCalculator.classificateIMC(-1), equalTo("No se puede clasificar debido a la altura y el peso proporcionados."));
    }
}