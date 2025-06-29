package ru.st;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

// receiver
public class CommandReceiver {
    void date(){
        System.out.println(LocalDate.now());
    }

    void time(){
        Date current = new Date();
        System.out.printf("%s:%s:%s\n", current.getHours(), current.getMinutes(), current.getSeconds());
    }

    void pwd(){
        System.out.println(System.getProperty("user.dir"));
    }
    void exit(){
        System.exit(0);
    }

    void help(){
        System.out.println("date - выводит текущую дату \n" +
                "time - выводит текущее время \n" +
                "pwd - выводит текущий рабочий каталог \n" +
                "exit - завершает работу приложения \n" +
                "help - выводит список доступных команд");
    }
}
