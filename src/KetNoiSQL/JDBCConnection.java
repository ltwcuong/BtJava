/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KetNoiSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Thanh Cuong
 */
public class JDBCConnection {
     public static Connection getJDBCConnection() {
        
        final String url04 = "jdbc:sqlserver://localhost:1433;databasename=SanPham;";
        final String user04 = "sa";
        final String password04 = "1";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            return DriverManager.getConnection(url04, user04, password04);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
    
}
