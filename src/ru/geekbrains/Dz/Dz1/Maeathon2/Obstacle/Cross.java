package ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle;

import ru.geekbrains.Dz.Dz1.Maeathon2.Competitor.Competitor;


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
