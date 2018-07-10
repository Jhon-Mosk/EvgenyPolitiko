package ru.geekbrains.Dz.Dz1.Marathon1;

public class Human implements Competitor {

    String name;

    int maxRunDistance;
    int maxSwimDistance;
    int maxJumpHeight;
    int count;

    boolean active;



    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxSwimDistance = 300;
        this.maxJumpHeight = 2000;
        this.active =true;
        this.count=0;
    }

    @Override
    public void run(int dist) {
        if (dist <= maxRunDistance){
//            System.out.println(name + " добежал");
            count++;
        } else {
//            System.out.println(name + " не добежал");
            active = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (dist <= maxSwimDistance){
//            System.out.println(name + " доплыл");
            count++;
        } else {
//            System.out.println(name + " не доплыл");
            active = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxJumpHeight){
//            System.out.println(name + " перепрыгнул");
            count++;
        } else {
//            System.out.println(name + " не допрыгнул");
            active = false;
        }
    }

    @Override
    public void info() {
        System.out.println(name + " на дистанции: " + active);
    }

    @Override
    public void infoAbout(){
        System.out.println("Человек " + name);
    }

    @Override
    public void winner(){
        if(count==3){
            System.out.println("Победил: " + name);
        }
    }

    @Override
    public boolean isOnDistance() {
        return active;
    }
}

