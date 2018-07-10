package img;

//�� ���� 7

class Plate {
private int food;
protected int hunger;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int added) {
        food += added;
        System.out.println(added + " sussessfully added into plate");
    }

    public void consumeFood(int consumed) {
        food -= consumed;
        hunger = food < 0 ? Math.abs(food) : 0;
        food = food < 0 ? 0 : food;
    }

    public void infoShow() {
        System.out.println(food + " food in the plate now.");
    }
}

 class Cats {
    private String name;
    private int volume;
    private boolean enoughDemand;

    public Cats(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public void dinner(Plate x) {
        do {
            x.consumeFood(volume);
            volume = x.hunger > 0 ? x.hunger : 0;
            enoughDemand = volume == 0;
            if (enoughDemand) {
                System.out.println(name + " ate and is full!");



            } else {
                System.out.println(name + " ate but its not enough. Should feed more - " + volume);

                x.infoShow();
                x.addFood(10);
//                x.consumeFood(volume);
//
//                if (enoughDemand) {System.out.println(name + " ate and is full!");}
//                else {System.out.println(name + " ate but its not enough. Should feed more - " + volume);}

            }

        }
         while (enoughDemand != true);
    }
}

class Main {
    public static void main(String[] args) {
        Cats[] arrCat = {new Cats("Pushok", 15),
        new Cats("Bassia", 20)};

        Plate plate = new Plate(0);

        plate.infoShow();

        for (int i = 0; i < arrCat.length; i++) {
            arrCat[i].dinner(plate);
            plate.infoShow();
        }


        }
    }


