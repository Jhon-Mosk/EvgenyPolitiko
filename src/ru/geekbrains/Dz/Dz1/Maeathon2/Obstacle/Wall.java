package ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle;

import ru.geekbrains.Dz.Dz1.Maeathon2.Competitor.Competitor;

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