package Code;

import java.util.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	//creates a JPanel called contentPane
	private JPanel contentPane;
	//creates a database object called dat
	private Database dat = new Database();
	//creates a Note object called note
	private Note note;
	//creates a JButton called back
	private JButton back = new JButton("Back");
	//creates a JTextArea called text
	private JTextArea text = new JTextArea();
	//creates a JButton called timerBack
	private JButton timerBack = new JButton("Back");
	//creates a Activity object called activity
	private Activity activity;
	//creates 4 uninitialized JFrames
	private JFrame activityFrame;
	private JFrame SetupFrame;
	private JFrame recordsFrame;
	private JFrame modifyFrame;
	//creates 2 String variables called actName and actDate
	private String actName,actDate;
	//creates a JTextfield called name
	private JTextField name = new JTextField(30);
	//creates a JButton called print
	private JButton print = new JButton("Print Table");
	//creates a JLabel called menuText
	private JLabel menuText = new JLabel("Main Menu");
	//creates a JButton called startActivity
	private JButton startActivity = new JButton("Start Activity");
   	//creates a JButton called Review
	private JButton Review = new JButton("Review Records");
   	//creates a JButton called start
	private JButton start = new JButton("Start");
   	//creates 3 JButtons for the frame that holds the timer
	private JButton Pause = new JButton("Pause");
	private JButton Resume = new JButton("Resume");
	private JButton addtime = new JButton("Add time");
	private JButton Reset = new JButton("Reset");
   	//creates 3 JLabels for the current activity
	private JLabel activityName = new JLabel("Actyivity Name: ");
	private JLabel activitySetupHeader = new JLabel("Activity Setup");
   	private JLabel activityHeader = new JLabel("");
   	//creates a JTextArea called activityOptional
   	private JTextArea activityOptional = new JTextArea("");
   	//creates a JLabel called timerLabel
   	public JLabel timerLabel = new JLabel("00 : 00 : 00");
   	//creates JButtons for the frames
   	private JButton modifyBack = new JButton("Back");
   	private JButton reviewBack = new JButton("Back");
   	private JButton modify = new JButton("Modify");
   	private JButton update = new JButton("Update");
   	private JButton remove = new JButton("Remove");
   	//creates textfields for the modify frame
   	private JTextField activName = new JTextField(30);
   	private JTextField activNotes = new JTextField(30);
	//creates a timer object called time
   	private timer time = new timer();
	
	/*
	 * This method creates the modify frame and adds components to it
	 */
	public void modifyFrame() {
		modifyFrame = new JFrame();
		modifyFrame.setVisible(true);
		modifyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		modifyFrame.setBounds(200, 200, 450, 300);
		modifyBack.addActionListener(this);
		remove.addActionListener(this);
		update.addActionListener(this);
		JPanel mainPanel = new JPanel();
		JPanel textFields = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel instructPanel = new JPanel();
		modifyFrame.add(mainPanel);
		mainPanel.add(instructPanel);
		instructPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		instructPanel.add(new JLabel("To remove activity type the name of activity then hit the remove button"), c);
		c.gridx = 0;
		c.gridy = 1;
		instructPanel.add(new JLabel("To update activity notes enter name and new notes then hit update button"), c);
		mainPanel.add(textFields);
		mainPanel.add(buttonPanel);
		textFields.setLayout(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 0;
		textFields.add(new JLabel("Activity Name:"), c);
		c.gridx = 1;
		c.gridy = 0;
		textFields.add(activName,c);
		c.gridx = 0;
		c.gridy = 1;
		textFields.add(new JLabel("Activity Notes:"), c);
		c.gridx = 1;
		c.gridy = 1;
		textFields.add(activNotes,c);
		buttonPanel.add(remove);
		buttonPanel.add(update);
		buttonPanel.add(modifyBack);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	}
	
	/*
	 * This method creates the records frame and adds components to it and
	 * has buttons that call methods from the database class
	 */
	public void recordsFrameOptions() {
		modify.addActionListener(this);
		reviewBack.addActionListener(this);
		print.addActionListener(this);
		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		JPanel textpanePanel = new JPanel();
		recordsFrame = new JFrame();
		recordsFrame.setVisible(true);
		recordsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		recordsFrame.setBounds(200, 200, 450, 300);
		recordsFrame.add(mainPanel);
		mainPanel.add(textpanePanel);
		mainPanel.add(fieldPanel);
		mainPanel.add(buttonPanel);
		buttonPanel.add(print);
		buttonPanel.add(modify);
		buttonPanel.add(back);
		text.setBorder(BorderFactory.createEmptyBorder());
		text.setEditable(false);
		JScrollPane scriptScroller = new JScrollPane(text);
		scriptScroller.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		scriptScroller.setPreferredSize(new Dimension(400, 150));
		textpanePanel.add(scriptScroller);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	}
	
	/*
	 * This method creates the activitysetup frame and adds components to it
	 */
	public void activitySetupFrameOptions() {
		back.addActionListener(this);
		start.addActionListener(this);
		JPanel headerPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel fieldPanel = new JPanel();
		JPanel textpanePanel = new JPanel();
		SetupFrame = new JFrame();
		SetupFrame.setVisible(true);
		SetupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SetupFrame.setBounds(200, 200, 450, 300);
		SetupFrame.add(mainPanel);
		mainPanel.add(headerPanel);
		headerPanel.add(activitySetupHeader);
		mainPanel.add(textpanePanel);
		mainPanel.add(fieldPanel);
		mainPanel.add(buttonPanel);
		fieldPanel.add(activityName);
		fieldPanel.add(name);
		buttonPanel.add(start);
		buttonPanel.add(back);
		activityOptional.setBorder(BorderFactory.createEmptyBorder());
		JScrollPane scriptScroller = new JScrollPane(activityOptional);
		scriptScroller.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
		scriptScroller.setPreferredSize(new Dimension(400, 150));
		textpanePanel.add(scriptScroller);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	}
	
	/*
	 * This method creates the frame that holds the timer 
	 */
	public void activityFrameOptions() {
		timerBack.addActionListener(this);
		Pause.addActionListener(this);
		Reset.addActionListener(this);
		addtime.addActionListener(this);
		JPanel timerPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		JPanel activityPanel = new JPanel();
		activityFrame = new JFrame();
		activityFrame.setVisible(true);
		activityFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		activityFrame.setBounds(200, 200, 450, 300);
		activityFrame.add(activityPanel);
		activityPanel.add(textPanel);
		activityPanel.add(timerPanel);
		activityPanel.add(buttonPanel);
		textPanel.add(activityHeader);
		timerPanel.add(timerLabel);
		buttonPanel.add(Pause);
		buttonPanel.add(addtime);
		buttonPanel.add(Reset);
		buttonPanel.add(timerBack);
		activityPanel.setLayout(new BoxLayout(activityPanel, BoxLayout.Y_AXIS));
		time.start1(timerLabel);
	}
	
	/*
	 *This method checks for each actionPerformed or button pressed
	 *@param e This holds the current action event that was done 
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == timerBack) {
			activityFrame.dispose();
			GUI frame = new GUI();
			frame.setVisible(true);
		}
		
		if(e.getSource() == modifyBack) {
			modifyFrame.dispose();
			GUI frame = new GUI();
			frame.setVisible(true);
		}
		
		if(e.getSource() == update) {
			String name = activName.getText();
			String notes = activNotes.getText();
			System.out.println(name);
			System.out.println(notes);
			dat.update(name, "", "", notes);
			activName.setText("");
			activNotes.setText("");
		}
		
		if(e.getSource() == modify) {
			recordsFrame.dispose();
			modifyFrame();
		}
		
		if(e.getSource() == remove) {
			if(activNotes.getText().equals("") && (!activName.getText().equals(""))) {
				dat.remove(activName.getText(),"","","");
			}
			else {
				dat.remove("", "", "", activNotes.getText());
			}
			activName.setText("");
		}
		
		if(e.getSource() == back) {
			SetupFrame.dispose();
			GUI frame = new GUI();
			frame.setVisible(true);
		}	
		if(e.getSource() == print) {
			text.setText(dat.printTable());
		}
		
		if(e.getSource() == reviewBack) {
			recordsFrame.dispose();
			GUI frame = new GUI();
			frame.setVisible(true);
		}
		
		if(e.getSource() == Review) {
			this.dispose();
			recordsFrameOptions();
		}
		
		if(e.getSource() == startActivity) {
			this.dispose();
			activitySetupFrameOptions();
		}
		
		if(e.getSource()== start) {
			Date date = new Date();  
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
			actDate = formatter.format(date);
			System.out.println(actDate);
			actName = name.getText();
			activityHeader.setText(actName);
			note = new Note(activityOptional.getText());
			SetupFrame.dispose();
			activityFrameOptions();
		}
		
		if (e.getSource() == Pause) {
		    if (Pause.getText().equals("Pause")) {
		        time.stop1();
		        Pause.setText("Resume");
		    } else {
		        Pause.setText("Pause");
		        time.start1(timerLabel);
		        
		    }
		}
		if(e.getSource() == Reset) {
			time.reset1(timerLabel);
			time.stop1();
		}
		
		if(e.getSource() == addtime) {
			activity = new Activity(actName,actDate,time.getTimeString(),note);
			dat.add(activity.getActivityName(), activity.getDate(), activity.getTime(),activity.getNote().getNote());
			time.stop1();
			timerLabel.setText("The activity has been added");
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the main menu frame.
	 */
	public GUI() {
		dat.connection();
		JPanel mainPanel = new JPanel();
		startActivity.addActionListener(this);
		Review.addActionListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		JPanel TextPanel = new JPanel();
		add(mainPanel);
		mainPanel.add(TextPanel);
		mainPanel.add(contentPane);
		TextPanel.add(menuText);
		contentPane.add(startActivity);
		contentPane.add(Review);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
	}


}
