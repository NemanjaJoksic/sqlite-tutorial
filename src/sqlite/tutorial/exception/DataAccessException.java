/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlite.tutorial.exception;

/**
 *
 * @author Nemanja
 */
public class DataAccessException extends Exception {
    
    public DataAccessException(Throwable t) {
        super(t);
    }
    
}
