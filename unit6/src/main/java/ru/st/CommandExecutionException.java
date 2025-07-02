package ru.st;

public class CommandExecutionException extends Exception{
    private final String commandName;

    public CommandExecutionException(String message, String commandName, Throwable cause) {
        super(message, cause);
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
