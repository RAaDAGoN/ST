package ru.st;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CommandReceiver receiver = new CommandReceiver(); // receiver

        List<CommandEntry> commands = new ArrayList<>();
        commands.add(new CommandEntry("date", new DateCommand(receiver)));
        commands.add(new CommandEntry("time", new TimeCommand(receiver)));
        commands.add(new CommandEntry("pwd", new PwdCommand(receiver)));
        commands.add(new CommandEntry("exit", new ExitCommand(receiver)));
        commands.add(new CommandEntry("help", new HelpCommand(receiver)));

        ShellInvoker invoker = new ShellInvoker(commands);
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            invoker.executeCommand(input);
        }
    }
}