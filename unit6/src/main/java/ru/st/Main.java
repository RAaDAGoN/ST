package ru.st;

import ru.st.commands.*;

import java.util.Scanner;

/**
 для дальнейшей регистрации новой команды необходимо:
 1)добавить команду в пакет commands
 2)добавить реализацию команды в CommandReceiver
 3)в main зарегестрировать новую команду

 ***/

public class Main {
    public static void main(String[] args) {
        ShellInvoker invoker = new ShellInvoker();

        invoker.registerCommand(ru.st.commands.DateCommand.class);
        invoker.registerCommand(ru.st.commands.TimeCommand.class);
        invoker.registerCommand(ru.st.commands.PwdCommand.class);
        invoker.registerCommand(ru.st.commands.CdCommand.class);
        invoker.registerCommand(ru.st.commands.LsCommand.class);
        invoker.registerCommand(ru.st.commands.ExitCommand.class);
        invoker.registerCommand(ru.st.commands.HelpCommand.class);

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            invoker.executeCommand(input);
        }
    }
}