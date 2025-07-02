package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name="exit", Description = "завершает работу приложения")
public class ExitCommand implements Command {
    private CommandReceiver commandReceiver;

    public ExitCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        commandReceiver.exit();
    }
}
