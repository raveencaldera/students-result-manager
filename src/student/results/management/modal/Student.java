/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.modal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lakmal
 */
public class Student extends Modal{
    private final String[] schema = {"id", "batch_id", "department_id", "name", "email"};
    
    public Student() {
        super("student");
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
    
    public int update(int id, int batch_id, int department_id, String name, String email) throws Exception {
        String sql = String.format("UPDATE student SET batch_id = %d, department_id = %d, name = '%s', email = '%s' WHERE id = %d", batch_id, department_id, name, email, id);
        return super.update(sql);
    }
}
