package ru.st;

public class HelpCommand implements Command{
    private CommandReceiver commandReceiver;

    public HelpCommand(CommandReceiver command) {
        this.commandReceiver = command;
    }

    @Override
    public void execute() {
        commandReceiver.help();
    }
}
