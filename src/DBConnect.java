import java.awt.EventQueue;
import java.util.Vector;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * Project for Database TCSS 445
 * @author Jake Knowles
 * @author Patrick Stevens
 * @version 08/16/2017
 *
 */
public class DBConnect {
	

	
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    DBConnect() {
        
    }
    
    /*Connects to DB and sends sql statement with vars*/
    public static ArrayList Connecting(String theCollege, String thePosition, int theScholarship, String theHSState, String theHSClass ) {
    
    		
	        Vector columnNames = new Vector();
	        Vector data = new Vector();
	        
	      try {
	    	String url = "jdbc:sqlserver://127.0.0.1;databaseName=PJRecruitingDB;integratedSecurity=true";
	  	  	//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	  	  	Connection conn = DriverManager.getConnection(url);
	        String sql = "exec spSelectedVariables " + theCollege + ", " + thePosition + ", " + theScholarship + ", " + theHSState + ", " + theHSClass + ";";
	        Statement statement = conn.createStatement();
	        ResultSet resultSet = statement.executeQuery(sql);
	        ResultSetMetaData metaData = resultSet.getMetaData();
	        int columns = metaData.getColumnCount();
	        
	        for (int i = 1; i <= columns; i++) {
	            columnNames.addElement(metaData.getColumnName(i));
	           
	        }
	        
	        
	       while (resultSet.next()) {
	       
	            Vector row = new Vector(columns);
	            for (int i = 1; i <= columns; i++) {
	                row.addElement(resultSet.getObject(i));
	            }
	            data.addElement(row);
	        }
	        
	        resultSet.close();
	        statement.close();
	        
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    
	    ArrayList testing = new ArrayList();
	    testing.add(columnNames);
	    testing.add(data);
		  return testing;
		    	
		       
		        
		        
		}
    

	
}


