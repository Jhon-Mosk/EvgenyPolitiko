package ru.geekbrains.Dz.Dz2.Task1;

public class MainClass {
    public static void main(String[] args) {
       Array ar=new Array(new String[4][4]);


       try {
           int sum = 0;
           int integer;
           String[][] arr = new String[4][4];
           for (int i=0;i<arr.length;i++){
               System.out.println();
               for(int j=0;j<arr.length;j++) {
                  try {

                      arr[i][j] = "f";

                      integer = Integer.parseInt(arr[i][j]);
                      sum += integer;


                  } catch (NumberFormatException e){
                      System.out.println("Нужно вводить цифры");
                      throw new MyArrayDataException(i, j);
                      
                  }
                   System.out.print(arr[i][j] + " ");
                   System.out.println(sum);


               }

           }
           System.out.println();
throw new MyArraySizeException(arr);
       } catch (MyArraySizeException e){
           e.printStackTrace();
       }


////        String[] [] array = {{"42432434"},{"214124"}};
//        String[][] array = {{},{}};
//for (int i = 0; i<array.length; i++){
//    for(int j=0; j<array.length;j++){
//        System.out.print(array [i][j]+" ");
//    }
//}
//
//
//        for(int i = 0;i<array.length;i++){
//            for(int j =0; j< array.length; j++){
//                array[i][j] = 2;
//                System.out.print(array[i][j] + " ");
//            }
//        }




            }
}
