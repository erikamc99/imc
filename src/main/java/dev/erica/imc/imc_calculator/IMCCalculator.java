package dev.erica.imc.imc_calculator;

public class IMCCalculator {

    public static double calculateIMC(double weight, double height) {
        if (weight <= 30 || height <= 1.4) {
            System.out.println("Valores inválidos, por favor consulte con su médico para un correcto cálculo si mide menos de 1,40 metros.");
            return -1;
        } return weight / Math.pow(height, 2);
    }

    public static String classificateIMC(double imc) {
        int grade = (imc < 16) ? 0 : (imc < 17) ? 1 : (imc < 18.5) ? 2 : (imc < 25) ? 3 : (imc < 30) ? 4 : (imc < 35) ? 5 : (imc < 40) ? 6 : 7;

        return switch(grade){
            case 0 -> "Delgadez severa";
            case 1 -> "Delgadez moderada";
            case 2 -> "Delgadez leve";
            case 3 -> "Peso normal";
            case 4 -> "Sobrepeso";
            case 5 -> "Obesidad leve";
            case 6 -> "Obesidad moderada";
            case 7 -> "Obesidad mórbida";
            default -> "No se puede clasificar debida a la altura y el peso proporcionados.";
        };
    }
}