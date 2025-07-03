package ru.st;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShellInvoker invoker = new ShellInvoker();

        invoker.registerCommand(ru.st.commands.AddCommand.class);
        invoker.registerCommand(ru.st.commands.ShowCommand.class);
        invoker.registerCommand(ru.st.commands.DoneCommand.class);

        Scanner sc = new Scanner(System.in);

        while (true){
            System.out.print("> ");
            String command = sc.next();
            Object stringTask = sc.nextLine()
                    .replaceAll(command, "")
                    .replaceAll("\"", "")
                    .replaceAll("\'", "")
                    .trim();

            invoker.executeCommand(command, String.valueOf(stringTask));


        }
    }
}