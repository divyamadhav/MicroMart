


import java.awt.EventQueue;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class Bill {

	private JFrame frame;
	String enter_as;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill window = new Bill();
					window.frame.setVisible(true);
					System.out.println("hello");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bill() {
		System.out.println("hello");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
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
				FormFactory.DEFAULT_COLSPEC,},
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC
				
				}));
		
		JLabel lblLoginAs = new JLabel("Login As");
		lblLoginAs.setFont(new Font("Times New Roman", Font.BOLD, 15));
		frame.getContentPane().add(lblLoginAs, "14, 6");
		
		ButtonGroup jb = new ButtonGroup();
		
		
		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enter_as = "Admin";
			}
		});
		frame.getContentPane().add(rdbtnAdmin, "10, 12");
		jb.add(rdbtnAdmin);
		
		
		JRadioButton rdbtnCustomer = new JRadioButton("Customer");
		rdbtnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enter_as = "Customer";
			}
		});
		frame.getContentPane().add(rdbtnCustomer, "20, 12");
		jb.add(rdbtnCustomer);
		
				
				final JButton btnClickHere = new JButton("Click here");
				btnClickHere.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(enter_as == "Admin")
						{
							AdminLogin al = new AdminLogin();
							al.runAdminLogin();
						}
						if(enter_as == "Customer")
						{
							
							Choice c = new Choice();
							c.runChoice();
							
						}
					}
				});
				frame.getContentPane().add(btnClickHere, "14, 16");
	}
}