package ru.geekbrains.Lessons.Lesson1.Obstacle;

import ru.geekbrains.Lessons.Lesson1.Competitor.Competitor;

public class Wall extends Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}