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

	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField(); // like text field but does not show the characters typed
	
	JLabel userIDLabel = new JLabel("user ID:" );
	JLabel userPasswordLabel = new JLabel("password:" );		
	JLabel messageLabel = new JLabel("");				
			
	HashMap<String, String> logininfo = new HashMap<String,String>(); 
	
	//constructor
	LoginPage(HashMap<String,String> loginInfoOriginal){
	
		logininfo = loginInfoOriginal;
		
		//add fields - where user types
		userIDField.setBounds(125, 100, 200, 25);
		userPasswordField.setBounds(125, 150, 200, 25);
		
		// label placement: x coordinate, y coordinate, width, height
		userIDLabel.setBounds(50,100,75,25);
		userPasswordLabel.setBounds(50,150,75,25);
		messageLabel.setBounds(125,250,250,35);
		messageLabel.setFont(new Font(null, Font.ITALIC,25));
		
		// create frame - add components of labels and text to frame
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		
		frame.add(userIDField);
		frame.add(userPasswordField);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exits JFrame when closed
		frame.setSize(420,420); // size of frame
		frame.setLayout(null); // no layout manager
		frame.setVisible(true); // I can see the frame 
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
