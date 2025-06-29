package ru.st;

public class TimeCommand implements Command {
    private CommandReceiver commandReceiver;

    public TimeCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.time();
    }
}
