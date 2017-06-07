package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
///Test
public class RegisterPage {
	static JFrame frame;
	static String url = "jdbc:mysql://rds-mysql-10mintutorial.c2mpgzjscjnj.us-east-1.rds.amazonaws.com:3306/javabase";
	static String username = "oscar5273";
	static String password = "Server1720";



	
	private boolean checkUsernameAvailability(String Susername){
		boolean available=true;
		
	
		return available;
	}
	
	
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
		
		JLabel fNameLabel= new JLabel("First Name");
		fNameLabel.setBounds(10,70,80,25);
		panel.add(fNameLabel);
		
		JTextField fNameText = new JTextField(20);
		fNameText.setBounds(100,70,160,25);
		panel.add(fNameText);
		
		JLabel lNameLabel= new JLabel("Last Name");
		lNameLabel.setBounds(10,100,80,25);
		panel.add(lNameLabel);
		
		JTextField lNameText = new JTextField(20);
		lNameText.setBounds(100,100,160,25);
		panel.add(lNameText);
		
		JLabel addressLabel= new JLabel("Address");
		addressLabel.setBounds(10,130,80,25);
		panel.add(addressLabel);
		
		JTextField addressText = new JTextField(20);
		addressText.setBounds(100,130,160,25);
		panel.add(addressText);
		
		JLabel ccardLabel= new JLabel("Credit Card");
		ccardLabel.setBounds(10,160,80,25);
		panel.add(ccardLabel);
		
		JTextField ccardText = new JTextField(20);
		ccardText.setBounds(100,160,160,25);
		panel.add(ccardText);

		
		JButton registerButton= new JButton("Register");
		registerButton.setBounds(130,190,85,25);
		panel.add(registerButton);
		
		


		
		/*Register button action listener
		 * Opens the registration page
		 * 
		 */
		ActionListener registerButtonListener = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){

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
				
				String fname=fNameText.getText();
				String lname=lNameText.getText();
				String address=addressText.getText();
				int ccard=Integer.parseInt(ccardText.getText());
				String uname=userText.getText();
				Statement stmt = null;
			    String query = "select *" +
		                   "from " + "javabase" + ".shoppingcart where username=\""+uname+"\"";
		        try {
					stmt = con.createStatement();
					
					ResultSet rs = stmt.executeQuery(query);

					if(rs.next()==false){
						System.out.println("Here");
		            	JOptionPane.showMessageDialog(null,"Account Created!");
		            	//query = "insert into shoppingcart (username,firstname,lastname,address,ccard,password) values(\"" +
				          //        uname+"\"\""+",\"\""+fname+",\"\""+lname+",\"\""+address+",\"\""+ccard+",\""+pw_hash+")";
		            	query = "insert into javabase.shoppingcart (username,firstname,lastname,address,ccard,password) values(\""+uname+"\",\""+
				          fname+"\",\""+lname+"\",\""+address+"\","+ccard+",\""+pw_hash+"\")";
		            	//stmt = con.createStatement();
		            	
						
						stmt.executeUpdate(query);
					}
					else{
						JOptionPane.showMessageDialog(null,"Username is already taken, please try another one");
			        }
				} catch (SQLException f) {
					// TODO Auto-generated catch block
					System.out.println("Error");
					JOptionPane.showMessageDialog(null,"Connection Error");
					f.printStackTrace();
				}
				        
				/*
				if(userText.getText().equals("buyer1") && checkPassword(passwordText.getPassword())==true){
				MainPage f=new MainPage();
				x[0]="b";
				f.main(x);
				frame.dispose();}
				else if(userText.getText().equals("seller1") && checkPassword(passwordText.getPassword())==true){
				MainPage f=new MainPage();
				x[0]="s";
				f.main(x);
				frame.dispose();}
				else{

					JOptionPane.showMessageDialog(null,"Incorrect username or password");
				}*/
			}};

			registerButton.addActionListener(registerButtonListener);
	}
	
	public static void main() {
		// TODO Auto-generated method stub
		frame = new JFrame("Register");
		frame.setSize(350,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
