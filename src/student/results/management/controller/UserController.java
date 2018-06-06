/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;
import student.results.management.modal.User;

/**
 *
 * @author Lakmal
 */
public class UserController {
    public boolean create(String name, String email, String username, String password, String role) {
        try {
            String[] columns = {"str:" + name, "str:" + email, "str:" + username, "str:" + password, "str:" + role};
            User user = new User();
            user.create(columns);
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate values has been tried to insert, Please check again", "ERROR" , JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public ResultSet getAllData() {
        try {
            String[] columns = {"id", "name", "email", "username", "role"};
            User user = new User();
            return user.select(columns);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean delete(String value) {
        try {
            User user = new User();
            user.delete(value);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean verifyPasword(String role, String username, String password) throws SQLException {
        try {
            User user = new User();
            String hash = user.getPasswordByUsernameAndRole(username, role);
            return BCrypt.checkpw(password, hash);
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public boolean update(int id, String name, String email, String username) {
        try {
            User user = new User();
            user.update(id, name, email, username);
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate values has been tried to insert, Please check again", "ERROR" , JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;  
    }
}
