import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Administrator {

	private JFrame frame;
	String choice;

	/**
	 * Launch the application.
	 */
	public void runAdministrator() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator window = new Administrator();
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
	public Administrator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Welom Admin");
		frame.getContentPane().setFont(new Font("Tahoma", Font.ITALIC, 11));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectYourOption = new JLabel("Select Your Option....");
		lblSelectYourOption.setFont(new Font("Tahoma", Font.ITALIC, 12));
		lblSelectYourOption.setBounds(118, 32, 144, 23);
		frame.getContentPane().add(lblSelectYourOption);
		
		ButtonGroup jb = new ButtonGroup();
		
		JRadioButton rdbtnInsert = new JRadioButton("Insert");
		rdbtnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice = "insert";
			}
		});
		rdbtnInsert.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnInsert.setBounds(118, 72, 109, 23);
		frame.getContentPane().add(rdbtnInsert);
		jb.add(rdbtnInsert);
		
		JRadioButton rdbtnDelete = new JRadioButton("Delete");
		rdbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice = "delete";
			}
		});
		rdbtnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnDelete.setBounds(118, 104, 109, 23);
		frame.getContentPane().add(rdbtnDelete);
		jb.add(rdbtnDelete);
		
		JRadioButton rdbtnUpdate = new JRadioButton("Update");
		rdbtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choice = "update";
			}
		});
		rdbtnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnUpdate.setBounds(118, 139, 109, 23);
		frame.getContentPane().add(rdbtnUpdate);
		jb.add(rdbtnUpdate);
		
		
		
		JButton btnClickHere = new JButton("CLICK HERE");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choice== "insert")
				{
					Inserting_Item show_1 = new Inserting_Item();
					show_1.runInsert();
				}
				else if(choice == "delete")
				{
					Deleting_Item show_2 = new Deleting_Item();
					show_2.runDelete();
				}
				else if(choice == "update")
				{
					Updating_Item show_3 = new Updating_Item();
					show_3.runUpdate();
				}
			}
		});
		btnClickHere.setFont(new Font("Times New Roman", Font.ITALIC, 11));
		btnClickHere.setBounds(118, 195, 131, 23);
		frame.getContentPane().add(btnClickHere);
	}
}