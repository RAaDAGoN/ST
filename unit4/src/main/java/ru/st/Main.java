package ru.st;

import ru.st.commands.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CommandReceiver receiver = new CommandReceiver(); // receiver

        ShellInvoker invoker = new ShellInvoker();

        invoker.registerCommand(new DateCommand(receiver));
        invoker.registerCommand(new TimeCommand(receiver));
        invoker.registerCommand(new PwdCommand(receiver));
        invoker.registerCommand(new ExitCommand(receiver));
        invoker.registerCommand(new HelpCommand(invoker));

        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            invoker.executeCommand(input);
        }
    }
}