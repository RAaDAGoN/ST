package ru.st.commands;

import ru.st.*;

@CommandInfo(name = "done", description = "команда обновляет статус на завершенный в задаче")
public class DoneCommand implements Command {
    @Override
    public void execute(String[] args) throws CommandExecutionException {
        String sql = "UPDATE task SET status = FALSE WHERE id = ?";

        try (var stmt = Database.getConnection().prepareStatement(sql);
        ){
            stmt.setInt(1, Integer.parseInt(args[0]));
            stmt.executeUpdate();
        } catch (Exception e){
            System.out.println("ошибка обновления данных: " + e.getMessage());
        }
    }
}
