package ru.st;

// необходим для ArrayList
public class CommandEntry {
    private final String name;
    private final Command command;

    public CommandEntry(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
