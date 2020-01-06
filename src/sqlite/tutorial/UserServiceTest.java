/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial;

import sqlite.tutorial.dao.DatabaseConnectionHolder;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlite.tutorial.dao.UserDao;
import sqlite.tutorial.exception.DataAccessException;
import sqlite.tutorial.exception.InvalidPasswordException;
import sqlite.tutorial.exception.UserAlreadyExists;
import sqlite.tutorial.exception.UserNotExist;
import sqlite.tutorial.model.User;
import sqlite.tutorial.service.UserService;

/**
 *
 * @author Nemanja
 */
public class UserServiceTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        DatabaseConnectionHolder.connect();
        
        User newUser = new User(UUID.randomUUID().toString(), "abc", "abc", new BigDecimal(22));
        
        try {
            UserService.instance.login(newUser.getUsername(), newUser.getPassword());
        } catch (UserNotExist ex) {
            System.out.println(ex.getMessage());
        }
        
        UserService.instance.register(newUser);
        
        try {
            UserService.instance.register(newUser);
        } catch (UserAlreadyExists ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            UserService.instance.login(newUser.getUsername(), "123");
        } catch (InvalidPasswordException ex) {
            System.out.println(ex.getMessage());
        }
        
        User user = UserService.instance.login(newUser.getUsername(), newUser.getPassword());
  
        System.out.println(
                user.getUsername() + "," +
                user.getPassword() + "," +
                user.getName() + "," +
                user.getAge()
        );

    }

}
