package ru.st;

import ru.st.commands.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShellInvoker {
    private Map<String, Command> commands = new HashMap<>();

    public void registerCommand(Command command){
        commands.put(command.getName(), command);
    }

    public void executeCommand(String name){
        Command command = commands.get(name);
        if (command != null){
            command.execute();
        } else System.out.printf("Ошибка: неизвестная команда '%s'", name);
    }

    // for HelpCommand
    public Iterable<Command> getAllCommands(){
        return commands.values();
    }
}
