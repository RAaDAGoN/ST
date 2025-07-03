package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name = "show", description = "данная команда показывает все текущие задачи")
public class ShowCommand implements Command {
    private CommandReceiver receiver;

    public ShowCommand(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        receiver.show();
    }
}
