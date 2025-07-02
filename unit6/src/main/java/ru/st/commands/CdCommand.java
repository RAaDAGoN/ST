package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;
import ru.st.CommandReceiver;

@CommandInfo(name = "cd", Description = "Смена текущей рабочей директории")
public class CdCommand implements Command {
    private CommandReceiver receiver;

    public CdCommand(CommandReceiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        if (args.length == 0) {
            throw new CommandExecutionException("cd", "Не указан путь", null);
        }
        receiver.cd(args[0]);
    }
}
