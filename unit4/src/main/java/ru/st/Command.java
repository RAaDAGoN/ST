package ru.st;

public interface Command {
    void execute();
    String getName();
    String getDescription();
}
