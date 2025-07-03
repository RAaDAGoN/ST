package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;

import java.io.File;

@CommandInfo(name = "ls", Description = "вывод содержимого текущей директории")
public class LsCommand implements Command {
    @Override
    public void execute(String[] args) throws CommandExecutionException {
        File dir = new File(System.getProperty("user.dir"));

        File[] files = dir.listFiles();

        if (files != null){
            for (File f : files){
                System.out.println(f.getName());
            }
        } else {
            System.out.println("Ошибка чтения директории");
        }
    }
}
