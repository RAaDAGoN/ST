package ru.st;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            ShellInvoker invoker = new ShellInvoker();

            String packageName = "ru.st.commands";
            String packagePath = packageName.replace('.', '/');
            File directory = new File(Objects.requireNonNull(
                    Main.class.getClassLoader().getResource(packagePath)).getFile());

            List<Class> commandClasses = findClasses(directory, packageName);
            for (Class clazz : commandClasses) {
                if (clazz.isAnnotationPresent(CommandInfo.class)) {
                    invoker.registerCommand(clazz);
                }
            }

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
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private static List<Class> findClasses(File directory, String packageName)
            throws ClassNotFoundException{
        List<Class> classes = new ArrayList<Class>();
        if (!directory.exists()){
            return classes;
        }

        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isDirectory()){
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else if (file.getName().endsWith(".class")) {
                classes.add(Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
            }
        }

        return classes;
    }
}