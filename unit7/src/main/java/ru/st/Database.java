package ru.st;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:h2:file:./todo";
    private static final String INIT_TABLE = """
            CREATE TABLE IF NOT EXISTS task (
            id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255) NOT NULL,
            status BOOLEAN DEFAULT FALSE)
            """;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        try (Connection conn = getConnection()){
            conn.createStatement().execute(INIT_TABLE);
        } catch (SQLException e){
            System.out.println("Ошибка иниициализации БД: " + e.getMessage());
        }
    }
}
