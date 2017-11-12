import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddBiscuit
{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void runAddBiscuit(final long phno, final String cartName)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					AddBiscuit window = new AddBiscuit(phno,cartName);
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public AddBiscuit(long phno, String cartName)
	{
		initialize(phno,cartName);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private int getInt(String s)
	{
		if(s == "1")
			return 1;
		else if(s == "2")
			return 2;
		return 1;
	}
	private String getString(int i)
	{
		switch(i)
		{
		case 1 : return("1");
		case 2 : return("2");
		case 3 : return("3");
		case 4 : return("4");
		case 5 : return("5");
		case 6 : return("6");
		case 7 : return("7");
		case 8 : return("8");
		case 9 : return("9");
		case 10 : return("10");
		case 101: return("101");
		case 102: return("102");
		case 103: return("103");
		case 105: return("105");
		case 106: return("106");
		case 108: return("108");
		case 109: return("109");
		}
		return("1");
	}
	private void initialize(final long phno, final String cartName)
	{
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 343);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (ClassNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection con;
		String[] values = new String[4];
		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost/Supermarket", "root", "mysql_divya");
			Statement st;
			st = con.createStatement();
			ResultSet rs = st.executeQuery("select name,brand from items where type='Biscuit'");
			int i=0;
			while(rs.next())  
				values[i++]=rs.getString(2)+" - " +rs.getString(1);
		}
		catch (SQLException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		final JComboBox Products = new JComboBox(values);
		Products.setBounds(73, 83, 268, 34);
		frame.getContentPane().add(Products);
		
		Products.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					int c;
					float f;
					final Statement st;
					final Connection con;
					con = DriverManager.getConnection("jdbc:mysql://localhost/Supermarket", "root", "mysql_divya");
					st = con.createStatement();
					
					String shampoo = (String) Products.getItemAt(Products.getSelectedIndex());
					final String arr[] = shampoo.split(" - ");
					
					final ResultSet rs = st.executeQuery("select qty,code,price from items where type='Biscuit' and brand = \"" +arr[0]+"\" and name=\""+arr[1]+"\"; ");
					int i=0;
					while(rs.next())
					{
						i = rs.getInt(1);
						c = rs.getInt(2);
						f = rs.getFloat(3);
					}

					final String[] qty = new String[i];
					while(i>0)
					{
						qty[i-1]= Integer.toString(i);
						i--;
					}
					
					final JComboBox Quantity = new JComboBox(qty);
					Quantity.setBounds(359, 83, 69, 34);
					frame.getContentPane().add(Quantity);
					JButton btnBuy = new JButton("Buy!");
					btnBuy.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							try
							{
								final Connection con;
								con = DriverManager.getConnection("jdbc:mysql://localhost/Supermarket", "root", "mysql_divya");
								Statement st;
								int code=0;
								float price=0;
								st = con.createStatement();
								
								ResultSet rs = st.executeQuery("select code, price from items where type='Biscuit' and brand = \""+arr[0]+"\" and name = \""+arr[1]+"\";");
								while(rs.next())
								{
									code = rs.getInt(1);
									price = rs.getFloat(2);
								}
								System.out.println("COde is : "+ code);
								int q=0;
								String Q = (String) Quantity.getItemAt(Quantity.getSelectedIndex());
								System.out.println(Q);
								q = Integer.parseInt(Q);
								System.out.println("Quantity is "+ q);
								//if exists, add qty
								ResultSet r = st.executeQuery("select code from cart where code = " + code + " and cartname = \'" + cartName + "\';");
								int flag = 0;
								while(r.next())
								{
									flag = 1;
									st.executeUpdate("update cart set qty = "+ getString(q) +" where code = " + code + " and cartname = \'" + cartName + " \';");
									frame.setVisible(false);
									break;
								}
								if(flag == 0)
								{
									st.executeUpdate("insert into cart values (\'" + cartName+ "\',"+phno+","+code+","+getString(q)+","+price+");");
									frame.setVisible(false);
								}
							}
							catch (SQLException e1)
							{
								e1.printStackTrace();
							}
						}
					});
					btnBuy.setBounds(462, 88, 117, 25);
					frame.getContentPane().add(btnBuy);

				}
				catch (SQLException e1)
				{
					e1.printStackTrace();
				}
			}
		});

		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(369, 46, 37, 25);
		frame.getContentPane().add(lblQty);
		
		JLabel lblProduct = new JLabel("Product");
		lblProduct.setBounds(162, 46, 69, 25);
		frame.getContentPane().add(lblProduct);
	}
}
