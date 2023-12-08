import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage implements ActionListener{

	JFrame frame = new JFrame(); // create frame
	
	// create buttons, fields & labels
	JButton loginButton = new JButton("Login"); // button
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField(); // where a user types
	JPasswordField userPasswordField = new JPasswordField(); // like text field but does not show the characters typed
	JLabel userIDLabel = new JLabel("user ID:" ); // text
	JLabel userPasswordLabel = new JLabel("password:" );		
	JLabel messageLabel = new JLabel("");				
			
	HashMap<String, String> logininfo = new HashMap<String,String>(); 
	
	//constructor
	LoginPage(HashMap<String,String> loginInfoOriginal){ // passing in HashMap data
	
		logininfo = loginInfoOriginal;
		
		
		
		// label placement: x coordinate, y coordinate, width, height
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null, Font.ITALIC,25));
		
		//field placement coordinate - where user types
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		// button placement coordinates - *need to add action listener to buttons*
		loginButton.setBounds(125, 200, 100, 25);
		loginButton.addActionListener(this); 
		loginButton.setFocusable(false); // Esthetics - this stops a square from appearing around the button text - not needed
		resetButton.setBounds(225, 200, 100, 25);
		resetButton.addActionListener(this); 
		resetButton.setFocusable(false); // Esthetics - this stops a square from appearing around the button text - not needed
		
		// create frame - add components of labels, textfields & buttons to frame
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		
		frame.add(userIDField);
		frame.add(userPasswordField);
		
		frame.add(loginButton);
		frame.add(resetButton);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits JFrame when closed
		frame.setSize(420,420); // size of frame
		frame.setLayout(null); // no layout manager
		frame.setVisible(true); // I can see the frame 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	
		// if reset button is clicked - clear the text of user and password fields
		if(e.getSource() == resetButton) {
			
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		
		if(e.getSource() == loginButton) {
			
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword()); // need to do this when using JPasswordfield - converts password to string
		
			//check logininfo HashMap
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose(); // gets rid of frame upon successful entry
					WelcomePage welcomePage = new WelcomePage(userID); // calls welcome page
					
					
				}else { // if does not equal password
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong Password");
				}
			}else { // if does not contain user ID
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
	}
}
	
}// end class
