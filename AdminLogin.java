import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AdminLogin {

	private JFrame frame;
	private JPasswordField passwordField;
	private JButton btnSubmit;

	/**
	 * Launch the application.
	 */
	public void runAdminLogin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin window = new AdminLogin();
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
	public AdminLogin() {
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 132, 161, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("Please enter verification code :");
		label.setBounds(34, 102, 221, 15);
		frame.getContentPane().add(label);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				String ps = passwordField.getText();
				System.out.println(ps);
				if(ps.equals("admin"))
				{
					System.out.println("Entered");
					Administrator ad = new Administrator();
					ad.runAdministrator();
				}
			}
		});
		btnSubmit.setBounds(167, 174, 117, 25);
		frame.getContentPane().add(btnSubmit);
	}
}
