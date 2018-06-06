/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.core.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import student.results.management.core.DatabaseConnection;

/**
 *
 * @author Lakmal
 */
public class Delete {
    private final String table;
    private final String column;
    private final String value;
    private PreparedStatement statement;
    
    public Delete(String table, String column, String value) throws SQLException {
        this.table = table;
        this.column = column;
        this.value = value;
        deleteItems();
    }
    
    private boolean deleteItems() throws SQLException {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        statement = dbInstance.getDatabaseConnection().prepareStatement("DELETE FROM " + table + " WHERE " + column + " = " + value);
        statement.executeUpdate(); 
        return true;
    }
}
