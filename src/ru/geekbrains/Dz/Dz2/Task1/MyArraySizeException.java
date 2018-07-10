package ru.geekbrains.Dz.Dz2.Task1;

public class MyArraySizeException extends Throwable {
    public MyArraySizeException(String[][]arr) {
        if(arr.length>4){
            System.out.println("Размер массива не может быть больше 4");
        }
    }
}
