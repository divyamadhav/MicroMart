import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Updating_Item {

	private JFrame frame;
	String query;

	/**
	 * Launch the application.
	 */
	public static void runUpdate() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updating_Item window = new Updating_Item();
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
	public Updating_Item() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Update Section");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(290, 85, -254, 89);
		frame.getContentPane().add(textArea);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(27, 85, 365, 120);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblWriteYourUpdate = new JLabel("Write your update query below:");
		lblWriteYourUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWriteYourUpdate.setBounds(71, 30, 278, 24);
		frame.getContentPane().add(lblWriteYourUpdate);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				get_info();
				update_info();
			}
			
			private void get_info() {
				query = textArea_1.getText();
				
			}

			private void update_info() {
				try {
					String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
				    String DB_URL = "jdbc:mysql://localhost/Supermarket";
				    String USER = "root" ;
				    String PASS = "mysql_divya";
				    Connection conn = null;
				    Class.forName("com.mysql.jdbc.Driver");
				    System.out.println("Connecting to a selected database...");
				    conn = DriverManager.getConnection(DB_URL, USER, PASS);
				    Statement st = conn.createStatement();
				    System.out.println(query);
				    st.executeUpdate(query);
				    
				
					st.close();
					conn.close();
					JOptionPane.showMessageDialog(null,"Item details are updated Successfully");
					}
					catch (Exception e) {
					System.out.println("Exception1 is " + e);
					}
					finally  					
					{/*
					//finally block used to close resources
						try  //try block
						{
							if(conn!=null)//condition
								conn.close(); //close connection
						}
						catch(SQLException se)//Handle errors
						{
							se.printStackTrace();
						}//end finally try
						*/}//end try
				
				
			}

			
		});
		btnUpdate.setBounds(153, 216, 89, 23);
		frame.getContentPane().add(btnUpdate);
	}
}