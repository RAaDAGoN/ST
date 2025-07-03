package ru.st;

public interface Command {
    void execute(String[] args) throws CommandExecutionException;
}
