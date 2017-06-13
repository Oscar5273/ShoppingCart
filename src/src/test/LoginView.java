package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;  
/**
 * Creates a Login Panel for user to log in as seller or buyer
 * @author Oscar Vasquez
 */
public class LoginView {
	static JFrame frame;
	/**
	 * Adds the different components to the panel
	 * @param panel: Where components will be added
	 * Test
	 * @author Oscar Vasquez
	 */
private static void placeComponents(JPanel panel){
	
	panel.setLayout(null);
	
	JLabel userLabel= new JLabel("Username");
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
	
	

	/*Login button action listener
	 * Checks entered password with stored password and logins user
	 * 
	 */
	ActionListener loginButtonListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e){
			String url = "jdbc:mysql://rds-mysql-10mintutorial.c2mpgzjscjnj.us-east-1.rds.amazonaws.com:3306/javabase";
			String username = "oscar5273";
			String password = "Server1720";

			System.out.println("Connecting database...");
			Connection con;

			try (Connection connection = DriverManager.getConnection(url, username, password);) {
			    System.out.println("Database connected!");
			    con= DriverManager.getConnection(url, username, password);
			} catch (SQLException f) {
			    throw new IllegalStateException("Cannot connect the database!", f);
			} 
			
			
			String [] x = new String[1];

			String candidate=passwordText.getText();
			
			String pw_hash = BCrypt.hashpw(candidate, BCrypt.gensalt());
			
			
			String uname=userText.getText();
			Statement stmt = null;
		    String query = "select firstname,lastname,password,address,ccard " +
	                   "from " + "javabase" + ".shoppingcart where username=\""+uname+"\"";
	        try {
				stmt = con.createStatement();
				
				ResultSet rs = stmt.executeQuery(query);

				if(rs.next()==false)
	            	JOptionPane.showMessageDialog(null,"Incorrect username or password");
				else{
					rs.previous();
		        while (rs.next()) {
		            String fname = rs.getString("firstname");
		            String addr=rs.getString("address");;
  					String ccard=rs.getString("ccard");;
  					String lname = rs.getString("lastname");
		            pw_hash=rs.getString("password");
		            System.out.println(fname + "\t" + lname);
		            

		            if (BCrypt.checkpw(candidate, pw_hash)){
		      			 System.out.println("It matches");
		      			if(userText.getText().equals("seller123")){
		      				MainPage f=new MainPage();
		      				x[0]="s";
		      				f.main(x,addr,ccard);
		      				frame.dispose();}
		      				else{
		      							
		      				MainPage f=new MainPage();
		      				x[0]="b";
		      				f.main(x,addr,ccard);
		      				frame.dispose();}
		            }else{
		      			 System.out.println("It does not match");
		            JOptionPane.showMessageDialog(null,"Incorrect username or password");	
		            }
		        }
		        }
				//}

				//System.out.println("Login Succesful!!");
			} catch (SQLException f) {
				// TODO Auto-generated catch block
				System.out.println("Error");
				JOptionPane.showMessageDialog(null,"Connection Error");
			}
			        
			/*
			
			*/
		}};

	loginButton.addActionListener(loginButtonListener);
	
	
	
	
	/*Register button action listener
	 * Opens the registration page
	 * 
	 */
	ActionListener registerButtonListener = new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e){

			        

			RegisterPage f=new RegisterPage();
			f.main();
			frame.dispose();}

		};

		registerButton.addActionListener(registerButtonListener);
}


	
	
	
	public static void main(String[] args){
		frame = new JFrame("Shopping Cart");
		frame.setSize(350,150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		
		}

}
