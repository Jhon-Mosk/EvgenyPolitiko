package ru.geekbrains.Lessons.Lesson2;

public class Outer {
    int outerVar;

    public Outer(int outerVar) {
        this.outerVar = outerVar;
    }

    class Inner {
        private int innerVar;

        public Inner(int innerVar) {
            this.innerVar = innerVar;
        }

        void innerTest() {
            System.out.println("inner" + innerVar);
            System.out.println("outer" + outerVar);
        }
    }

    void outerTest() {
    //    System.out.println("inner" + innerVar);
        System.out.println("outer" + outerVar);
    }
}

class MainOuterAndInner {
    public static void main(String[] args) {



        Outer.Inner inner = new Outer(10).new Inner(20);

    }
}
