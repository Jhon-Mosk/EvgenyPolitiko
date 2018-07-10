package ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle;

import ru.geekbrains.Dz.Dz1.Maeathon2.Competitor.Team;
import ru.geekbrains.Dz.Dz1.Maeathon2.Competitor.Competitor;


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