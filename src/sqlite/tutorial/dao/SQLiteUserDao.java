/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import sqlite.tutorial.dao.util.SQLiteDaoUtil;
import sqlite.tutorial.dao.util.UserMapper;
import sqlite.tutorial.exception.DataAccessException;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public class SQLiteUserDao implements UserDao {

    private static final String GET_ALL_USERS = "SELECT * FROM USER";
    private static final String GET_USER_BY_USERNAME = "SELECT * FROM USER WHERE USERNAME = ?";
    private static final String INSERT_USER = "INSERT INTO USER (USERNAME,PASSWORD,NAME,AGE) VALUES (?,?,?,?)";

    @Override
    public List<User> getAllUsers() throws DataAccessException {

        try {
            ResultSet rs = SQLiteDaoUtil
                    .createPreparedStatement(GET_ALL_USERS)
                    .executeQuery();

            List<User> users = new LinkedList<>();
            while (rs.next())
                users.add(UserMapper.map(rs));
            return users;
            
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }

    }

    @Override
    public User getUserByUsername(String username) throws DataAccessException {
        try {
            PreparedStatement ps = SQLiteDaoUtil.createPreparedStatement(GET_USER_BY_USERNAME);

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next())
                return UserMapper.map(rs);
            else
                return null;
            
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }

    }

    @Override
    public void addUser(User user) throws DataAccessException {
        try {
            PreparedStatement ps = SQLiteDaoUtil.createPreparedStatement(INSERT_USER);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setBigDecimal(4, user.getAge());

            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DataAccessException(ex);
        }
    }

}
