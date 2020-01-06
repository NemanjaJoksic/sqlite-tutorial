/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.dao.util;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import sqlite.tutorial.model.User;

/**
 *
 * @author Nemanja
 */
public class UserMapper {

    public static User map(ResultSet rs) throws SQLException {
        String username = rs.getString("USERNAME");
        String password = rs.getString("PASSWORD");
        String name = rs.getString("NAME");
        BigDecimal age = rs.getBigDecimal("AGE");

        User user = new User(username, password, name, age);
        return user;
    }

}
