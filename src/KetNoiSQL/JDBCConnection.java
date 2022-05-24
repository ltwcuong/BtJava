/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package KetNoiSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {

    public static Connection getJDBCConnection() {
        
        final String url = "jdbc:sqlserver://localhost:1433;databasename=Sieuthimini;";
        final String user = "sa";
        final String password = "1";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
        }
        return null;
    }
      public static void main(String[] args) {
        Connection connection = getJDBCConnection();
        if (connection != null) {
            System.out.println("thanh cong");
        } else {
            System.out.println("that bai");
        }
    }
}
