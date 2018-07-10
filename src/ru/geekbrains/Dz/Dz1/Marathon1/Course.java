package ru.geekbrains.Dz.Dz1.Marathon1;

public abstract class Course {



    public abstract void doIt(Competitor competitor);
}


class Wall extends Course{

    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.jump(height);
    }
}

class Cross extends Course{

    int leght;

    public Cross(int leght) {
        this.leght = leght;
    }


    @Override
    public void doIt(Competitor competitor) {
        competitor.run(leght);
    }
}

class Water extends Course{

    int lenght;

    public Water(int lenght) {
        this.lenght = lenght;
    }


    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(lenght);
    }
}