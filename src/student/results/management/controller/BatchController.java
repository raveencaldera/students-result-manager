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
import student.results.management.modal.Batch;

/**
 *
 * @author Lakmal
 */
public class BatchController{
    public boolean create(int year, String name) {
        try {
            String[] columns = {"int:" + year, "str:" + name};
            Batch b = new Batch();
            b.create(columns);
            
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
            Batch b = new Batch();
            return b.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public boolean delete(String value) {
        try {
            Batch b = new Batch();
            b.delete(value);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }
    
    public boolean update(int id, String name, int year) {
        try {
            Batch b = new Batch();
            b.update(id, name, year);
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate values has been tried to insert, Please check again", "ERROR" , JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;  
    }
}
