package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("model1", 1)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("model2", 2)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("model3", 3)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("model4", 4)));


      User carUser = userService.getCarUser("model1", 1);
      if(carUser != null) {
         System.out.println("Car's owner is :");
         System.out.println("Id = "+carUser.getId());
         System.out.println("First Name = "+carUser.getFirstName());
         System.out.println("Last Name = "+carUser.getLastName());
         System.out.println("Email = "+carUser.getEmail());
      }

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
         if(user.getCar() != null) {
            System.out.println("Car with model of: " + user.getCar().getModel() + ", and series of: " + user.getCar().getSeries());

         }
         System.out.println();
      }

      context.close();
   }
}
