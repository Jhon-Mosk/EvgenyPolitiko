package ru.geekbrains.Lessons.Lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainException {
    public static void main(String[] args) {



    //    throw new RuntimeException("my EXCEPTION!!!");

//        try {
//            FileInputStream fileInputStream = new FileInputStream("1.txt");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        try {
//            System.out.println(sqrt(-10));
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//        System.out.println(1);

        System.out.println(sendMsg());

    }

    static int sendMsg() {

        try {
            return 1;
        } finally {
            return 2;
        }

    }


    public static int sqrt(int n) {
        if(n > 0) {
            return n/2;
        }

        throw new ArithmeticException("нельзя отрицательное!");
    }




    public static void someThing() throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("1.txt");
    }



//    public static void a() {
//        b();
//    }
//
//    public static void b() {
//        c();
//    }
//
//    public static void c() {
//        d();
//    }
//
//    public static void d() {
//        int a = 0;
//        int b = 10 / a;
//    }
}
