package ru.st.commands;

import ru.st.Command;
import ru.st.CommandReceiver;

public class DateCommand implements Command {
    private CommandReceiver commandReceiver;

    public DateCommand(CommandReceiver command) {
        this.commandReceiver = command;
    }

    @Override
    public void execute() {
        commandReceiver.date();
    }

    @Override
    public String getName() {
        return "date";
    }

    @Override
    public String getDescription() {
        return "выводит текущую дату";
    }
}
