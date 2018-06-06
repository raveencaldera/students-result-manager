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
import student.results.management.modal.Student;

/**
 *
 * @author Lakmal
 */
public class StudentController {
     public boolean create(int batch_id, int department_id, String name, String email) {
        try {
            String[] columns = {"int:" + batch_id, "int:" + department_id, "str:" + name, "str:" + email};
            Student s = new Student();
            s.create(columns);
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
            Student s = new Student();
            return s.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean delete(String value) {
        try {
            Student s = new Student();
            s.delete(value);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean update(int id, int batch_id, int department_id, String name, String email) {
        try {
            Student s = new Student();
            s.update(id, batch_id, department_id, name, email);
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate values has been tried to insert, Please check again", "ERROR" , JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;  
    }
}
