/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.core.database;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import student.results.management.core.DatabaseConnection;
import student.results.management.utils.Helper;

/**
 *
 * @author Lakmal
 */
public class Insert {
    private final String table;
    private final String[] schema;
    private String[] column;
    private final String[] data;
    private PreparedStatement statement;
      
    public Insert(String table, String[] schema, String[] data) {
        this.table = table;
        this.schema = schema;
        this.data = data;
    }
    
    public Insert(String table, String[] schema, String[] data, String[] column) {
        this.table = table;
        this.schema = schema;
        this.data = data;
        this.column = column;
    }
       
    public int execute() throws SQLException, java.lang.Exception {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        
        if (column != null && column.length > 0) {
            String[] formatedColumnArray = Helper.formatArrayToSchemaModal(schema, column);
            String formatedSchema = Helper.arrayToCommaSeparatedString(schema);
            String formatedColumn = Helper.arrayToCommaSeparatedString(formatedColumnArray);
            statement = dbInstance.getDatabaseConnection().prepareStatement("INSERT INTO " + table + " (" + formatedSchema + " )" + " VALUES (" + formatedColumn + ")");
        } else {
            String sql;
            if (schema.length == 1) {
                String numberOfColumns = Helper.CommaSeparatedQuizMarks(schema.length);
                sql = "INSERT INTO " + table + " VALUES (" + numberOfColumns + ")";
            } else {
                String numberOfColumns = Helper.CommaSeparatedQuizMarks(schema.length -1);
                sql = "INSERT INTO " + table + " VALUES (default, " + numberOfColumns + ")";
            }
            statement = dbInstance.getDatabaseConnection().prepareStatement(sql);
        }
        
        for (int i = 0; i < data.length; i++) {
            String type = data[i].split(":")[0];
            String value = data[i].split(":")[1];
            
            int index = i + 1;
            
            if (null != type) switch (type) {
                case "int":
                    statement.setInt(index, parseInt(value));
                    break;
                case "str":
                    statement.setString(index, value);
                    break;
                case "float":
                    statement.setFloat(index, parseFloat(value));
                    break;
                default:
                    throw Exception("invalid data type of values");
            }
        }
        int res = statement.executeUpdate();  
        return res;
    }

    private Exception Exception(String e) {
        throw new UnsupportedOperationException(e);
    }
    
}
