import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Inserting_Item {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	String code_i, name_i, brand_i, type_i, price_i, qty_i, rating_i, dom_i, doe_i;
	

	/**
	 * Launch the application.
	 */
	public void runInsert() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inserting_Item window = new Inserting_Item();
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
	public Inserting_Item() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Add New Item");
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(25, 73, 46, 14);
		frame.getContentPane().add(lblBrand);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setBounds(25, 26, 46, 14);
		frame.getContentPane().add(lblCode);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 48, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(25, 98, 46, 14);
		frame.getContentPane().add(lblType);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(25, 119, 46, 14);
		frame.getContentPane().add(lblPrice);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(25, 141, 46, 14);
		frame.getContentPane().add(lblQty);
		
		JLabel lblRating = new JLabel("Rating");
		lblRating.setBounds(25, 166, 46, 14);
		frame.getContentPane().add(lblRating);
		
		JLabel lblDom = new JLabel("DOM");
		lblDom.setBounds(25, 191, 46, 14);
		frame.getContentPane().add(lblDom);
		
		JLabel lblDoe = new JLabel("DOE");
		lblDoe.setBounds(25, 219, 46, 14);
		frame.getContentPane().add(lblDoe);
		
		textField = new JTextField();
		textField.setBounds(92, 216, 138, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 188, 138, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 163, 51, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 138, 51, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(92, 23, 51, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(92, 48, 248, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(92, 95, 248, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(92, 116, 50, 20);
		frame.getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(91, 70, 248, 20);
		frame.getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Get_Item_Information();
				Update_Information();
				frame.setVisible(false);
			}
			
			private void Get_Item_Information() {
				code_i = textField_4.getText();
				name_i = textField_5.getText();
				brand_i = textField_8.getText();
				type_i = textField_6.getText();
				price_i = textField_7.getText();
				qty_i = textField_3.getText();
				rating_i = textField_2.getText();
				dom_i = textField_1.getText();
				doe_i = textField.getText();
				
			}
			
			private void Update_Information() {
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
				    int c;
				    int flag = 0;
				    Statement s = conn.createStatement();
				    ResultSet rs = s.executeQuery("select code from items where code = " + code_i + ";");
				    while(rs.next())
				    {
				    	c = rs.getInt(1);
				    	st.executeUpdate("update items set qty = qty + " + qty_i + " where code = " + code_i + ";");
				    	flag = 1;
				    }
				    if(flag == 0)
				    	st.executeUpdate("INSERT INTO items (code, name, brand, type, price, qty, rating, dom, doe) "+"VALUES('"+code_i+"','"+name_i+"','"+brand_i+"','"+type_i+"','"+price_i+"','"+qty_i+"','"+rating_i+"','"+dom_i+"','"+doe_i+"')");
				               
					st.close();
					conn.close();
					JOptionPane.showMessageDialog(null,"Item details are updated Successfully");
					}
					catch (Exception e) {
					System.out.println("Exception1 is " + e);
					}

			}

			
		});
		btnAdd.setBounds(309, 215, 89, 23);
		frame.getContentPane().add(btnAdd);
	}
}
