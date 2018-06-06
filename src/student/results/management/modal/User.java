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
public class User extends Modal{
    private final String[] schema = {"id", "name", "email", "username", "password", "role"};

    public User() {
        super("user");
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
    
    public ResultSet selectByRole(String role) throws SQLException {
        String sql = String.format("SELECT * FROM user WHERE role = '%s'", role);
        RawQuery users = new RawQuery(sql);
        return users.getData();
    }
    
    public String getPasswordByUsernameAndRole(String username, String role) throws SQLException {
        String sql = String.format("SELECT password FROM user where username = '%s' and role = '%s'", username, role);
        RawQuery users = new RawQuery(sql);
        ResultSet rs = users.getOne();
        if (rs.next()) {
            return rs.getString("password");
        }
        return null;
    }
    
    @Override
    public int create(String columns[]) throws Exception {
        return super.create(columns);
    }
    
    @Override
    public boolean delete(String value) throws SQLException {
        return super.delete(value);
    }
    
    public int update(int id, String name, String email, String username) throws Exception {
        String sql = String.format("UPDATE user SET name = '%s', email = '%s', username = '%s' WHERE id = %d", name, email, username, id);
        return super.update(sql);
    }
}
