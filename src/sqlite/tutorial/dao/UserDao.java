/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.dao;

import java.util.List;
import sqlite.tutorial.exception.DataAccessException;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public interface UserDao {
    
    public static final UserDao instance = new SQLiteUserDao();
    
    public List<User> getAllUsers() throws DataAccessException;
    
    public User getUserByUsername(String username) throws DataAccessException;
    
    public void addUser(User user) throws DataAccessException;
    
}
