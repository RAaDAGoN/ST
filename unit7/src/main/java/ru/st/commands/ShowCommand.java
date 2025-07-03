package ru.st.commands;

import ru.st.*;

import java.sql.ResultSet;

@CommandInfo(name = "show", description = "данная команда показывает все текущие задачи")
public class ShowCommand implements Command {
    @Override
    public void execute(String[] args) throws CommandExecutionException {
        String sql = "SELECT * FROM task";

        try (var stmt = Database.getConnection().createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)){
            System.out.println("Список задач");
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String task = resultSet.getString("name");
                boolean status = resultSet.getBoolean("status");
                System.out.printf("%s %s %s\n", id, task, status);
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
