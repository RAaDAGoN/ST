package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name="pwd", Description = "выводит текущий рабочий каталог")
public class PwdCommand implements Command {
    private CommandReceiver commandReceiver;

    public PwdCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute(String[] args) {
        commandReceiver.pwd();
    }
}
