package dev.erica.imc;

import java.util.Scanner;

import dev.erica.imc.imc_calculator.IMCCalculator;
import dev.erica.imc.utils.AnsiColors;

public final class App {

    /**
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        double weight, height, imc;

        Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("================================================================================================");
        System.out.println(AnsiColors.MAGENTA + "CALCULADORA IMC PARA ADULTOS " + AnsiColors.RESET + "*");
        System.out.println(AnsiColors.BRIGHT_RED + "*Si tiene alguna condición que pueda afectar al cálculo, por favor consulte con su médico." + AnsiColors.RESET);
        System.out.println("================================================================================================");
        
        do {
            System.out.println(AnsiColors.BRIGHT_CYAN + "Ingrese su peso en kilogramos:" + AnsiColors.RESET);
            weight = scanner.nextDouble();

            System.out.println(AnsiColors.BRIGHT_CYAN + "Ingrese su estatura en metros:" + AnsiColors.RESET);
            height = scanner.nextDouble();

            imc = IMCCalculator.calculateIMC(weight, height);

        } while (imc == -1);

        String classification = IMCCalculator.classificateIMC(imc);
        System.out.println(String.format("Su IMC es: %.2f. Clasificación: %s", imc, classification));

        scanner.close();
    }
}