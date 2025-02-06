package dev.erica.imc;

import java.util.Scanner;

import dev.erica.imc.imc_calculator.IMCCalculator;

public final class App {

    /**
     * @param args The arguments of the program.
     */
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void main(String[] args) {
        double weight, height, imc;

        Scanner scanner = new Scanner(System.in);

        System.out.println("================================================================================================");
        System.out.println("CALCULADORA IMC PARA ADULTOS *");
        System.out.println(RED + "*Si tiene alguna condición que pueda afectar al cálculo, por favor consulte con su médico." + RESET);
        System.out.println("================================================================================================");
        
        do {
            System.out.println("Ingrese su peso en kilogramos:");
            weight = scanner.nextDouble();

            System.out.println("Ingrese su estatura en metros:");
            height = scanner.nextDouble();

            imc = IMCCalculator.calculateIMC(weight, height);

        } while (imc == -1);

        String classification = IMCCalculator.classificateIMC(imc);
        System.out.println(String.format("Su IMC es: %.2f. Clasificación: %s", imc, classification));

        scanner.close();
    }
}