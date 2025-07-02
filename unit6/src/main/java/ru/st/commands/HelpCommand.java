package ru.st.commands;

import ru.st.Command;
import ru.st.CommandInfo;
import ru.st.ShellInvoker;

@CommandInfo(name="help", Description = "выводит список доступных комманд с их описанием")
public class HelpCommand implements Command {
    private final ShellInvoker invoker;

    public HelpCommand(ShellInvoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void execute(String[] args) {
        invoker.printHelp();
    }
}
