package ru.st.commands;

import ru.st.*;

@CommandInfo(name = "add", description = "добавляет новую задачу")
public class AddCommand implements Command {
    @Override
    public void execute(String[] args) throws CommandExecutionException {
        Database.initialize();
        try (var stmt = Database.getConnection().prepareStatement(
                "INSERT INTO task (name, status) VALUES (?, ?)"
        )) {
            stmt.setString(1, args[0]);
            stmt.setBoolean(2, true);
            stmt.execute();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
