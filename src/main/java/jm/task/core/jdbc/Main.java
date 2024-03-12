package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Santosh", "Dahit", (byte) 25);
        userService.saveUser("Kiran", "Ghale", (byte) 28);
        userService.saveUser("Mahendra", "Adhikari", (byte) 29);
        userService.saveUser("Sapana", "Dahit", (byte) 24);
        userService.saveUser("Gyanu", "Thapa", (byte) 30);

        List<User> users = userService.getAllUsers();
        for (User user : users) {
            System.out.println(user);
        }

        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
