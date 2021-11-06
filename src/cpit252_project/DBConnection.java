/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package cpit252_project;

import java.sql.*;
import java.sql.DriverManager;

public class DBConnection {
    
     static Connection conn = null;
    
    private DBConnection() {}
    
    public static Connection getDBInstance() {
        try{ 
            if (conn == null) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb?useSSL=false", "root", "");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    
        return conn;
    }
}
