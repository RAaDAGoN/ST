package ru.st;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShellInvoker {
//    private Command date;
//    private Command time;
//    private Command pwd;
//    private Command help;
//
//    public ShellInvoker(Command date, Command time, Command pwd, Command help) {
//        this.date = date;
//        this.time = time;
//        this.pwd = pwd;
//        this.help = help;
//    }
//
//    public void dateNow(){
//        date.execute();
//    }
//
//    public void timeNow(){
//        time.execute();
//    }
//
//    public void currentPwd(){
//        pwd.execute();
//    }
//
//    public void help(){
//        help.execute();
//    }
    private final List<CommandEntry> commands;

    public ShellInvoker(List<CommandEntry> commands) {
        this.commands = commands;
    }

    public void executeCommand(String commandName){
        for (CommandEntry x : commands){
            if (x.getName().equals(commandName)){
                x.getCommand().execute();
                return;
            }
        }
        System.out.printf("Ошибка: неизвестная команда '%s'\n", commandName);
    }
}
