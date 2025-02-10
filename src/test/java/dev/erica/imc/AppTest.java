package dev.erica.imc;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
*/

public class AppTest {

    @Test
    @DisplayName("Test del UI en App para cobertura mayor al 70%")
    void testIMCNormal() {
        ByteArrayInputStream testInput = new ByteArrayInputStream("70\n1,75\n".getBytes());
        System.setIn(testInput);

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        App.main(new String[]{});

        String expectedOutput = """
================================================================================================
\033[35mCALCULADORA IMC PARA ADULTOS \u001B[0m*
\u001B[91m*Si tiene alguna condición que pueda afectar al cálculo, por favor consulte con su médico.\u001B[0m
================================================================================================
\033[96mIngrese su peso en kilogramos:\u001B[0m
\033[96mIngrese su estatura en metros:\u001B[0m
Su IMC es: 22,86. Clasificación: \033[32mPeso normal\u001B[0m
""";

        String outputReplacement = testOutput.toString().replaceAll("\r\n", "\n");
        String expectedOutputReplacement = expectedOutput.replaceAll("\r\n", "\n");

        assertThat(outputReplacement.trim(), is(expectedOutputReplacement.trim()));
    }
}

    