package ru.st;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShellInvoker {
    private final Map<String, Command> commands = new HashMap<>();

    public void registerCommand(Class<? extends Command> clazz) {
        if (!clazz.isAnnotationPresent(CommandInfo.class)) {
            System.err.println("Пропущен класс без @CommandInfo: " + clazz.getSimpleName());
            return;
        }

        try {
            Command cmd = instantiateCommand(clazz);
            CommandInfo info = clazz.getAnnotation(CommandInfo.class);
            commands.put(info.name(), cmd);
        } catch (Exception e) {
            System.err.println("Ошибка при регистрации команды " + clazz.getSimpleName() + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    private Command instantiateCommand(Class<? extends Command> clazz) throws Exception {
        // 1. Пробуем конструктор с ShellInvoker
        try {
            return clazz.getDeclaredConstructor(ShellInvoker.class).newInstance(this);
        } catch (NoSuchMethodException ignored) {}

        // 2. Пробуем конструктор без параметров
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException ignored) {}

        throw new RuntimeException("Нет подходящего конструктора для " + clazz.getSimpleName() +
                ". Доступные варианты:\n" +
                "1. " + clazz.getSimpleName() + "(ShellInvoker)\n" +
                "2. " + clazz.getSimpleName() + "()");
    }

    public void executeCommand(String input) {
        if (input == null || input.isBlank()) {
            return;
        }

        String[] parts = input.trim().split("\\s+", 2);
        String commandName = parts[0];
        String[] args = parts.length > 1 ? parseArguments(parts[1]) : new String[0];

        Command command = commands.get(commandName);
        if (command == null) {
            System.err.printf("Ошибка: неизвестная команда '%s'\n", commandName);
            return;
        }

        try {
            command.execute(args);
        } catch (CommandExecutionException e) {
            System.err.println("Ошибка выполнения команды '" + e.getCommandName() + "': " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка при выполнении команды: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String[] parseArguments(String argsString) {
        return argsString.split("\\s+");
    }

    public void printHelp() {
        System.out.println("Доступные команды:");
        commands.forEach((name, cmd) -> {
            CommandInfo info = cmd.getClass().getAnnotation(CommandInfo.class);
            System.out.printf("%-10s - %s%n", name, info.Description());
        });
    }
}