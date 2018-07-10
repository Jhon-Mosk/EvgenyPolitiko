package ru.geekbrains.Dz.Dz1.Marathon1;

//public abstract class Obstacle {
//    public abstract void doIt(Competitor competitor);
//}
//
//class Wall extends Obstacle{
//
//    int height;
//
//    public Wall(int height) {
//        this.height = height;
//    }
//
//    @Override
//    public void doIt(Competitor competitor) {
//competitor.jump(height);
//    }
//}
//
//class Cross extends Obstacle{
//
//    int leght;
//
//    public Cross(int leght) {
//        this.leght = leght;
//    }
//
//
//    @Override
//    public void doIt(Competitor competitor) {
//        competitor.run(leght);
//    }
//}
//
//class Water extends Obstacle{
//
//    int lenght;
//
//    public Water(int lenght) {
//        this.lenght = lenght;
//    }
//
//
//    @Override
//    public void doIt(Competitor competitor) {
//        competitor.swim(lenght);
//    }
//}

class MainClass {
    public static void main(String[] args) {
        Team team = new Team("Браво");
//        Course c = new Course();

        team.infoAboutTeam();
        team.infoAboutWins();






    }
}

