package ru.geekbrains.Lessons.Lesson2;

public enum Fruit {
    ORANGE("Апельсин", 10), APPLE("Яблоко", 5), BANANA("Банан", 3), CHERRY("Вишня", 1);

    private String rus;
    private int weight;

    Fruit(String rus, int weight) {
        this.rus = rus;
        this.weight = weight;
    }

    public String getRus() {
        return rus;
    }

    public int getWeight() {
        return weight;
    }

}

class MainEnum {


    public static void main(String[] args) {
        Fruit fruit = Fruit.APPLE;

        for (Fruit o: Fruit.values()) {
            System.out.println(o.getRus() + " " + o.getWeight());
        }

//        if( fruit == Fruit.APPLE) {
//            System.out.println("Это яблоко!");
//        }

//        for(Fruit o: Fruit.values()) {
//            System.out.println(o);
//        }

      //  System.out.println(Fruit.valueOf("BANANA"));

      //  System.out.println(Fruit.BANANA.ordinal());
    }
}
