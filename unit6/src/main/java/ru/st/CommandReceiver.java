package ru.st;

import java.io.File;
import java.time.LocalDate;
import java.util.Date;

// receiver
public class CommandReceiver {
    private String currentDirectory = System.getProperty("user.dir");

    public void date(){
        System.out.println(LocalDate.now());
    }

    public void time(){
        Date current = new Date();
        System.out.printf("%s:%s:%s\n", current.getHours(), current.getMinutes(), current.getSeconds());
    }

    public void cd(String path) throws CommandExecutionException{
        File newDir = new File(path);
        if (newDir.exists() && newDir.isDirectory()){
            currentDirectory = newDir.getAbsolutePath();
        } else {
            throw new CommandExecutionException("cd", "Директория не найдена: " + path, null);
        }
    }

    public void ls(){
        File dir = new File(currentDirectory);

        File[] files = dir.listFiles();

        if (files != null){
            for (File f : files){
                System.out.println(f.getName());
            }
        } else {
            System.out.println("Ошибка чтения директории");
        }
    }

    public void pwd(){
        System.out.println(currentDirectory);
    }
    public void exit(){
        System.exit(0);
    }


}
