package ru.st;

public class CommandExecutionException extends Exception{
    private final String commandName;

    public CommandExecutionException(String commandName, String message, Throwable cause) {
        super(message, cause);
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
