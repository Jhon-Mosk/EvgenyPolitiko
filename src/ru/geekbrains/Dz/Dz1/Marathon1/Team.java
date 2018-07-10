package ru.geekbrains.Dz.Dz1.Marathon1;

public class Team {

        String nameOfTeam;
        Competitor [] competitors=new Competitor[]{new Human("Василий"), new Cat("Мурзик"), new Dog("Шарик"),
            new Human("Пётр")};
    Course [] obstacle = {new Cross(4000), new Wall(5), new Water(300)};


    public Team(String nameOfTeam) {
        this.nameOfTeam = nameOfTeam;
    }

    public void infoAboutTeam(){
            System.out.println("Название команды " + nameOfTeam);
            System.out.println("Состав:");
            for(Competitor c : competitors){

                c.infoAbout();
            }
            System.out.println();
        }

    public void infoAboutWins(){

        for(Competitor c : competitors){
            for(Course o : obstacle){
                o.doIt(c);

                if(!c.isOnDistance()) break;
                c.winner();
            }

        }


    }



}
