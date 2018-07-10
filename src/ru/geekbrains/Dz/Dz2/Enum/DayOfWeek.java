package ru.geekbrains.Dz.Dz2.Enum;

public enum DayOfWeek {
    MONDAY(8), TUESDAY(8), WEDNESDAY(8), THURSDAY(8), FRIDAY(8), SATURDAY(7), SUNDAY(0);

private int hour;

    DayOfWeek(int hour) {
        this.hour = hour;
    }

    public int getHour() {
        return hour;
    }
}
