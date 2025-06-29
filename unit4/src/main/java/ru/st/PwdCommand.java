package ru.st;

public class PwdCommand implements Command{
    private CommandReceiver commandReceiver;

    public PwdCommand(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    public void execute() {
        commandReceiver.pwd();
    }
}
