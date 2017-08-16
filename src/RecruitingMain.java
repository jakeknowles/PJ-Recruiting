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
 *
 */
public class RecruitingMain {
	
    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private RecruitingMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the SnapShop GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
    	
        Vector columnNames = new Vector();
        Vector data = new Vector();
        
        
//      try {
//    	String url = "jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=AdventureWorks2012;integratedSecurity=true";
//  	  	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//  	  	Connection conn = DriverManager.getConnection(url);
//        String sql = "select FirstName, LastName from Person.person";
//        Statement statement = conn.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        ResultSetMetaData metaData = resultSet.getMetaData();
//        int columns = metaData.getColumnCount();
//        
//        for (int i = 1; i <= columns; i++) {
//            columnNames.addElement(metaData.getColumnName(i));
//        }
//        
//        
//        while (resultSet.next()) {
//        	
//            Vector row = new Vector(columns);
//            for (int i = 1; i <= columns; i++) {
//                row.addElement(resultSet.getObject(i));
//            }
//            data.addElement(row);
//        }
//        
//        resultSet.close();
//        statement.close();
//        
//    } catch (Exception e) {
//        System.out.println(e);
//    }
    
//    JTable table = new JTable(data, columnNames);
//    table.setSize(500, 500);
//    TableColumn column;
//    
//    for (int i = 0; i < table.getColumnCount(); i++) {
//        column = table.getColumnModel().getColumn(i);
//        column.setMaxWidth(250);
//    }
    	
    	
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Database().start();
            }
        });
    }

}