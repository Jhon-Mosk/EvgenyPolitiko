package ru.geekbrains.Dz.Dz2.Task1;

class MyArrayDataException extends RuntimeException{
    int row, column;


    public MyArrayDataException(int row, int column) {
        super(row + " " + column);
        this.row = row;
        this.column = column;
    }
}



//public class MyArrayDataException extends Throwable {
//    public MyArrayDataException(String s) {
//        int integer;
//        integer = Integer.parseInt(s);
//
//
//
//        char[] chArray = s.toCharArray();
//        char c = s.charAt(0);
//int index = (int)c;
//        if(index==48||index!=49||index!=50||index!=51||index!=52||index!=53||index!=54||index!=55||
//                index!=56||index!=57){
//            System.out.println("Требуется вводить цифры");
//        }
//
//
//    }
//
//
//}
