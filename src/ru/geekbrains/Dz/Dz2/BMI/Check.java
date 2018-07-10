package ru.geekbrains.Dz.Dz2.BMI;

public class Check {
    double [] Check(double[] weight, double[] growth) {

        double bmi [] = new double[weight.length];
        for (int i = 0; i < weight.length; i++) {
            bmi[i] = weight[i] / (growth[i] * growth[i]);
        }
            return bmi;


    }
}
