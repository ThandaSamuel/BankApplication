package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Logic.LogIn;
/*
 * This class the first GUI of the application.
 * The returning user can sign in the account. 
 * The admin can sign in.
 * The new user can register a new account.
 */

public class welcome extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private JButton ButtonSignIn;
	private JButton ButtonRegister;
	private static welcome frame = new welcome();
	private static String userName;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new welcome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public welcome() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBackground(new Color(240, 240, 240));
		setTitle("MY BANK APPLICATION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1107, 447);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelWelcome = new JLabel("WELCOME");
		LabelWelcome.setBounds(523, 10, 261, 61);
		LabelWelcome.setFont(new Font("Tahoma", Font.BOLD, 50));
		contentPane.add(LabelWelcome);
		
		JLabel LabelName = new JLabel("User :");
		LabelName.setBounds(394, 145, 102, 21);
		LabelName.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(LabelName);
		
		JLabel LabelPassword = new JLabel("Password :");
		LabelPassword.setBounds(397, 202, 116, 21);
		LabelPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		contentPane.add(LabelPassword);
		
		userField = new JTextField();
		userField.setBounds(523, 143, 119, 29);
		contentPane.add(userField);
		userField.setColumns(10);
				
		ButtonSignIn = new JButton("Sign In");
		ButtonSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[]passwordChars = passwordField.getPassword();
				String passwordString = new String(passwordChars);
				  userName = userField.getText();
				  getUserName();
					
				if (LogIn.validateLogin(userName, passwordString)==true) {
					JOptionPane.showMessageDialog(null,"Successful");
				     HomeAfterWelcome user = new HomeAfterWelcome();
				     user.setVisible(true);}
				else
					JOptionPane.showMessageDialog(null,"Not Successful");
			}
		});
		ButtonSignIn.setBounds(526, 294, 116, 28);
		ButtonSignIn.setBackground(new Color(0, 204, 51));
		ButtonSignIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(ButtonSignIn);
		
		ButtonRegister= new JButton("REGISTER");
		ButtonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration window = new Registration ();
				window.setVisible(true);
			
			}
		});
		ButtonRegister.setBounds(83, 165, 159, 29);
		ButtonRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		contentPane.add(ButtonRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(523, 200, 119, 29);
		contentPane.add(passwordField);
		
		JButton admin = new JButton("Go To Admin Page");
		admin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPage admin = new AdminPage();
				admin.setVisible(true);
			}
		});
		admin.setFont(new Font("Tahoma", Font.BOLD, 10));
		admin.setBounds(93, 300, 149, 22);
		contentPane.add(admin);
	}
	
	public static String getUserName() {
		return userName;
	}
}

