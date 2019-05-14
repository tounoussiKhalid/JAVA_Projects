
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionUtil {
    	public static Connection con= null ;
	Statement st = null;
	String sql = null;
	ResultSet rs = null;
        
    public static Connection conDB()
    {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
	    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","khalid","khalid");	
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("ConnectionUtil : "+ex.getMessage());
           return null;
        }
    }
}

