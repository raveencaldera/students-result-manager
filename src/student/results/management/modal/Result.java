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
public class Result extends Modal{
    private final String[] schema = {"student_id", "module_id", "year", "semester", "results"};

    public Result() {
        super("student_module");
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
    
    public ResultSet selectAllFromRelatedTable(String module_id) throws SQLException {
        String sql = String.format("SELECT student.name, module.name as module, student_module.year, student_module.semester,student_module.results "
                + "FROM `student_module` JOIN module ON student_module.module_id = module.id "
                + "JOIN student ON student_module.student_id = student.id "
                + "WHERE `module_id` = %s", module_id);
        RawQuery student = new RawQuery(sql);
        return student.getData();
    }
    
    public ResultSet selectAllModulesFromStuden(String student_id) throws SQLException {
        String sql = String.format("SELECT module.name as module, student_module.year, student_module.semester, student_module.results "
                + "FROM `student_module` "
                + "JOIN module ON student_module.module_id = module.id "
                + "JOIN student ON student_module.student_id = student.id "
                + "WHERE `student_id` = %s", student_id);
        RawQuery result = new RawQuery(sql);
        return result.getData();
    }
    
    public int create(int columns[]) throws Exception {
        String sql = String.format("INSERT INTO student_module VALUES(%d, %d, %d, %d, %d)", columns[0], columns[1], columns[2], columns[3], columns[4]);
        RawQuery result = new RawQuery(sql);
        return result.execute();
    }
    
    public boolean delete(String value) throws SQLException {
        return super.delete(value);
    }
    
    public int update(int student_id, int module_id, int year, int semester, int marks) throws Exception {
        String sql = String.format("UPDATE student_module SET year =%d, semester = %d, results = %d WHERE student_id = %d and module_id = %d", year, semester, marks, student_id, module_id);
        return super.update(sql);
    }
}
