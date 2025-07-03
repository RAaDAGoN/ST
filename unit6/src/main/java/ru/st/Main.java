package ru.st;

import ru.st.commands.*;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 для дальнейшей регистрации новой команды необходимо:
 1)добавить команду в пакет commands
 2)добавить реализацию команды в CommandReceiver
 3)в main зарегестрировать новую команду

 ***/

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

            Scanner scanner = new Scanner(System.in);

            while (true){
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                invoker.executeCommand(input);
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