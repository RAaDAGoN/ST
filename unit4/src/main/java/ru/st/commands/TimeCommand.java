package ru.st.commands;

import ru.st.Command;
import ru.st.CommandReceiver;

public class TimeCommand implements Command {
    private CommandReceiver commandReceiver;

    public TimeCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.time();
    }

    @Override
    public String getName() {
        return "time";
    }

    @Override
    public String getDescription() {
        return "выводит текущее время";
    }
}
