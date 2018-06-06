/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.modal;

import java.sql.ResultSet;
import java.sql.SQLException;
import student.results.management.core.database.Delete;
import student.results.management.core.database.Insert;
import student.results.management.core.database.Query;
import student.results.management.core.database.RawQuery;

/**
 *
 * @author Lakmal
 */
public class Modal {   
    private final String schemaName;
    private String[] schema;
    
    public Modal(String schemaName) {
        this.schemaName = schemaName;
    }
    
    void setSchema(String[] schema) {
        this.schema = schema;
    }
    
    public ResultSet select(String[] columns) throws SQLException {
        Query q = new Query(schemaName, columns);
        ResultSet rs = q.execute();
        return rs;
    };
    
    public ResultSet select(String[] columns, int limit) throws SQLException {
        Query q = new Query(schemaName, columns);
        q.limit(limit);
        ResultSet rs = q.execute();
        return rs;
    };
    
    public ResultSet selectAll() throws SQLException {
        Query q = new Query(schemaName);
        ResultSet rs = q.execute();
        return rs;
    };
    
    public int create(String[] values) throws Exception {
        Insert i = new Insert(schemaName, schema, values);
        return i.execute();
    }
    
    public int create(String[] values, String[] columns) throws Exception {
        Insert i = new Insert(schemaName, schema, values, columns);
        return i.execute();
    }

    public boolean delete(String value) throws SQLException {
        Delete d = new Delete(schemaName, schema[0], value);
        return true;
    }
    
    public int update(String sql) throws Exception {
        RawQuery u = new RawQuery(sql);
        int i = u.execute();
        return i;
    }
    
}
