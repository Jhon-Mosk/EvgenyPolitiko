package ru.geekbrains.Dz.Dz7;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class test {


    public static void main(String[] args) {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("dfsdfsdf");
                timer.cancel();
            }
        }, 5000 );

    }
}
