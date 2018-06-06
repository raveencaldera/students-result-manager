/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.core;

import java.sql.*;

/**
 *
 * @author Lakmal
 */
public class DatabaseConnection {
    /**
     * if connection instance is exist getDatabaseConnection() returns existing class
     * otherwise it will create new database instance
     */
    private static DatabaseConnection instance;
    private Connection connection;
    
    private DatabaseConnection() {
        String driver = "com.mysql.jdbc.Driver";
        String connectionURL = "jdbc:mysql://localhost:3306/";
        String databaseName = "student_managment";
        String username = "root";
        String password = "";
        
        try {
            Class.forName(driver).newInstance();
            this.connection = (Connection)DriverManager.getConnection(connectionURL + databaseName, username, password);
        }
        catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Connection getDatabaseConnection() {
        return connection;
    }
    
    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getDatabaseConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }
     
    public ResultSet query(String query, int limit) throws SQLException{
        Statement statement = instance.connection.createStatement();
        statement.setMaxRows(limit);
        ResultSet res = statement.executeQuery(query);
        return res;
    }
    
    public int insert(String query) throws SQLException {
        Statement statement = instance.connection.createStatement();
        int res = statement.executeUpdate(query);
        return res;
    }
}
