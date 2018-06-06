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
import student.results.management.modal.Result;

/**
 *
 * @author Lakmal
 */
public class ResultController {
    public boolean create(int student_id, int module_id, int year, int semester, int results) {
        try {
            int[] columns = {student_id, module_id, year, semester, results};
            Result result = new Result();
            result.create(columns);
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
            Result result = new Result();
            return result.selectAll();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public ResultSet getAllDataFromRelatedTable(String module_id) {
        try {
            Result result = new Result();
            return result.selectAllFromRelatedTable(module_id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
    
    public ResultSet getAllDataByStudentId(String studen_id) {
        try {
            Result result = new Result();
            return result.selectAllModulesFromStuden(studen_id);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return null;        
    }
    
    public boolean update(int student_id, int module_id, int year, int semester, int marks) {
        try {
            Result result = new Result();
            result.update(student_id, module_id, year, semester, marks);
            return true;
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "Duplicate values has been tried to insert, Please check again", "ERROR" , JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "ERROR" , JOptionPane.ERROR_MESSAGE);
        }
        return false;  
    }
}
