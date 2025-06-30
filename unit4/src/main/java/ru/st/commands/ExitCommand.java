package ru.st.commands;

import ru.st.Command;
import ru.st.CommandReceiver;

public class ExitCommand implements Command {
    private CommandReceiver commandReceiver;

    public ExitCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.exit();
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "завершает работу приложения";
    }
}
