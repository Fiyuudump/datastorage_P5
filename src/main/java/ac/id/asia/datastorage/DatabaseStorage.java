/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.id.asia.datastorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author D-11
 */
public class DatabaseStorage implements DataStorage {
    private Connection connection;
        public DatabaseStorage(String databasePath) {
        try {
            Class.forName("org.sqlite.JDBC");
            
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s" , databasePath));
            
            initCreateTable();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    // ini private methode (internal methode tambahan di dalam kelas DatabaseStorage
    private void initCreateTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS data (value TEXT)");
        }
    }
    
    @Override
    public void writeData(String data) {
        try (Statement statement = connection.createStatement()) {

            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate(String.format("INSERT INTO data (value) VALUES ('%s')", data));
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
    }
    
    @Override
    public String readData() {
        StringBuilder sb = new StringBuilder();
        try (Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("select * from data");
            while(rs.next()) {
              sb.append("\n");
              sb.append(rs.getString("value"));
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
        }
        
        return sb.toString();
    }
}

