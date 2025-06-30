package ru.st.commands;

import ru.st.Command;
import ru.st.CommandReceiver;
import ru.st.ShellInvoker;

public class HelpCommand implements Command {
    private final ShellInvoker invoker;

    public HelpCommand(ShellInvoker invoker) {
        this.invoker = invoker;
    }

    @Override
    public void execute() {
        for (Command command : invoker.getAllCommands()){
            System.out.printf("%s - %s \n", command.getName(), command.getDescription());
        }
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "выводит список доступных комманд с их описанием";
    }
}
