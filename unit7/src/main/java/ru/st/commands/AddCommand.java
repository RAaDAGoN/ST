package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name = "add", description = "добавляет новую задачу")
public class AddCommand implements Command {
    private CommandReceiver receiver;

    public AddCommand(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        receiver.add(args[0]);
    }
}
