/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import sqlite.tutorial.dao.UserDao;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        DatabaseConnectionHolder.connect();
        
        User newUser = new User(UUID.randomUUID().toString(), "abc", "abc", new BigDecimal(22));

        UserDao.instance.addUser(newUser);
        List<User> users = UserDao.instance.getAllUsers();

        for (User user : users) {
            System.out.println(
                    user.getUsername() + "," +
                    user.getPassword() + "," +
                    user.getName() + "," +
                    user.getAge()
            );
        }
        
        User user = UserDao.instance.getUserByUsername("marko");
        System.out.println(
                user.getUsername() + "," +
                user.getPassword() + "," +
                user.getName() + "," +
                user.getAge()
        );

    }

}
