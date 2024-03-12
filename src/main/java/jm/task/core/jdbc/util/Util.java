package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {

    private static final String user = "root";
    private static final String pas = "1234";
    private static final String url = "jdbc:mysql://localhost:3308/santosh";

    private Util() {

        throw new UnsupportedOperationException("Util class cannot be instantiated");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, pas);
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration();

        configuration.setProperty("hibernate.connection.url", url);
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.connection.username", user);
        configuration.setProperty("hibernate.connection.password", pas);
        configuration.setProperty("hibernate.connection.pool_size", "1");
        configuration.setProperty("hibernate.connection.autocommit", "false");
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        configuration.setProperty("show_sql", "true");

        return configuration.addAnnotatedClass(User.class).buildSessionFactory();
    }
}
