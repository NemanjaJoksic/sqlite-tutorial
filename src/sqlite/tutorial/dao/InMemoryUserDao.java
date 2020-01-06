/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.dao;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import sqlite.tutorial.exception.DataAccessException;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public class InMemoryUserDao implements UserDao {

    private Map<String, User> users = new HashMap<>();
    
    @Override
    public List<User> getAllUsers() throws DataAccessException {
       return new LinkedList<>(users.values());
    }

    @Override
    public User getUserByUsername(String username) throws DataAccessException {
        return users.get(username);
    }

    @Override
    public void addUser(User user) throws DataAccessException {
        users.put(user.getUsername(), user);
    }
    
}
