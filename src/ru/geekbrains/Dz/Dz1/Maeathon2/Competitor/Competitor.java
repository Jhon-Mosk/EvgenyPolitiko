package ru.geekbrains.Dz.Dz1.Maeathon2.Competitor;

public interface Competitor {
    void run(int dist);
    void swim(int dist);
    void jump(int height);
    void info();
    boolean isOnDistance();
}