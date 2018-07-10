package ru.geekbrains.Dz.Dz2.Enum;

public class mainClass {
    public static void main(String[] args) {
        getWorkingHours(DayOfWeek.MONDAY);
        System.out.println();

    }

    private static void getWorkingHours(DayOfWeek day) {
        int indexOfDay = 0;
        int size = 0;
        int toRest = 0;
        for (DayOfWeek o : DayOfWeek.values()) {
            size++;
            if (day == o) {
//                System.out.println(o.ordinal());
//                System.out.println(o);
                indexOfDay = o.ordinal();

            }

        }
//        System.out.println(size);

        DayOfWeek[] week = DayOfWeek.values();


        for (int i = indexOfDay; i < week.length; i++) {
            toRest += week[i].getHour();
        }
        System.out.println(toRest);

    }
}

