package ru.geekbrains.Dz.Dz1.Marathon1;

public interface Competitor {

    void  run(int dist);
    void  swim(int dist);
    void  jump(int height);
    void info();
    void infoAbout();
    void winner();
    boolean isOnDistance();
}

class Animal implements Competitor {

    String type;
    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;
    int count;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.onDistance=true;
        this.count=0;
    }

    @Override
    public void run(int dist) {
if (dist <= maxRunDistance){
//    System.out.println(type + " " + name + " пробежал");
    count++;
} else {
//    System.out.println(type + " " + name + " не добежал");
    onDistance = false;
}
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance){
//            System.out.println(type + " " + name + " проплыл");
            count++;
        } else {
//            System.out.println(type + " " + name + " не доплыл");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight){
//            System.out.println(type + " " + name + " перепрыгнул");
            count++;
        } else {
//            System.out.println(type + " " + name + " не допрыгнул");
            onDistance = false;
        }
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " на дистанции: " + onDistance);
    }

    @Override
    public void infoAbout(){
        System.out.println(type + " " + name);
    }

    @Override
    public void winner(){
        if(count==3){
            System.out.println("Победил: " + type + " "+ name);
        }
    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }
}

class Cat extends Animal {

    public Cat(String name) {
        super("Кот", name, 20, 5, 10);
    }

//    public Cat(String type, String name, int maxRunDistance, int maxSwimDistance, int maxJumpHeight) {
//        super(type, name, maxRunDistance, maxSwimDistance, maxJumpHeight);
//    }
}

class Dog extends Animal{

    public Dog(String name) {
        super("Пес", name, 500, 10, 5);
    }
}