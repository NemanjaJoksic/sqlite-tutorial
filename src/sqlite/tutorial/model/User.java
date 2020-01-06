/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.model;

import java.math.BigDecimal;

/**
 *
 * @author Nemanja
 */
public class User {
    
    private String username;
    private String password;
    private String name;
    private BigDecimal age;

    public User(String username, String password, String name, BigDecimal age) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAge() {
        return age;
    }
    
}
