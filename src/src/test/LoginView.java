package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * Creates a Login Panel for user to log in as seller or buyer
 * @author Oscar Vasquez
 */
public class LoginView {
	static JFrame frame;
	/**
	 * Adds the different components t a the panel
	 * @param panel: Where components will be added
	 * @author Oscar Vasquez
	 */
private static void placeComponents(JPanel panel){
	
	panel.setLayout(null);
	
	JLabel userLabel= new JLabel("User");
	userLabel.setBounds(10,10,80,25);
	panel.add(userLabel);
	
	JTextField userText = new JTextField(20);
	userText.setBounds(100,10,160,25);
	panel.add(userText);
	
	JLabel passwordLabel=new JLabel("Password");
	passwordLabel.setBounds(10,40,80,25);
	panel.add(passwordLabel);
	
	JPasswordField passwordText=new JPasswordField(20);
	passwordText.setBounds(100,40,160,25);
	panel.add(passwordText);
	
	JButton loginButton = new JButton("Login");
	loginButton.setBounds(10,80,80,25);
	panel.add(loginButton);
	
	JButton registerButton= new JButton("Register");
	registerButton.setBounds(180,80,85,25);
	panel.add(registerButton);
	
	ActionListener loginButtonListener = new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			String [] x = new String[1];
			if(userText.getText().equals("buyer12345") && checkPassword(passwordText.getPassword())==true){
			MainPage f=new MainPage();
			x[0]="b";
			f.main(x);
			frame.dispose();}
			else if(userText.getText().equals("seller12345") && checkPassword(passwordText.getPassword())==true){
			MainPage f=new MainPage();
			x[0]="s";
			f.main(x);
			frame.dispose();}
			else{
				JOptionPane.showMessageDialog(null,"Incorrect username or password");
			}
		}};
	loginButton.addActionListener(loginButtonListener);
}
/**
 * Checks if user entered in correct password
 * @param input: User entered password
 * @return: Boolean true if password is correct, false if not
 * @author Oscar Vasquez
 */
public static boolean checkPassword(char[] input){
	boolean correctPassword=true;
	char[] password={'P','a','s','s','w','o','r','d','1','2','3','4','5'};
	if(input.length != password.length){
		correctPassword=false;
	}
	else{
		correctPassword=Arrays.equals(input,password);
	}
	
	return correctPassword;
}
	
	
	
	public static void main(String[] args){
		frame = new JFrame("Shopping Cart");
		frame.setSize(350,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setVisible(true);

		
		}

}
