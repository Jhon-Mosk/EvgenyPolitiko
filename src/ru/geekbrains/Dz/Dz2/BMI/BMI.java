package ru.geekbrains.Dz.Dz2.BMI;


public class BMI {
    public static void main(String[] args) {

double [] weight={118, 106, 87, 45, 70, 54, 105, 50, 114, 72, 53, 66, 54, 95, 86, 62, 65};
        double []growth= {2.05, 1.77, 1.83, 1.12, 1.87, 1.57, 1.76, 1.96, 1.76, 2.45, 2.10,
                2.25, 1.50, 1.62, 1.72, 1.57, 2.24};
        Check m = new Check();
        double [] bmi = m.Check(weight,growth);
        for(int i=0;i<bmi.length;i++) {
            if (bmi[i] < 18.5) {
                System.out.println("Вес в килограммах: " + weight[i] + " , рост в метрах: " + growth[i]
                        + ". Недостаточная масса");
            } else if (bmi[i] >= 18.5 && bmi[i] <= 25) {
                System.out.println("Вес в килограммах: " + weight[i] + " , рост в метрах: " + growth[i]
                        + ". Нормальный вес");
            } else if (bmi[i] >= 25 && bmi[i] < 30) {
                System.out.println("Вес в килограммах: " + weight[i] + " , рост в метрах: " + growth[i]
                        + ". Избыточная масса");
            } else if (bmi[i] <= 30) {
                System.out.println("Вес в килограммах: " + weight[i] + " , рост в метрах: " + growth[i]
                        + ". Ожирение");
            }
        }

    }
}

