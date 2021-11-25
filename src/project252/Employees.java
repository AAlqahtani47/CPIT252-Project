/*
Name: Abdulrahman Alqahtani 
ID: 1846618
 */
package project252;

import java.sql.Connection;
import java.sql.*;

public class Employees implements Commands {

    Connection conn = DBConnection.getDBInstance();
    PreparedStatement stat;

    static int id;
    static String name;
    static double salary;
    static String department;
    String ins;
    public void insert() {
        try {
            ins ="insert into employees values (";
            ins += id + ", '"+ name + "'," + salary + ",'" + department + "')";
            stat.execute(ins);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }

    public void update() {
       try {
            
            stat = conn.prepareStatement("update employees set salary=? where name=? ");
            stat.setDouble(1, salary);
            stat.setString(2, name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete() {
      try {
            
            stat = conn.prepareStatement("delete from employees where name=? ");
            stat.setString(1, name);
            stat.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
