package dev.erica.imc.imc_calculator;

public class IMCCalculator {

    public static double calculateIMC(double weight, double height) {
        if (weight <= 30 || height <= 1.4) {
            System.out.println("Valores inválidos, por favor consulte con su médico para un correcto cálculo si mide menos de 1,40 m.");
            return -1;
        } return weight / Math.pow(height, 2);
    }

    public static String classificateIMC(double imc) {
        
    }

}