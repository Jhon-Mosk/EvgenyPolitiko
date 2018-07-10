package ru.geekbrains.Lessons.Lesson1;

import ru.geekbrains.Lessons.Lesson1.Competitor.Cat;
import ru.geekbrains.Lessons.Lesson1.Competitor.Dog;
import ru.geekbrains.Lessons.Lesson1.Competitor.Human;
import ru.geekbrains.Lessons.Lesson1.Competitor.Team;
import ru.geekbrains.Lessons.Lesson1.Obstacle.Course;
import ru.geekbrains.Lessons.Lesson1.Obstacle.Cross;
import ru.geekbrains.Lessons.Lesson1.Obstacle.Wall;

public class Main {
    public static void main(String[] args) {

        Team team = new Team("Rocket", new Human("Bob"), new Cat("Vaska"), new Dog("Bobik"));
        Course course = new Course(new Cross(80), new Wall(2), new Wall(1), new Cross(120));
        course.doIt(team);
        team.showWinners();

    }
}

