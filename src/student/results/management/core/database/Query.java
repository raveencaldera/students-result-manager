/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.core.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import student.results.management.core.DatabaseConnection;
import student.results.management.utils.Helper;

/**
 *
 * @author Lakmal
 */
public class Query {
    private String columns;
    private final String table;
    private String where;
    private String statement;
    private int limit;
    
    /**
     * @param table
     */
    public Query(String table) {
        this.limit = 10000;
        this.table = table;
    }
    
    /**
     * @param table
     * @param columns[]
     */
    public Query(String table, String[] columns) {
        this.limit = 10000;
        this.table = table;
        String arrayToCommaSeparatedString = Helper.arrayToCommaSeparatedString(columns);
        this.columns = arrayToCommaSeparatedString;
    }
    
    /**
     * @param table
     * @param columns
     * columns should be separate by "," commas
     * @param where
     */
    public Query(String table, String columns, String where) {
        this.limit = 10000;
        this.table = table;
        this.columns = columns;
        this.where = where;
    }
    
    public void limit(int limit) {
        this.limit = limit;
    }
    
    public ResultSet execute() throws SQLException {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        dbInstance.getDatabaseConnection();
        
        if(columns == null) {
            statement = "Select * FROM " + table;
        } else if (where == null) {
            statement = "Select " + columns  + " FROM " + table;
        } else {
            statement = "Select " + columns  + " FROM " + table + " WHERE " + where;
        }
        
        ResultSet rs = dbInstance.query(statement, limit);
        return rs;
    }
}
