package ru.st;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

// receiver
public class CommandReceiver {
    public void date(){
        System.out.println(LocalDate.now());
    }

    public void time(){
        Date current = new Date();
        System.out.printf("%s:%s:%s\n", current.getHours(), current.getMinutes(), current.getSeconds());
    }

    public void pwd(){
        System.out.println(System.getProperty("user.dir"));
    }
    public void exit(){
        System.exit(0);
    }
}
