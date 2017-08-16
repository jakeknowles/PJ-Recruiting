import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 * @author Patty
 * @author jake
 * @version 08/10/2017
 */


public class Database extends JFrame {
	
    /**  A generated serial version UID for object Serialization. */
    private static final long serialVersionUID = 1L;
    
    /** My panel. */
    private static JPanel myPanel;
    
    /** The north panel. */
    private static JPanel myNorthPanel;
    
    /**  The south panel. */
    private static JPanel mySouthPanel;
    
    /**  The middle panel. */
    private static JPanel myCentralPanel;
    
    /** Colleges that appear in drop down combo box */
	private static final String[] colleges = { "Oregon State", "USC", "Stanford", "Arizona", "California", 
    		"Washington", "Utah", "UCLA", "Colorado", "WSU", "Arizona State", "Oregon" };
	
	 /** Positions that appear in drop down combo box */
	private static final String[] positions = { "Offense", "Defense", "Special Teams" };
	
	 /** Scholarships that appear in drop down combo box */
	private static final String[] scholarships = { "100", "75", "50", "25", "0" };
	
	 /** High school states that appear in drop down combo box */
	private static final String[] highschoolState = { "AK", "AL", "AR", "AZ","CA", "CO","CT","DE", "FL", 
			"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", 
			"MO", "MS", "MT", "NE", "NH", "NJ", "NM", "NV", "NY", "NC", "ND", "OH", "OK", "OR", "PA","RI",
			"SC", "SD", "TN", "TX", "UT", "VT", "VA","WA", "WI", "WV", "WY" };
	
	 /** High school classes that appear in drop down combo box */
	private static final String[] highschoolClass = { "Senior ", "Junior", "Sophomore", "Freshman"};
	
    /** JComboBox with colleges */
    private static final JComboBox<String> collegeBox = new JComboBox<String>(colleges);
    
    /** JComboBox with positions */
    private static final JComboBox<String> positionBox = new JComboBox<String>(positions);
    
    /** JComboBox with scholarships */
    private static final JComboBox<String> scholarshipBox = new JComboBox<String>(scholarships);
    
    /** JComboBox with high school states */
    private static final JComboBox<String> highschoolStateBox = new JComboBox<String>(highschoolState);
    
    /** JComboBox with high school classes */
    private static final JComboBox<String> highschoolClassBox = new JComboBox<String>(highschoolClass);
    
    /** Label. */
    private static JLabel label = new JLabel();
    
    /** JButton for submitting search */
    private static final JButton okButton = new JButton("OK");
	
	
    /** Constructor */
    public Database() {
        super("PJ Recruiting");
    }
    
    
    private void createUI() {
    	
        myPanel = new JPanel(new BorderLayout());
        myNorthPanel = new JPanel(new FlowLayout());
        mySouthPanel = new JPanel(new FlowLayout());
        myCentralPanel = new JPanel(new FlowLayout());
        
        
        myNorthPanel.add(collegeBox);
        myNorthPanel.add(positionBox);
        myNorthPanel.add(scholarshipBox);
        myNorthPanel.add(highschoolStateBox);
        myNorthPanel.add(highschoolClassBox);
        myCentralPanel.add(label);
        mySouthPanel.add(okButton);
        
        myPanel.add(myNorthPanel, BorderLayout.NORTH);
        myPanel.add(myCentralPanel, BorderLayout.CENTER);
        myPanel.add(mySouthPanel, BorderLayout.SOUTH);
        
        add(myPanel);
        pack();
    	
    }
    
    /** Starts the GUI. */
    public void start() {
        createUI(); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
}