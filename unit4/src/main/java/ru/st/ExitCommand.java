package ru.st;

public class ExitCommand implements Command {
    private CommandReceiver commandReceiver;

    public ExitCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.exit();
    }
}
