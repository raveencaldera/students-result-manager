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
public class Batch extends Modal{
    private final String[] schema = {"id", "start_year", "name"};

    public Batch() {
        super("batch");
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
    
    public int update(int id, String name, int year) throws Exception {
        String sql = String.format("UPDATE batch SET name = '%s', start_year = %d WHERE id = %d", name, year, id);
        return super.update(sql);
    }
}
