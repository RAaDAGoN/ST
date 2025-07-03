package ru.st;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShellInvoker {
    private final Map<String, ru.st.Command> commands = new HashMap<>();
    private final CommandReceiver receiver = new CommandReceiver(); // for help

    public void registerCommand(Class<? extends ru.st.Command> clazz){
        if (!clazz.isAnnotationPresent(CommandInfo.class)){
            System.out.println("Пропущен класс без @CommandInfo: " + clazz.getSimpleName());
            return;
        }

        try {
            ru.st.Command cmd = instanceCommand(clazz);
            CommandInfo info = clazz.getAnnotation(CommandInfo.class);
            commands.put(info.name(), cmd);
        } catch (Exception e){
            System.out.println("Ошибка при регистрации команды: " + clazz.getSimpleName());
        }
    }

    private ru.st.Command instanceCommand(Class<? extends ru.st.Command> clazz) throws Exception{
        try {
            return clazz.getDeclaredConstructor(ShellInvoker.class).newInstance(this);
        } catch (NoSuchMethodException e){
            System.out.println(e.getMessage());
        }

        try {
            return clazz.getDeclaredConstructor(CommandReceiver.class).newInstance(receiver);
        } catch (NoSuchMethodException e){
            System.out.println(e.getMessage());
        }

        throw new RuntimeException("Нет подходящего конструктора для " + clazz.getSimpleName());
    }

    public void executeCommand(String... inputParts){
        if (inputParts == null) return;

        String commandName = inputParts[0];
        String[] args = Arrays.copyOfRange(inputParts, 1, commandName.length());

        Command command = commands.get(commandName);
        if (command == null){
            System.out.println("Неизвестная команда");
            return;
        }

        try {
            command.execute(args);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void printHelp(){

    }
}
