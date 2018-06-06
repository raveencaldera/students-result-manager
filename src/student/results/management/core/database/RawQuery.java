/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.core.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import student.results.management.core.DatabaseConnection;

/**
 *
 * @author Lakmal
 */
public class RawQuery {
    private final String sql;
    private PreparedStatement statement;
    
    public RawQuery(String sql) {
        this.sql = sql;
    }
    
    public int execute() throws SQLException {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        statement = dbInstance.getDatabaseConnection().prepareStatement(sql);
        int res = statement.executeUpdate();
        return res;
    }
    
    public ResultSet getData() throws SQLException {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        statement = dbInstance.getDatabaseConnection().prepareStatement(sql);
        return statement.executeQuery();
    }
    
    public ResultSet getOne() throws SQLException {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        statement = dbInstance.getDatabaseConnection().prepareStatement(sql);
        statement.setMaxRows(1);
        return statement.executeQuery();
    }
}
