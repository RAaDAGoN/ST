package ru.st;

public class DateCommand implements Command{
    private CommandReceiver commandReceiver;

    public DateCommand(CommandReceiver command) {
        this.commandReceiver = command;
    }

    @Override
    public void execute() {
        commandReceiver.date();
    }
}
