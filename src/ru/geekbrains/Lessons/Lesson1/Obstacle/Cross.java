package ru.geekbrains.Lessons.Lesson1.Obstacle;

import ru.geekbrains.Lessons.Lesson1.Competitor.Competitor;

public class Cross extends Obstacle {

    int length;

    public Cross(int length) {
        this.length = length;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.run(length);
    }
}
