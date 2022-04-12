package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField idinputField;
	private JTextField pwinputField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 600, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		 	idinputField = new JTextField();
	      idinputField.setBounds(179, 242, 114, 35);
	      idinputField.setColumns(10);
	      contentPane.add(idinputField);
	      
	      pwinputField = new JTextField();
	      pwinputField.setColumns(10);
	      pwinputField.setBounds(179, 287, 114, 35);
	      contentPane.add(pwinputField);
	      
	      JButton button_1 = new JButton("로그인");
	      button_1.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		
	      		String loginID = idinputField.getText();
	      		String loginPW = pwinputField.getText();
	      		
	      		System.out.println("loginID값 : " + loginID);
	      		System.out.println("loginPW값 : " + loginPW);
	      		
	      		MySQLDB db = new MySQLDB();
	      		int loginResult = db.login(loginID, loginPW);
	      		if(loginResult == 1000) {
	      			LottoFrame lf = new LottoFrame();
	      			lf.setVisible(true);
	      			setVisible(false);
	      			System.out.println("다른 창을 띄워주세요");
	      		} else {
	      			JOptionPane.showMessageDialog(contentPane, "ID나 PW가 틀림", "회원가입 불가", 
	      					JOptionPane.WARNING_MESSAGE);
//	      			System.out.println("경고창을 띄워주세요");
	      		}
	      		
	      		
	      	}
	      });
	      button_1.setBounds(305, 237, 67, 85);
	      contentPane.add(button_1);
	      
	      JButton btnNewButton = new JButton("회원가입");
	      btnNewButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            RegistFrame rf = new RegistFrame();
	            rf.setVisible(true);
	            setVisible(false);
	         }
	      });
	      btnNewButton.setBounds(179, 334, 193, 28);
	      contentPane.add(btnNewButton);
	      
	      JLabel lblNewLabel = new JLabel("로그인");
	      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      lblNewLabel.setBackground(Color.PINK);
	      lblNewLabel.setBounds(179, 157, 193, 68);
	      contentPane.add(lblNewLabel);
		
	}

	
	
	
	
}
