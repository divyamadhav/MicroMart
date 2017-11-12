

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Choice {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void runChoice() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Choice window = new Choice();
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
	public Choice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginpage lp = new Loginpage();
				lp.runLogin();
			}
		});
		frame.getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("149px"),
				ColumnSpec.decode("87px"),},
			new RowSpec[] {
				RowSpec.decode("85px"),
				RowSpec.decode("25px"),
				RowSpec.decode("59px"),
				RowSpec.decode("25px"),}));
		frame.getContentPane().add(btnLogin, "2, 2, fill, top");
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegistrationFormDesign form = new RegistrationFormDesign();
			}
		});
		frame.getContentPane().add(btnSignUp, "2, 4, left, top");
	}

}
