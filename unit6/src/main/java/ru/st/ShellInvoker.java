package ru.st;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ShellInvoker {
    private Map<String, Command> commands = new HashMap<>();
    private final CommandReceiver receiver = new CommandReceiver(); // нужен для 'help'

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
            System.err.println("Ошибка при регистрации команды: " + clazz.getSimpleName());
            e.printStackTrace();
        }
    }

    private Command instantiateCommand(Class<? extends Command> clazz) throws Exception {
        try {
            return clazz.getDeclaredConstructor(ShellInvoker.class).newInstance(this);
        } catch (NoSuchMethodException ignored) {}

        try {
            return clazz.getDeclaredConstructor(CommandReceiver.class).newInstance(receiver);
        } catch (NoSuchMethodException ignored) {}

        throw new RuntimeException("Нет подходящего конструктора для " + clazz.getSimpleName());
    }

    public void executeCommand(String name){
        if (name.isBlank()) return;

        String[] parts = name.trim().split("\\s+");
        String names = parts[0];
        String[] args = Arrays.copyOfRange(parts, 1, parts.length);

        Command command = commands.get(names);
        if (command == null){
            System.out.printf("Ошибка: неизвестная команда '%s'", names);
            return;
        }

        try {
            command.execute(args);

        } catch (Exception e){
            System.out.println("ss");
        }

    }

    // for HelpCommand
    public void printHelp(){
        for (var entry : commands.values()) {
            CommandInfo info = entry.getClass().getAnnotation(CommandInfo.class);
            System.out.printf("%s - %s\n", info.name(), info.Description());
        }
    }
}
