import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JComboBox;
import javax.swing.JLabel;

/**
 * @author Patty
 * @author jake
 * @version 08/10/2017
 */


public class Database {
    public static void main(String[] args) {
    	
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
//    
//    JScrollPane scrollPane = new JScrollPane(table); 
//    panel.add(scrollPane);  
        
        initialize();

        }
    
    public static void initialize() {
    	
    	String[] schools = { "Oregon State", "USC", "Stanford", "Arizona", "California", 
        		"Washington", "Utah", "UCLA", "Colorado", "WSU", "Arizona State", "Oregon" };
    	
    	String[] positions = { "Offense", "Defense", "Special Teams" };
    	
    	String[] scholarships = { "100", "75", "50", "25", "0" };
    	
    	String[] highschoolState = { "AK", "AL", "AR", "AZ","CA", "CO","CT","DE", "FL", 
    			"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", 
    			"MO", "MS", "MT", "NE", "NH", "NJ", "NM", "NV", "NY", "NC", "ND", "OH", "OK", "OR", "PA","RI",
    			"SC", "SD", "TN", "TX", "UT", "VT", "VA","WA", "WI", "WV", "WY" };
    	
    	String[] highschoolClass = { "Senior ", "Junior", "Sophomore", "Freshman"};
        
    	
    	
        JFrame frame = new JFrame("PJ Recruiting");
        frame.setSize(1000, 600); //setting frame size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Ends when exits
        frame.setLocation(250, 00);
        GridLayout grid = new GridLayout(0, 5);
        frame.setLayout(grid); // O rows, 5 Columns

        JPanel panel = new JPanel();
        Color myColor = Color.decode("#CAC2FF"); // Light Purple
        panel.setBackground(myColor);

        frame.add(panel);         //adding panel to the frame
        
        JLabel collegeLabel = new JLabel("College", JLabel.CENTER);
        collegeLabel.setVisible(true);
        
        JLabel positionLabel = new JLabel("Position");
        positionLabel.setVisible(true);
        
        JLabel scholarshipLabel = new JLabel("Scholarship");
        scholarshipLabel.setVisible(true);
        
        JLabel stateLabel = new JLabel("Highschool State");
        stateLabel.setVisible(true);
        
        JLabel classLabel = new JLabel("Highschool Class");
        classLabel.setVisible(true);
        
        
        panel.add(collegeLabel);
       
        
		JComboBox<String> collegeBox = new JComboBox<String>(schools);
		collegeBox.setVisible(true);
        panel.add(collegeBox);
        
		JComboBox<String> positionBox = new JComboBox<String>(positions);
		positionBox.setVisible(true);
        panel.add(positionBox);
        
        JComboBox<String> scholarshipBox = new JComboBox<String>(scholarships);
        scholarshipBox.setVisible(true);
        panel.add(scholarshipBox);
        
        JComboBox<String> highschoolStateBox = new JComboBox<String>(highschoolState);
        highschoolStateBox.setVisible(true);
        panel.add(highschoolStateBox);
        
        JComboBox<String> highschoolClassBox = new JComboBox<String>(highschoolClass);
        highschoolClassBox.setVisible(true);
        panel.add(highschoolClassBox);
        
        
        JButton button = new JButton("OK");
        panel.add(button);
        
        frame.setVisible(true);  //setting visibility true
        

    }
   
}