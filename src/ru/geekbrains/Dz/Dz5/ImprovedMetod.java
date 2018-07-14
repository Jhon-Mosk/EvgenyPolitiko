package ru.geekbrains.Dz.Dz5;

import java.util.ArrayList;

public class ImprovedMetod {
    public static void main(String[] args) {

        metodWithThread(2);

    }

    private static void metodWithThread(int x) {
        final int size = 10000000;
        final int h = size / x ;
        ArrayList<Float> arr = new ArrayList<>(size);
        float [] a1 = new float[h];
        float [] a2 = new float[h];
        for (int i = 0; i <arr.size() ; i++) {
            arr.set(i, (float) 1);
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        int fromIndex=0;
        int toIndex=0;
        for (int i = 0; i <arr.size() ; i++) {

        }

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




}


