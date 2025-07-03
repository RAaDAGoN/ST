package ru.st.commands;

import ru.st.Command;
import ru.st.CommandExecutionException;
import ru.st.CommandInfo;
import ru.st.ShellInvoker;

@CommandInfo(name = "help", description = "список всех доступных команд")
public class helpCommand implements Command {
    private final ShellInvoker invoker;

    public helpCommand(ShellInvoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void execute(String[] args) throws CommandExecutionException {
        invoker.printHelp();
    }
}
