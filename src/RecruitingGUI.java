import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


/**
 * @author Jake Knowles
 * @author Patrick Stevens
 * @version 08/10/2017
 */

/*
 * RecruitingGUI is the GUI for our application. This class loads all of the UI.
 */
public class RecruitingGUI extends JFrame {
	
    /*  A generated serial version UID for object Serialization. */
    private static final long serialVersionUID = 1L;
    
    /* My panel. */
    private static JPanel myPanel;
    
    /* The north panel. */
    private static JPanel myNorthPanel;
    
    /*  The south panel. */
    private static JPanel mySouthPanel;
    
    /*  The middle panel. */
    private static JPanel myCentralPanel;
    
    /* Colleges that appear in drop down combo box */
	private static final String[] colleges = { "Arizona", "Arizona State", "California",  "Colorado", 
			"Oregon", "Oregon State", "Stanford", "UCLA", "USC", "Utah", "Washington", "Washington State" };
	
	/* Positions that appear in drop down combo box */
	private static final String[] positions = { "Offense", "Defense", "Special Teams" };
	
	/* Scholarships that appear in drop down combo box */
	private static final String[] scholarships = { "100", "75", "50", "25", "0" };
	
	/* High school states that appear in drop down combo box */
	private static final String[] highschoolState = { "AK", "AL", "AR", "AZ","CA", "CO","CT","DE", "FL", 
			"GA", "HI", "IA", "ID", "IL", "IN", "KS", "KY", "LA", "MA", "MD", "ME", "MI", "MN", 
			"MO", "MS", "MT", "NE", "NH", "NJ", "NM", "NV", "NY", "NC", "ND", "OH", "OK", "OR", "PA","RI",
			"SC", "SD", "TN", "TX", "UT", "VT", "VA","WA", "WI", "WV", "WY" };
	
	/* High school classes that appear in drop down combo box */
	private static final String[] highschoolClass = { "Senior ", "Junior", "Sophomore", "Freshman"};
	
    /* JComboBox with colleges */
    private static final JComboBox<String> collegeBox = new JComboBox<String>(colleges);
    
    /* JComboBox with positions */
    private static final JComboBox<String> positionBox = new JComboBox<String>(positions);
    
    /* JComboBox with scholarships */
    private static final JComboBox<String> scholarshipBox = new JComboBox<String>(scholarships);
    
    /* JComboBox with high school states */
    private static final JComboBox<String> highschoolStateBox = new JComboBox<String>(highschoolState);
    
    /* JComboBox with high school classes */
    private static final JComboBox<String> highschoolClassBox = new JComboBox<String>(highschoolClass);
    
    /* College Label. */
    private static JLabel collegeLabel = new JLabel("College:");
   
    /* Positions Label. */
    private static JLabel positionLabel = new JLabel("Position:");
    
    /* Scholarship Label. */
    private static JLabel scholarshipLabel = new JLabel("Scholarship:");
    
    /* High School State Label. */
    private static JLabel highSchoolStateLabel = new JLabel("High School State:");
    
    /* High School Class Label. */
    private static JLabel highSchoolClassLabel = new JLabel("High School Class:");
    
    /* JButton for submitting search */
    private static final JButton goButton = new JButton("SEARCH");
    
    /* JButton for submitting search */
    private static final JEditorPane textView = new JEditorPane();
    
    /* Border for JEditorPane */
    private static final Border textBorder = new LineBorder(Color.BLACK, 7);
   
    /* College Variable for storing selection */
    public static String collegeSelection = "Arizona";
    
    /* Position Variable for storing selection */
    public static String positionSelection = "Offense";
    
    /* Scholarship Variable for storing selection */
    public static String scholarshipSelection = "100";
    
    /* State Variable for storing selection */
    public static String stateSelection = "AK";
    
    /* Class Variable for storing selection */
    public static String classSelection = "Senior";
    
	
    /* Constructor */
    public RecruitingGUI() {
        super("PJ Recruiting");
        this.setResizable(false);
    }

    
    /* Creates UI */
    private void createUI() {
    	
        myPanel = new JPanel(new BorderLayout()); // Main Panel
        myNorthPanel = new JPanel(new FlowLayout()); // Panel with drop downs
        mySouthPanel = new JPanel(new FlowLayout()); // Panel with text area
        myCentralPanel = new JPanel(new FlowLayout()); // Panel with button
        
       
        myNorthPanel.add(collegeLabel);
        myNorthPanel.add(collegeBox);
        
        myNorthPanel.add(positionLabel);
        myNorthPanel.add(positionBox);
        
        myNorthPanel.add(scholarshipLabel);
        myNorthPanel.add(scholarshipBox);
        
        myNorthPanel.add(highSchoolStateLabel);
        myNorthPanel.add(highschoolStateBox);
        
        myNorthPanel.add(highSchoolClassLabel);
        myNorthPanel.add(highschoolClassBox);
        
        
        /* Button Stuff */
        goButton.setToolTipText("Click to search for student");  
        goButton.setPreferredSize(new Dimension(150, 35));
        goButton.setBackground(Color.YELLOW);
        goButton.setOpaque(true); 
        myCentralPanel.add(goButton);
        
        
        /* Text View Stuff */
        Color myGrey = Color.decode("#fafafa"); // Light grey
        textView.setPreferredSize(new Dimension(1000, 250));
        textView.setBorder(textBorder);
        textView.setBackground(myGrey);
        textView.setEnabled(false); // Non-editable

        
        mySouthPanel.add(textView);
        
        myPanel.add(myNorthPanel, BorderLayout.NORTH);
        myPanel.add(myCentralPanel, BorderLayout.CENTER);
        myPanel.add(mySouthPanel, BorderLayout.SOUTH);
       

        Color myPurple = Color.decode("#CAC2FF"); // Light Purple
        myNorthPanel.setBackground(myPurple);
        myCentralPanel.setBackground(myPurple);
        mySouthPanel.setBackground(myPurple);
        
        add(myPanel);
        pack();
        
        goSearch();
        collegeBoxListener();
        positionBoxListener();
        scholarshipBoxListener();
        stateBoxListener();
        classBoxListener();
    	
    }
    
    /* Once 'SEARCH; is pressed */
    private void goSearch() {
        goButton.addActionListener(new ActionListener() { 
            public void actionPerformed(final ActionEvent theEvent) {
            	displayOnJEditorPane();

        }
        });
    }
    
    /* Displays output to text area */
    private void displayOnJEditorPane() {
        String output = ("You picked: \n" + " - " + collegeSelection + "\n" +  " - " + positionSelection + "\n" + " - " + 
        					scholarshipSelection + "\n" + " - " + stateSelection + "\n" + " - " + classSelection);
        textView.setText(output);
        
    }
    
    /* College Box Listener */
    private void collegeBoxListener() {
    	
    	collegeBox.addActionListener(new ActionListener() {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	collegeSelection = (String) collegeBox.getSelectedItem();
	
        }
    	});
    }
    
    /* Position Box Listener */
    private void positionBoxListener() {
    	
    	positionBox.addActionListener(new ActionListener() {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	positionSelection = (String) positionBox.getSelectedItem();
	
        }
    	});
    }
    
    /* Scholarship Box Listener */
    private void scholarshipBoxListener() {
    	
    	scholarshipBox.addActionListener(new ActionListener() {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	scholarshipSelection = (String) scholarshipBox.getSelectedItem();
	
        }
    	});
    }
    
    /* High School State Box Listener */
    private void stateBoxListener() {
    	
    	highschoolStateBox.addActionListener(new ActionListener() {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	stateSelection = (String) highschoolStateBox.getSelectedItem();
	
        }
    	});
    }
    
    /* High School Class Box Listener */
    private void classBoxListener() {
    	
    	highschoolClassBox.addActionListener(new ActionListener() {
    	
        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	classSelection = (String) highschoolClassBox.getSelectedItem();
	
        }
    	});
    }
    
    
    
    /** Starts the GUI. */
    public void start() {
        createUI(); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
   
}