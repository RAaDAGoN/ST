package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name = "ls", Description = "вывод содержимого текущей директории")
public class LsCommand implements Command {
    CommandReceiver receiver;

    public LsCommand(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        receiver.ls();
    }
}
