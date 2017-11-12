import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;


public class Insertpage {

	private JFrame frame;
	private JTextField txtName;
	String cartName;

	/**
	 * Launch the application.
	 */
	public static void runInsert(final long phno) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Insertpage window = new Insertpage(phno);
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
	public Insertpage(long phno) {
		initialize(phno);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final long phno) {
		frame = new JFrame();
		frame.setBounds(100, 100, 584, 328);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblCart = new JLabel("Enter your cart name :");
		frame.getContentPane().add(lblCart, "22, 4");
		
		final JRadioButton rdbtnBiscuits = new JRadioButton("Biscuits");
		frame.getContentPane().add(rdbtnBiscuits, "14, 6");
		
		txtName = new JTextField();
		frame.getContentPane().add(txtName, "22, 6, fill, default");
		txtName.setColumns(10);
		
		final JRadioButton rdbtnTea = new JRadioButton("Tea");
		frame.getContentPane().add(rdbtnTea, "14, 8");
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cartName = txtName.getText();
				try
				{
				Statement st;
				Connection con;
				int c=0, q=0;
				con = DriverManager.getConnection("jdbc:mysql://localhost/Supermarket", "root", "mysql_divya");
				st = con.createStatement();
				long p=0;
				int flag = 0;
				ResultSet r = st.executeQuery(" select phno from cart where cartname = \'" + cartName + "\';");
				while(r.next())
				{
					flag = 1;
					p = r.getLong(1);
				}
				if(flag == 1)
				{
					if(p == phno)
						txtName.setEnabled(false);
					else
					{
						JOptionPane.showMessageDialog(null," Please enter the name of your existing cart or your new cart.");
					}
				}
				else
					txtName.setEnabled(false);
			}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		frame.getContentPane().add(btnSubmit, "22, 8");
		
		final JRadioButton rdbtnShampoo = new JRadioButton("Shampoo");
		frame.getContentPane().add(rdbtnShampoo, "14, 10");
		
		final JRadioButton rdbtnConditioner = new JRadioButton("Conditioner");
		frame.getContentPane().add(rdbtnConditioner, "14, 12");
		
		final JRadioButton rdbtnSoaps = new JRadioButton("Soaps");
		frame.getContentPane().add(rdbtnSoaps, "14, 14");
		
		JButton btnShopNow = new JButton("Shop Now");

		final ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnSoaps);
		bg.add(rdbtnConditioner);
		bg.add(rdbtnShampoo);
		bg.add(rdbtnTea);
		bg.add(rdbtnBiscuits);
		
		btnShopNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cartName == null)
				{
					JOptionPane.showMessageDialog(null," Please enter the name of your cart.");
				}
				else
				{
				if(rdbtnTea.isSelected() == true)
				{
					AddTea at;
					at = new AddTea(phno, cartName);
					at.runAddTea(phno,cartName);	
				}
				if(rdbtnBiscuits.isSelected() == true)
				{
					AddBiscuit bt;
					bt = new AddBiscuit(phno,cartName);
					bt.runAddBiscuit(phno,cartName);	
				}
				if(rdbtnConditioner.isSelected() == true)
				{
					AddConditioner ct;
					ct = new AddConditioner(phno,cartName);
					ct.runAddConditioner(phno,cartName);	
				}
				if(rdbtnShampoo.isSelected() == true)
				{
					AddShampoo st;
					st = new AddShampoo(phno,cartName);
					st.runAddShampoo(phno,cartName);	
				}
				if(rdbtnSoaps.isSelected() == true)
				{
					AddSoap st;
					st = new AddSoap(phno,cartName);
					st.runAddSoap(phno,cartName);	
				}
				}
			}
		});
		frame.getContentPane().add(btnShopNow, "14, 18");
		
		JButton btnBuyNow = new JButton("Buy Now!");
		btnBuyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					Statement st;
					Connection con;
					int c=0, q=0;
					con = DriverManager.getConnection("jdbc:mysql://localhost/Supermarket", "root", "mysql_divya");
					st = con.createStatement();
					float total=0;
					ResultSet r = st.executeQuery(" select sum(qty*price) from cart where cartname = \'" + cartName + "\';");
					while(r.next())
					{
						total = r.getFloat(1);
					}
					System.out.println("reached");
					Statement s = con.createStatement();
					ResultSet rs = st.executeQuery(" select code, qty from cart where cartname = \'"+cartName+"\';");
					while(rs.next())
					{
						c = rs.getInt(1);
						q = rs.getInt(2);
						System.out.println("deleting " + c);
						s.executeUpdate(" update items set qty = qty - "+ q + " where code = " + c + ";");
						System.out.println("done");
					}
					Random rand = new Random();
					int min = rand.nextInt(3) + 1;
					JOptionPane.showMessageDialog(null," Your total bill is : " + total + ". Thank you for shopping with us!");
					st.executeUpdate("insert into payment(total, cname, method, empid) values (" + total + ", \'"+ cartName + "\', 'COD', "+ min + ");");
					//st.executeUpdate("delete from cart where cartname = \'" + cartName + "\';");
					frame.setVisible(false);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		frame.getContentPane().add(btnBuyNow, "22, 18");
		
		
	}

}
