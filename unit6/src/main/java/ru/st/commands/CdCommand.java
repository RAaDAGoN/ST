package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;

import java.io.File;

@CommandInfo(name = "cd", Description = "Смена текущей рабочей директории")
public class CdCommand implements Command {
    private String currentDirectory = System.getProperty("user.dir");

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        if (args.length == 0) {
            throw new CommandExecutionException("cd", "Не указан путь", null);
        }
        File newDir = new File(args[0]);
        if (newDir.exists() && newDir.isDirectory()){
            currentDirectory = newDir.getAbsolutePath();
        } else {
            throw new CommandExecutionException("cd", "Директория не найдена: " + args[0], null);
        }
    }
}
