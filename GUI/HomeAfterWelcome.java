package GUI;
/*
 * GUI package is connected to the logic package.
 */
import java.awt.EventQueue;

import javax.swing.*;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Logic.transactionLogic;
	/**
	 * This class is responsible for displaying home page if the user is a returning customer.
	 * This frame opens after the user log in the account.
	 */

public class HomeAfterWelcome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTable table;
	private JPanel contentPane;
	private String balance;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeAfterWelcome window = new HomeAfterWelcome();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeAfterWelcome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 705);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(107, 173, 454, 28);
		contentPane.add(textField);
			
		JButton balanceButton = new JButton("Your Balance");
		balanceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		balanceButton.setBackground(new Color(0, 128, 0));
		balanceButton.setForeground(new Color(0, 0, 0));
		balanceButton.setBounds(627, 105, 175, 31);
		contentPane.add(balanceButton);
		
		JButton addBalanceButton = new JButton("Add Balance");
		addBalanceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addBalanceButton.setForeground(Color.BLACK);
		addBalanceButton.setBackground(new Color(0, 128, 0));
		addBalanceButton.setBounds(112, 238, 186, 31);
		contentPane.add(addBalanceButton);
		
		JLabel nameLabel = new JLabel("Hello, ");
	    nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    nameLabel.setBounds(105, 46, 222, 28);
	    contentPane.add(nameLabel);
	    String userName = welcome.getUserName();
	    nameLabel.setText(nameLabel.getText() + userName);
		
		
		JButton withdraw = new JButton("WITHDRAW");
		withdraw.setForeground(Color.BLACK);
		withdraw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		withdraw.setBackground(new Color(255, 0, 0));
		withdraw.setBounds(375, 238, 186, 31);
	    contentPane.add(withdraw);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(104, 373, 862, 285);
	    contentPane.add(scrollPane);
	    
	    table = new JTable();
	    scrollPane.setViewportView(table);
	    DefaultTableModel model = (DefaultTableModel)table.getModel();	
		    
	    JButton transactionButton = new JButton("Show Transaction");
	    transactionButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		transactionButton.setForeground(Color.BLACK);
		transactionButton.setBackground(new Color(0, 128, 0));
		transactionButton.setBounds(436, 302, 273, 31);
	    contentPane.add(transactionButton);
	    
	    JLabel balanceLabel = new JLabel("Balance = ");
	    balanceLabel.setOpaque(true);
	    balanceLabel.setForeground(new Color(0, 0, 0));
	    balanceLabel.setBackground(new Color(128, 255, 0));
	    balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    balanceLabel.setBounds(107, 102, 454, 36);
	    contentPane.add(balanceLabel);
	    
	    // ActionListeners for Transaction, Balance, Withdraw and Add Balance buttons.
	    
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration r = new Registration ();
				String userName = welcome.getUserName();
				model.getDataVector().removeAllElements();
				transactionLogic.showTransaction(userName, model);
			}
		});
		
	
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String userName = welcome.getUserName();
				balance = transactionLogic.showBalance(userName);
				balanceLabel.setText("Your BALANCE   ----   ");
				balanceLabel.setText(balanceLabel.getText() + " " + balance + " USD");
			}
		});
		
				
		addBalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				double num = 0.0;
				String userName = welcome.getUserName();
					try {
				    num = Double.parseDouble(str);
				   
				} catch (Exception e1) {
				   JOptionPane.showMessageDialog(null,"Please fill a number value.");
				   textField.setText("");
				}
				
				if (num > 0) {
					transactionLogic.addBalance(userName, num);
					JOptionPane.showMessageDialog(null, num + "$ added to your account.");
					model.getDataVector().removeAllElements();
					transactionLogic.showTransaction(userName, model);
					balance= transactionLogic.showBalance(userName);
					balanceLabel.setText("Your BALANCE   ----   ");
					balanceLabel.setText(balanceLabel.getText() + " " + balance + " USD");
				}
			}
		});
		
		
		withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				double num = 0.0;
				String userName = welcome.getUserName();

				try {
				    num = Double.parseDouble(str);
				   
				} catch (Exception e1) {
				   JOptionPane.showMessageDialog(null,"Please fill a number value.");
				   textField.setText("");
				}
				
				if (num > 0) {
					transactionLogic.withdrawlBalance(userName, num);
					model.getDataVector().removeAllElements();
					transactionLogic.showTransaction(userName, model);
					balance=transactionLogic.showBalance(userName);
					balanceLabel.setText("Your BALANCE   ----   ");
					balanceLabel.setText(balanceLabel.getText() + " " + balance + " USD");
					}
			}
			
		});
		
	}
}

	


