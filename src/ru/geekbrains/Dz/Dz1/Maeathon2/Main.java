package ru.geekbrains.Dz.Dz1.Maeathon2;

import ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle.Course;
import ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle.Cross;
import ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle.Wall;
import ru.geekbrains.Dz.Dz1.Maeathon2.Obstacle.Water;
import ru.geekbrains.Dz.Dz1.Maeathon2.Competitor.*;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Василий"), new Cat("Мурзик"), new Dog("Шарик"), new Human("Пётр")};

        Team team = new Team("Браво", new Human("Василий"), new Cat("Мурзик"), new Dog("Шарик"), new Human("Пётр"));
        Course course = new Course(new Cross(80), new Wall(2), new Water(1));

        course.doIt(team);
        team.showWinners();

    }
}




















//public class Team {
//    String name;
//
//    Competitor[] competitors;
//
//    public Team(String teamName, String humanName, String catName, String dogName, String twoHumanName) {
//        Competitor[] competitors = {new Human(humanName), new Human(twoHumanName), new Cat(catName), new Dog(dogName)};
//        this.competitors = competitors;
//        name = teamName;
//    }
//
//}
//
//
//
///////////////////////////
//
//
//
//public class Team {
//    String name;
//    Competitor[] comps = {new Human("Боб"), new Human ("Anna"), new Cat("Барсик"), new Dog("Бобик")};
//
//
//    public Team(String name) {
//        this.name = name;
//
//    }
//
//    public void showTeam(){
//        System.out.println("Команда "+this.getName());
//        for (int i = 0; i < this.comps.length; i++) {
//            System.out.println(this.comps[i].toString());
//        }
//        System.out.println("--------------------------------------------------------");
//
//    }
//
//    void showResults(){
//        System.out.println("-----------------");
//        System.out.println("Результаты марафона:");
//        for (Competitor c : this.comps) {
//            c.info();
//        }
//    }
//
//    public String getName() {
//        return name;
//    }
//}
//
//
//
////////////////////
//
//
//public class Team {
//
//    private String name;
//    private Competitor[] competitors = new Competitor[4];
//
//    public Team(String name) {
//        this.name = name;
//        competitors[0] = new Cat("Vaska");
//        competitors[1] = new Dog("Bobik");
//        competitors[2] = new Human("Alex");
//        competitors[3] = new Cat("Barsik");
//    }
//
//    public Competitor[] getCompetitors() {
//        return competitors;
//    }
//
//    public void show(){
//        System.out.println("Команда : " + name + "\nСостав :");
//        for (Competitor c : competitors)
//            System.out.println(c.getClass().getName() + " " + c.getName());
//    }
//
//    public void showResults(){
//        for (Competitor c : competitors) {
//            c.info();
//        }
//    }
//}
////////////////
//
//
//
//    public Team(Species typeOfTeammate1, String nameOfTeammate1,
//                Species typeOfTeammate2, String nameOfTeammate2,
//                Species typeOfTeammate3, String nameOfTeammate3,
//                Species typeOfTeammate4, String nameOfTeammate4)
//    {
//        teammates = new Competitor[4];
//        addTeammate(0,typeOfTeammate1, String nameOfTeammate1);
//        addTeammate(1,typeOfTeammate2, String nameOfTeammate2);
//        addTeammate(2,typeOfTeammate3, String nameOfTeammate3);
//        addTeammate(3,typeOfTeammate4, String nameOfTeammate4);
//    }
//
//
///////////////////