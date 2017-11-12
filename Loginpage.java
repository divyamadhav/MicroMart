import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Loginpage {

	private JFrame frame;
	private JTextField Username;
	private JTextField Password;
	private JLabel lblPassword;

	/**
	 * Launch the application.
	 */
	public static void runLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Username = new JTextField();
		Username.setBounds(233, 89, 114, 19);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(54, 89, 121, 19);
		frame.getContentPane().add(lblUsername);
		
		Password = new JTextField();
		Password.setBounds(233, 157, 114, 19);
		frame.getContentPane().add(Password);
		Password.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setBounds(63, 159, 70, 15);
		frame.getContentPane().add(lblPassword);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = Username.getText();
				String pass = " ";
				try
				{
					Connection con;
					long phone=0;
					con = DriverManager.getConnection("jdbc:mysql://localhost/Supermarket", "root", "mysql_divya");
					Statement st;
					st = con.createStatement();
					ResultSet rs = st.executeQuery("select password from customer where email = \'"+user+"\';");
					while(rs.next())
						pass = rs.getString(1);
					String input = Password.getText();
					System.out.println(input);
					System.out.println(pass);
					if(pass.equals(input))
					{
						System.out.println("reached");
						ResultSet r = st.executeQuery("Select phno from customer where email = \'"+user+"\';");
						while(r.next())
							phone = r.getLong(1);
						System.out.println(phone);
						frame.setVisible(false);
						Insertpage ip = new Insertpage(phone);
						ip.runInsert(phone);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnSignIn.setBounds(119, 207, 117, 25);
		frame.getContentPane().add(btnSignIn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(166, 28, 70, 15);
		frame.getContentPane().add(lblNewLabel);
	}
}
