/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.dao.util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import sqlite.tutorial.dao.DatabaseConnectionHolder;

/**
 *
 * @author Nemanja
 */
public class SQLiteDaoUtil {
    
    public static PreparedStatement createPreparedStatement(String sql) throws SQLException {
        return DatabaseConnectionHolder
                .getConnection()
                .prepareStatement(sql);
    }
}
