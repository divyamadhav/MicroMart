import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Deleting_Item {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String item_code, quantity;

	/**
	 * Launch the application.
	 */
	public void runDelete() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleting_Item window = new Deleting_Item();
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
	public Deleting_Item() {
		initialize();
	}

	int getInt(String s)
	{
		switch(s)
		{
		case "0" : return 0;
		case "1" : return 1;
		case "2" : return 2;
		case "3" : return 3;
		case "4" : return 4;
		case "5" : return 5;
		case "6" : return 6;
		case "7" : return 7;
		case "8" : return 8;
		case "9" : return 9;
		case "10" : return 10;
		}
		return 0;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Delete Section");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(43, 66, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblItemCode = new JLabel("Item Code");
		lblItemCode.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblItemCode.setBounds(53, 91, 148, 28);
		frame.getContentPane().add(lblItemCode);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantity.setBounds(53, 146, 89, 14);
		frame.getContentPane().add(lblQuantity);
		
		textField = new JTextField();
		textField.setBounds(172, 97, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(172, 145, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Get_Item();
				
				String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			    String DB_URL = "jdbc:mysql://localhost/Supermarket";
			    String USER = "root" ;
			    String PASS = "mysql_divya";
			    Connection conn = null;
			    //Class.forName("com.mysql.jdbc.Driver");
			    System.out.println("Connecting to a selected database...");
			    try
			    {
			    	int q=0;
			    	conn = DriverManager.getConnection(DB_URL, USER, PASS);
			    	Statement st = conn.createStatement();
			    	ResultSet rs = st.executeQuery("select qty from items where code = " + item_code + " ;");
			    	while(rs.next())
			    	{
			    		q = rs.getInt(1);			    	
			    		System.out.println(q);
			    	}
			    	System.out.println("hello");
			    	System.out.println(quantity);
			    	if(q > getInt(quantity))
			    	{
			    		System.out.println("reached");
			    		System.out.println("reached");
			    		st.executeUpdate("update items set qty = qty - " + quantity + " where code = " + item_code + " ;");
			    	}
			    	else
			    		st.executeUpdate("delete from items where code  = " + item_code + " ;");
			    	System.out.println(" done ");
			    }
			    catch(Exception ep)
			    {
					System.out.println("Exception1 is " + ep);
			    }
				frame.setVisible(false);
			}

			private void Get_Item() {
				item_code = textField.getText();
				quantity = textField_1.getText();
				System.out.println("Good job");
				
				
			}
			
			private void Update_Table() {
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

				    // note that i'm leaving "date_created" out of this insert statement
				    //if(quantity<=items.qty)
				    
				    //st.executeUpdate("DELETE from items where code= "+item_code+" ;");//and qty <= "+quantity+"; ");
				    //if(quantity>items.qty)
				    //items.qty=items.qty-quantity;
					st.close();
					conn.close();
					JOptionPane.showMessageDialog(null,"Item details are updated Successfully");
					}
					catch (Exception e) {
					System.out.println("Exception1 is " + e);
					}
				
			}

			
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(99, 205, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblEnterTheCode = new JLabel("Enter the code of item that you want to delete");
		lblEnterTheCode.setBounds(56, 29, 294, 26);
		frame.getContentPane().add(lblEnterTheCode);
	}

}