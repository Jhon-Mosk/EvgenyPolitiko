package ru.geekbrains.Lessons.Lesson2;

public class FactorialException extends Exception {
    private int number;

    public int getNumber() {
        return number;
    }

    public FactorialException(String msg, int number) {
        super(msg);
        this.number = number;
    }
}

class Factorial {
    public static int getFactorial(int num) throws FactorialException {
        int result = 1;
        if(num < 1) throw new FactorialException("Число не может быть меньше 1", num);

        for (int i = 1; i <= num ; i++) {
            result *= i;
        }


        return result;
    }
}


class MainEx {
    public static void main(String[] args) {
        try {
            int result = Factorial.getFactorial(-10);
        } catch (FactorialException e) {

            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

