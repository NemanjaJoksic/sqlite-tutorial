/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.service;

import sqlite.tutorial.dao.UserDao;
import sqlite.tutorial.exception.DataAccessException;
import sqlite.tutorial.exception.InvalidPasswordException;
import sqlite.tutorial.exception.UserAlreadyExists;
import sqlite.tutorial.exception.UserNotExist;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public class UserServiceImpl implements UserService {

    @Override
    public User login(String username, String password) throws DataAccessException,
            UserNotExist, InvalidPasswordException {
        
        User user = UserDao.instance.getUserByUsername(username);
        
        if (user == null)
            throw new UserNotExist(username);
        
        if (!user.getPassword().equals(password))
            throw new InvalidPasswordException();
        
        return user;
    }

    @Override
    public void register(User user) throws DataAccessException, UserAlreadyExists {
        
        if (UserDao.instance.getUserByUsername(user.getUsername()) != null)
            throw new UserAlreadyExists(user.getUsername());
        
        UserDao.instance.addUser(user);
    }
    
}
