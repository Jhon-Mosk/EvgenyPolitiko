package ru.geekbrains.Dz.Dz5;

import java.util.ArrayList;
import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        metodWithoutThread();
        metodWithThread();

    }

    private static void metodWithThread() {
        final int size = 10;
        final int h = size / 2 ;
        float [] arr = new float [ size ];
        float [] a1 = new float[h];
        float [] a2 = new float[h];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=1;


        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <a1.length ; i++) {
                    a1[i] =( float )( a1 [ i ] * Math . sin ( 0.2f + i / 5 ) * Math . cos ( 0.2f + i / 5 ) *
                            Math . cos ( 0.4f + i / 2 ));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <a2.length ; i++) {
                    a2[i] =( float )( a2 [ i ] * Math . sin ( 0.2f + i / 5 ) * Math . cos ( 0.2f + i / 5 ) *
                            Math . cos ( 0.4f + i / 2 ));
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1, 0, arr, 0, h);
          System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время вычисления по формуле и заполнения массива новыми данными: " +
                (System.currentTimeMillis()-a) + " миллисекунд. Что равняется: "
                + (System.currentTimeMillis()-a)*0.001+" секунды."+ "\n");

    }

    private static void metodWithoutThread() {
        final int size = 10000000;
        float [] arr = new float [ size ];
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i <arr.length ; i++) {
            arr [ i ] = ( float )( arr [ i ] * Math . sin ( 0.2f + i / 5 ) * Math . cos ( 0.2f + i / 5 ) *
                    Math . cos ( 0.4f + i / 2 ));
        }
        System.out.println("Время вычисления по формуле и заполнения массива новыми данными: " +
                (System.currentTimeMillis()-a) + " миллисекунд. Что равняется: "
                + (System.currentTimeMillis()-a)*0.001+" секунды."+ "\n");


    }


}

