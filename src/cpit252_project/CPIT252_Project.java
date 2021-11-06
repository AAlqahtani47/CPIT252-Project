/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package cpit252_project;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class CPIT252_Project {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         
        //make an instance using getInstance method instead of the constructor
        Connection conn = DBConnection.getDBInstance();
        Connection conn2 = DBConnection.getDBInstance();
        
        //code for interacting with the database using statements
        Statement stat = conn.createStatement();
        
        /* *these next lines were made for testing and have been commented, so that its not excuted each time the program is run
        stat.execute("create table if not exists employees (ID int primary key unique, name char(25), salary double)");
        stat.execute("insert into employees () values (1847446,'Abdullah Ibrahim', 7765.74)");
        stat.execute("insert into employees () values (1846618,'ABDULRAHMAN ALQAHTANI', 8565.74)");
        stat.execute("insert into employees (ID, name) values (1846564,'NADER ALQAHTANI')");
        stat.execute("UPDATE employees SET salary = 4567.7 WHERE name like 'nader%';");
        stat.execute("drop table employees");
         */
        
        // Check if it is singleton
        if (conn == conn2) {
            System.out.println("Singleton :) \n");
        } else {
            System.out.println("NO :( \n");
        }

        //Get all employees information from table employees in database hoteldb
        try {
            String query = "select * from employees";
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(query);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDouble(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
