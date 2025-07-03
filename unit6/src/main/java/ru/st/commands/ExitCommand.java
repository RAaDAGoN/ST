package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;

@CommandInfo(name="exit", Description = "завершает работу приложения")
public class ExitCommand implements Command {
    @Override
    public void execute(String[] args) {
        System.exit(0);
    }
}
