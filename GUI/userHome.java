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
/*
 * This class is a GUI interface for a new user after they register their account.
 */
public class userHome extends JFrame {

	private static final long serialVersionUID = 1L;
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
					userHome window = new userHome();
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
	public userHome() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1016, 667);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setColumns(10);
		textField.setBounds(112, 140, 463, 28);
		contentPane.add(textField);
		
							
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(93, 319, 862, 285);
	    contentPane.add(scrollPane);
	    
	    table = new JTable();
	    scrollPane.setViewportView(table);
	    DefaultTableModel model = (DefaultTableModel)table.getModel();	
	 
	    JButton transactionButton = new JButton("Show Transaction");
	    transactionButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		transactionButton.setForeground(Color.BLACK);
		transactionButton.setBackground(new Color(0, 128, 0));
		transactionButton.setBounds(413, 268, 273, 31);
	    contentPane.add(transactionButton);
		transactionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration r = new Registration ();
				String userName = Registration.getUserName();
				model.getDataVector().removeAllElements();
				transactionLogic.showTransaction(userName, model);
			}
		});
		
	    
	    JLabel balanceLabel = new JLabel("Balance = ");
	    balanceLabel.setOpaque(true);
	    balanceLabel.setForeground(new Color(0, 0, 0));
	    balanceLabel.setBackground(new Color(128, 255, 0));
	    balanceLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    balanceLabel.setBounds(112, 80, 454, 36);
	    contentPane.add(balanceLabel);
	    
	    JButton balanceButton = new JButton("Your Balance");
		balanceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		balanceButton.setBackground(new Color(0, 128, 0));
		balanceButton.setForeground(new Color(0, 0, 0));
		balanceButton.setBounds(603, 83, 175, 31);
		contentPane.add(balanceButton);
		balanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = Registration.getUserName();
				balance = transactionLogic.showBalance(userName);
				balanceLabel.setText("Your BALANCE   ----   ");
				balanceLabel.setText(balanceLabel.getText() + " " + balance + " USD");
			}
		});
	    
	   	    
	    JButton withdraw = new JButton("WITHDRAW");
		withdraw.setForeground(Color.BLACK);
		withdraw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		withdraw.setBackground(new Color(255, 0, 0));
		withdraw.setBounds(389, 208, 186, 31);
	    contentPane.add(withdraw);
	    withdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				double num = 0.0;
				String userName = Registration.getUserName();

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
	    
	    JButton addBalanceButton = new JButton("Add Balance");
		addBalanceButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addBalanceButton.setForeground(Color.BLACK);
		addBalanceButton.setBackground(new Color(0, 128, 0));
		addBalanceButton.setBounds(112, 208, 186, 31);
		contentPane.add(addBalanceButton);
		
		addBalanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = textField.getText();
				double num = 0.0;
				String userName = Registration.getUserName();
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
		
	}		
}
