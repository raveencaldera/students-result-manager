/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import student.results.management.core.database.RawQuery;

/**
 *
 * @author Lakmal
 */
public class Module extends Modal{
    private final String[] schema = {"id", "name", "department_id", "batch_id", "lecturer_id"};

    public Module() {
        super("module");
        super.setSchema(schema);
    }
    
    @Override
    public ResultSet select(String[] columns) throws SQLException {
        return super.select(columns);
    }
    
    @Override
    public ResultSet select(String[] columns, int limit) throws SQLException {
        return super.select(columns, limit);
    }
    
    @Override
    public ResultSet selectAll() throws SQLException{
        return super.selectAll();
    }
    
    @Override
    public int create(String columns[]) throws Exception {
        return super.create(columns);
    }
    
    @Override
    public boolean delete(String value) throws SQLException {
        return super.delete(value);
    }
    
    public int update(int id, String name, String department_id, String batch_id, String lecturer_id) throws Exception {
        String sql = String.format("UPDATE module SET name='%s', department_id=%s, batch_id=%s, lecturer_id=%s WHERE id=%s", name, department_id, batch_id, lecturer_id, id);
        return super.update(sql);
    }
    
    public ResultSet getByDepartmentAndBatch(String department_id, String batch_id) throws SQLException {
        String sql = String.format("SELECT * FROM module WHERE department_id = %s and batch_id = %s", department_id, batch_id);
        RawQuery modules = new RawQuery(sql);
        return modules.getData();
    }
}
