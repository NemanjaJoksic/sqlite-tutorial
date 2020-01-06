/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.service;

import sqlite.tutorial.exception.DataAccessException;
import sqlite.tutorial.exception.InvalidPasswordException;
import sqlite.tutorial.exception.UserAlreadyExists;
import sqlite.tutorial.exception.UserNotExist;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public interface UserService {
    
    public static final UserService instance = new UserServiceImpl();
    
    public User login(String username, String password) throws DataAccessException, 
            UserNotExist, InvalidPasswordException;
    
    public void register(User user) throws DataAccessException, UserAlreadyExists;
    
}
