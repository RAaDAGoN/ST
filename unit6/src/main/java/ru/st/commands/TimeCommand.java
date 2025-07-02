package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name="time", Description = "выводит текущее время")
public class TimeCommand implements Command {
    private CommandReceiver commandReceiver;

    public TimeCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        commandReceiver.time();
    }
}
