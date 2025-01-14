package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class userHomePage extends JFrame {

	private JFrame frame;
	private JTextField BalanceTextField;
	private JTextField textField;
	private JTable table;
	private JPanel contentPane;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userHomePage window = new userHomePage();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userHomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BalanceTextField = new JTextField();
		BalanceTextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BalanceTextField.setBounds(107, 25, 454, 28);
		contentPane.add(BalanceTextField);
		BalanceTextField.setColumns(10);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(107, 85, 454, 28);
		contentPane.add(textField);
		
		JButton balanceButton = new JButton("Your Balance");
		balanceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		balanceButton.setBackground(new Color(0, 128, 0));
		balanceButton.setForeground(new Color(0, 0, 0));
		balanceButton.setBounds(618, 24, 175, 31);
		contentPane.add(balanceButton);
		
		JButton addBalanceButton = new JButton("Add Balance");
		addBalanceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addBalanceButton.setForeground(Color.BLACK);
		addBalanceButton.setBackground(new Color(0, 128, 0));
		addBalanceButton.setBounds(107, 132, 186, 31);
		contentPane.add(addBalanceButton);
		
		JButton transactionButton = new JButton("Show Transaction");
		transactionButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		transactionButton.setForeground(Color.BLACK);
		transactionButton.setBackground(new Color(0, 128, 0));
		transactionButton.setBounds(423, 183, 273, 31);
	    contentPane.add(transactionButton);
		
		
		
		JButton withdraw = new JButton("WITHDRAW");
		withdraw.setForeground(Color.BLACK);
		withdraw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		withdraw.setBackground(new Color(255, 0, 0));
		withdraw.setBounds(375, 132, 186, 31);
	    contentPane.add(withdraw);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(107, 229, 862, 285);
	    contentPane.add(scrollPane);
	    
	    table = new JTable();
	    scrollPane.setViewportView(table);
		
	}

	
}
