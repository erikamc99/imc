package dev.erica.imc.imc_calculator;

import dev.erica.imc.utils.AnsiColors;

public class IMCCalculator {

    public static double calculateIMC(double weight, double height) {
        if (weight <= 30 || height <= 1.4) {
            System.out.println(AnsiColors.RED + "Valores inválidos, por favor consulte con su médico para un correcto cálculo si mide menos de 1,40 metros." + AnsiColors.RESET);
            return -1;
        } return weight / Math.pow(height, 2);
    }

    public static String classificateIMC(double imc) {
        if (imc == -1) {
            return AnsiColors.RED + "No se puede clasificar debido a la altura y el peso proporcionados." + AnsiColors.RESET;
        }

        int grade = (imc < 16) ? 0 : (imc < 17) ? 1 : (imc < 18.5) ? 2 : (imc < 25) ? 3 : (imc < 30) ? 4 : (imc < 35) ? 5 : (imc < 40) ? 6 : (imc < 70) ? 7 : -1;

        return switch(grade){
            case 0 -> AnsiColors.RED + "Delgadez severa" + AnsiColors.RESET;
            case 1 -> AnsiColors.ORANGE + "Delgadez moderada" + AnsiColors.RESET;
            case 2 -> AnsiColors.LIGHT_YELLOW + "Delgadez leve" + AnsiColors.RESET;
            case 3 -> AnsiColors.GREEN + "Peso normal" + AnsiColors.RESET;
            case 4 -> AnsiColors.LIGHT_YELLOW + "Sobrepeso" + AnsiColors.RESET;
            case 5 -> AnsiColors.YELLOW + "Obesidad leve" + AnsiColors.RESET;
            case 6 -> AnsiColors.ORANGE + "Obesidad moderada" + AnsiColors.RESET;
            case 7 -> AnsiColors.RED + "Obesidad mórbida" + AnsiColors.RESET;
            default -> AnsiColors.BRIGHT_RED + "Clasificación no definida, por favor consulte con su médico." + AnsiColors.RESET;
        };
    }
}