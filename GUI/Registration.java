package GUI;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import Database.ClientDB;
import Logic.RegistrationLogic;


public class Registration extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private static JTextField textFieldUserName;
	private JPasswordField passwordField;
	private JButton ButtonRegister;
	static String userName ;

	/**
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LabelName = new JLabel("NAME");
		LabelName.setFont(new Font("Tahoma", Font.BOLD, 17));
		LabelName.setBounds(84, 70, 92, 67);
		contentPane.add(LabelName);
		
		JLabel lblNewLabel = new JLabel("Please fill the followings.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(60, 10, 315, 44);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(194, 86, 181, 50);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		ButtonRegister = new JButton("REGISTER");
		ButtonRegister.setBackground(new Color(51, 204, 102));
		ButtonRegister.setFont(new Font("Tahoma", Font.BOLD, 17));
		ButtonRegister.setBounds(145, 444, 315, 55);
		contentPane.add(ButtonRegister);
		
		ButtonRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrationAction();
			    userName = textFieldUserName.getText();
			   getUserName();
			   	}
		});
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEmail.setBounds(84, 142, 92, 67);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(194, 149, 181, 50);
		contentPane.add(textFieldEmail);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUserName.setBounds(84, 219, 92, 67);
		contentPane.add(lblUserName);
		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(84, 302, 92, 67);
		contentPane.add(lblPassword);
		
		textFieldUserName = new JTextField();
		textFieldUserName.setColumns(10);
		textFieldUserName.setBounds(194, 234, 181, 50);
		contentPane.add(textFieldUserName);
			
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(194, 319, 181, 40);
		contentPane.add(passwordField);
		
		
	}
	
		
	public void RegistrationAction () {

		String name = textFieldName.getText();
		String userName = textFieldUserName.getText();
		String email = textFieldEmail.getText();				 
		String password = passwordField.getText();
		if (areAllInputsFilled(textFieldName,textFieldUserName,textFieldEmail,passwordField)) {
			if (RegistrationLogic.valideIfUserExists(userName)==false) {
			   RegistrationLogic.initializeBalance(userName, 0.0, 0.0,0.0);
			   userHome homePage = new userHome();
			   homePage.setVisible(true);
			   RegistrationLogic.insertCustomerData(userName, password, name, email);
		     }
			else {
				JOptionPane.showMessageDialog(null, "The account with the same user name is already registered.");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
		}
	   
	     }

	public static String getUserName() {
			return userName;
	}
	
	 public static boolean areAllInputsFilled(JTextField... textFields) {
	        for (JTextField textField : textFields) {
	            if (textField.getText().isEmpty()) {
	                return false;
	            }
	        }
	        return true;
	    }

}


