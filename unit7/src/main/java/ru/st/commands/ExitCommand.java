package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;

@CommandInfo(name = "exit", description = "завершает выполнение команды")
public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) throws CommandExecutionException {
        System.exit(0);
    }
}
