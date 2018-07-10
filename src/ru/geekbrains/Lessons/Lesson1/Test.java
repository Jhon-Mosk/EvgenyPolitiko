package ru.geekbrains.Lessons.Lesson1;


public class Test {
//    public static void main(String[] args) {
//        int i = 8;
//        System.out.println(i++);
//        System.out.println(i+1);
//        System.out.println(i);
//    }

}










//------------------------------

//
//class Task1 {
//    public static void main(String[] args) {
//        System.out.println(new Task1());
//    }
//
//}

//------------------------------















//------------------------------
//
    class A {
        {
            System.out.println("dym a");
        }

        static {
            System.out.println("stat a");
        }

        A(){
            System.out.println("A");
        }

        public static void main(String[] args) {
            new B();
        }
    }

    class B extends A {
        {
            System.out.println("dym B");
        }

        static {
            System.out.println("static B");
        }

        B() {
            System.out.println("B");
        }
    }
//------------------------------
















//------------------------------
//    class Test {
//        public static void changeNum(int a) {
//            a = 3;
//        }
//
//        public static void changeA(Aa a) {
//            a.i = 3;
//        }
//
//        public static void main(String[] args) {
//            int i = 7;
//            changeNum(i);
//            System.out.println(i);
//            Aa a = new Aa();
//            changeA(a);
//            System.out.println(a.i);
//        }
//
//        public static class Aa {
//            int i = 5;
//
//            public Aa() {
//                ++i;
//            }
//        }
//    }
//------------------------------





















//------------------------------
//    class Application {
//        public static void main(String[] args) {
//            infoT(1);
//        }
//
//        public static void infoT(int arg) {
//            if(arg < 37) {
//                infoT(arg + 10);
//            }
//            System.out.println(arg);
//        }
//    }
//------------------------------

