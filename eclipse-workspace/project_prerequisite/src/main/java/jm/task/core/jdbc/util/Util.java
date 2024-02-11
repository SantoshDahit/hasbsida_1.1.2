package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // set up a database connection
    private static final String user = "root";
    private static final String pas = "1234";
    private static final String url = "jdbc:mysql://localhost:3306/santosh";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(url, user, pas);
    }
}
