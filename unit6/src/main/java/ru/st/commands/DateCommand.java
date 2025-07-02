package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name="date", Description = "выводит текущую дату")
public class DateCommand implements Command {
    private CommandReceiver commandReceiver;

    public DateCommand(CommandReceiver command) {
        this.commandReceiver = command;
    }

    @Override
    public void execute(String[] args) {
        commandReceiver.date();
    }

}
