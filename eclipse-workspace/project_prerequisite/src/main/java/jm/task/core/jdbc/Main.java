package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        // implement algorithm here
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Santosh", "Dahit", (byte) 25);
        userService.saveUser("Kiran", "Ghale", (byte) 28);
        userService.saveUser("Mahendra", "Adhikari", (byte) 29);
        userService.saveUser("Sapana", "Dahit", (byte) 24);
        userService.saveUser("Gyanu", "Thapa", (byte) 30);
        userService.getAllUsers().stream().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
