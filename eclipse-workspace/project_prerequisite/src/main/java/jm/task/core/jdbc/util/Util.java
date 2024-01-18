package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // set up a database connection
    public static Connection getConnection() throws SQLException {
        String user = "root";
        String pas = "1234";
        String url = "jdbc:mysql://localhost:3306/santosh";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }
        return DriverManager.getConnection(url, user, pas);
    }
}
