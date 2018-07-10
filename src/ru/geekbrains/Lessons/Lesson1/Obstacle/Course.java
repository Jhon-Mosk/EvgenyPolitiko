package ru.geekbrains.Lessons.Lesson1.Obstacle;

import ru.geekbrains.Lessons.Lesson1.Competitor.Competitor;
import ru.geekbrains.Lessons.Lesson1.Competitor.Team;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        for (Competitor c : team.getMembers()) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}