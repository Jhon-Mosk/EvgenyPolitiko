package ru.geekbrains.Dz.Dz6;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        int [] arr = {5, 3, 2, 9, 7, 4};    //для сортировки в обратном порядке
        for (int i = 0; i <arr.length; i++) {   // arr.lenght - 1
            for (int j = 0; j <arr.length ; j++) {  // j = i -1

                if(arr[i]<arr[j]){
                    int a = arr[i];
                    arr[i]=arr[j];
                    arr[j]=a;
                }
                
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
