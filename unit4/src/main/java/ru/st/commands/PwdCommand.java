package ru.st.commands;

import ru.st.Command;
import ru.st.CommandReceiver;

public class PwdCommand implements Command {
    private CommandReceiver commandReceiver;

    public PwdCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.pwd();
    }

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public String getDescription() {
        return "выводит текущий рабочий каталог";
    }
}
