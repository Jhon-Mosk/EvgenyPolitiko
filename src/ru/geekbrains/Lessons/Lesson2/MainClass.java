package Lesson2;

import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int sum = 0;
        Random random = new Random();
        String[][] sArray = new String[4][4];

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                sArray[i][j] = String.valueOf(random.nextInt(50));
            }
        }

        sArray[2][3] = "1a";

        try {
            sum = sumArray(sArray);
        } catch (MyArraySizeExeption e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }

    public static int sumArray(String[][] sArray){
        int sum = 0;
        if(sArray.length != 4) throw new MyArraySizeExeption();
        for(int i = 0; i < sArray.length; i++) {
            if(sArray[i].length != 4) throw new MyArraySizeExeption();
            for(int j = 0; j < sArray[i].length; j++) {
                try {
                    sum += Integer.parseInt(sArray[i][j]);
                }catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }

            }
        }
        return sum;
    }


}

class MyArrayDataException extends RuntimeException{
    int row, column;

    public MyArrayDataException(int row, int column) {
        super(row + " " + column);
        this.row = row;
        this.column = column;
    }
}

class MyArraySizeExeption extends RuntimeException{

    public MyArraySizeExeption() {
        super("wrong size");
    }

}






















//    /////////////////   case при большом списке будет не актуален
//    private void getWorkingHours(DayOfWeek dayOfWeek) {
//        +        double workingHourse = 0;
//        +        switch (dayOfWeek.getIndex()){
//            +                case 1:
//                +            case 2:
//                +            case 3:
//                +            case 4:
//                +            case 5:{
//                +
//                        +  for (int i = dayOfWeek.getIndex(); i <= 5; i++) {
//                    +                    workingHourse += DayOfWeek.values()[i].getCountWorkHours();
//                    +
//                            +                }
//                +                System.out.println("Осталось проработать " +  workingHourse + " часов");
//                +                break;
//                +            }
//            +            case 6:
//                +            case 7: {
//                +                System.out.println("Сегодня выходной!!!");
//                +                break;
//                +            }
//            +        }
//
//
////////////////// заполнение массива
//
//
//
//        stringsArray[0] = new String[]{"l", "2", "3", "4"};
//        stringsArray[1] = new String[]{"5", "6", "7", "8"};
//        stringsArray[2] = new String[]{"l", "2", "3", "4"};
//        stringsArray[3] = new String[]{"5", "6", "7", "8"};
//
//        String[][] array = {
//                {"1", "2", "3", "4"},
//                {"5", "6", "7", "8"},
//                {"9", "10", "11", "12"},
//                {"13", "14", "15", "16"},
//        };
//
//
//
//
////////////////////////// внутрений массив может быть разного размера
//
//
//
//        public static void ArraySize(String[][] arrayInput) {
//            if (arrayInput.length > 3) try {
//                throw new MyArraySizeException("Превышен размер массива");
//            } catch (MyArraySizeException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public static void ArraySymbol(String[][] arrayInput) throws MyArrayDataEcxeption {
//            int x = 0;
//            for (int i = 0; i < arrayInput.length; i++) {
//                for (int j = 0; j < arrayInput.length; j++) {
//                    try {
//                        x += Integer.parseInt(arrayInput[i][j]);
//                    } catch (NumberFormatException e) {
//                        throw new MyArrayDataEcxeption("Неверный символ в массиве. " + "Столбец " + j + " Строка " + i);
//                    }
//                }
//            }
//            System.out.println("Сумма элементов в массиве = " + x);
//
//        }
//
//        ///////////////////////// внутрений массив может быть разного размера
//
//
//        int sums = 0;
//        +        for (int i = 0; i < 4; i++) {
//            +            for (int j = 0; j < 4; j++) {
//                +                try {
//                    +                    sums = sums + Integer.parseInt(array[i][j]);
//                    +                } catch (Exception e) {
//                    +                    System.out.println("MyArrayDataException: array" + "[" + i + "]" + "[" + j + "] =" + e);
//                    +                }
//                +
//                        +            }
//            +        }
//        +        System.out.println(sums);
//
//
//
//        ///////////////////////// не привязываться к конкретным размерам
//
//
//        +    private static int checkSum (String[][] in)throws MyArrayDataException{
//            +        boolean e = true;// отсутсвие ошибок
//            +        String s = ""; // выведет текст ошибки
//            +
//                    +        int sum = 0;
//            +        for (int i = 0; i < 4; i++) {
//                +            for (int j = 0; j < 4; j++) {
//                    +                try {
//                        +                    sum += Integer.parseInt(in[i][j]);
//                        +                } catch (Exception e1){
//                        +                    e = false;
//                        +                    s += "("+i+","+j+") ";
//                        +                }
//                    +
//                            +            }
//                +        }
//            +        if (!e) throw new MyArrayDataException(s);
//            +        return sum;
//            +    }
