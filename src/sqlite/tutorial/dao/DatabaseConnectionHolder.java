/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Nemanja
 */
public class DatabaseConnectionHolder {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static void connect() throws SQLException, ClassNotFoundException {
        connection = DriverManager.getConnection("jdbc:sqlite:testdb.db");
        System.out.println("Connected to databse");
    }

}
