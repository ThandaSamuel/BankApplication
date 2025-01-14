package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Logic.adminLogic;
import javax.swing.*;
import java.awt.Font;
/*
 * AdminPage is responsible for admin page displaying accounts information.
 * It is opened by using admin name and password.
 */

public class AdminPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable allClients;
	private JTextField userTextField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPage window = new AdminPage();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 853, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 103, 816, 394);
		contentPane.add(scrollPane);
		
		allClients = new JTable();
		scrollPane.setViewportView(allClients);
		DefaultTableModel model = (DefaultTableModel)allClients.getModel();	
			
		JButton Accounts = new JButton("Log In");
		Accounts.setFont(new Font("Tahoma", Font.BOLD, 17));
		Accounts.setBounds(377, 59, 196, 21);
		contentPane.add(Accounts);
		
		JLabel adminLabel = new JLabel("Admin User");
		adminLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adminLabel.setBounds(56, 21, 122, 13);
		contentPane.add(adminLabel);
		
		userTextField = new JTextField();
		userTextField.setBounds(188, 18, 136, 19);
		userTextField.setColumns(10);
		contentPane.add(userTextField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passwordLabel.setBounds(56, 61, 113, 13);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(188, 60, 136, 19);
		contentPane.add(passwordField);
		
		JLabel displayLabel = new JLabel("To display accounts, please log in.");
		displayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		displayLabel.setBounds(377, 24, 266, 13);
		contentPane.add(displayLabel);
		
		Accounts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if ((userTextField.getText().equals("admin") && (passwordField.getText().equals("1234")))) {
					model.getDataVector().removeAllElements();
					adminLogic.showTable(model);				
				}
				else {
					JOptionPane.showMessageDialog(null,"Wrong admin user and password.");
					userTextField.setText("");
					passwordField.setText("");
				}
				
			}
		});
		
	}
}

