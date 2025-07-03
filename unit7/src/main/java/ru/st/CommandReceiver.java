package ru.st;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CommandReceiver {
    public void add(String task){
        Database.initialize();
        try (var stmt = Database.getConnection().prepareStatement(
                "INSERT INTO task (name, status) VALUES (?, ?)"
        )) {
            stmt.setString(1, task);
            stmt.setBoolean(2, true);
            stmt.execute();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void done(String id){
        String sql = "UPDATE task SET status = FALSE WHERE id = ?";

        try (var stmt = Database.getConnection().prepareStatement(sql);
            ){
            stmt.setInt(1, Integer.parseInt(id));
            stmt.executeUpdate();
        } catch (Exception e){
            System.out.println("ошибка обновления данных: " + e.getMessage());
        }
    }

    public void show(){
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
