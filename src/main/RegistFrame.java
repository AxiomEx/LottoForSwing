package main;

import java.awt.EventQueue;
import java.awt.Font;
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

public class RegistFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistFrame frame = new RegistFrame();
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
	public RegistFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(2000, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel regLabel = new JLabel("회원가입");
	      regLabel.setFont(new Font("Dialog", Font.BOLD, 30));
	      regLabel.setHorizontalAlignment(SwingConstants.CENTER);
	      regLabel.setBounds(141, 42, 320, 28);
	      contentPane.add(regLabel);
	      
	      JButton rebutton = new JButton("돌아가기");
	      rebutton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            Main main = new Main();
	            main.setVisible(true);
	            setVisible(false);
	         }
	      });
	      rebutton.setBounds(242, 423, 105, 28);
	      contentPane.add(rebutton);
	      
	      textField = new JTextField();
	      textField.setBounds(141, 145, 207, 22);
	      contentPane.add(textField);
	      textField.setColumns(10);
	      
	      textField_1 = new JTextField();
	      textField_1.setBounds(141, 230, 207, 22);
	      contentPane.add(textField_1);
	      textField_1.setColumns(10);
	      
	      textField_2 = new JTextField();
	      textField_2.setBounds(141, 316, 207, 22);
	      contentPane.add(textField_2);
	      textField_2.setColumns(10);
	      
	      JLabel idLabel = new JLabel("아이디");
	      idLabel.setFont(new Font("Dialog", Font.BOLD, 20));
	      idLabel.setBounds(148, 115, 59, 18);
	      contentPane.add(idLabel);
	      
	      JLabel pwLabel = new JLabel("비밀번호");
	      pwLabel.setFont(new Font("Dialog", Font.BOLD, 20));
	      pwLabel.setBounds(148, 200, 107, 18);
	      contentPane.add(pwLabel);
	      
	      JLabel repwLabel = new JLabel("비밀번호확인");
	      repwLabel.setFont(new Font("Dialog", Font.BOLD, 20));
	      repwLabel.setBounds(141, 286, 130, 18);
	      contentPane.add(repwLabel);
	      
	      JButton regButton = new JButton("회원가입");
	      regButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 
	        	 boolean idFix = false;
	        	 boolean pwFix = false;
	        	 
	        	 String id = textField.getText();
	        	 String pw = textField_1.getText();
	        	 String rePw = textField_2.getText();
	        	 
	        	 String resultId = id.trim().replaceAll(" ", "");
	        	 String resultPw = pw.trim().replaceAll(" ", "");
	        	 String resultRePw = rePw.trim().replaceAll(" ", "");
	        	 
	        	 int resIDLen = resultId.length();
	        	 int resPwLen = resultPw.length();
	        	 int resRePwLen = resultRePw.length();
	        	 
	        	 String onlyEng = resultId.replaceAll("^[a-zA-Z0-9]", "");
	        	 
	        	 MySQLDB db1 = new MySQLDB();
	        	 boolean idDuplicate = db1.idDuplicate(onlyEng);
	        	 
	        	 if(idDuplicate == true) {
	        		 textField.setText("");
	        		 textField_1.setText("");
	        		 textField_2.setText("");
	        		 JOptionPane.showMessageDialog(contentPane, "아이디가 중복됩니다.", "회원가입 불가", 
	        				 JOptionPane.WARNING_MESSAGE);
	        	 } else {
	        		 
	        	 }
	        	 
	        	 
	        	 if(onlyEng.length()>0) {
	        		 System.out.println("영어로만");
	        		 System.out.println("DB에 저장될 아이디 : " + onlyEng);
	        		 idFix = true;
	        	 } else {
	        		 System.out.println("영어 말고 적혀있음");
	        		 JOptionPane.showMessageDialog(contentPane, "영어로만 입력하세요", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
	        	 }
	        	 
//	        	 System.out.println(id);
//	        	 System.out.println(pw);
//	        	 System.out.println(rePw);
	        	 
	        	 System.out.println(resultId);
	        	 System.out.println(resultPw);
	        	 System.out.println(resultRePw);
	        	 
	        	 if(resultId.equals("") || resultPw.equals("") || resultRePw.equals("")) {
	        		 JOptionPane.showMessageDialog(contentPane, "안돼 임마", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
	        	 } else {
	        		   if(pw.equals(rePw)) {
		        		 System.out.println("비밀번호가 일치합니다.");
		        		 System.out.println("DB에 들어갈 비밀번호 : " + onlyEng);
		        		 JOptionPane.showMessageDialog(contentPane, id +"님, 어서오세요.", "로그인", JOptionPane.INFORMATION_MESSAGE);
		        		 
		        		 pwFix = true ;
	        		   } else {
		        		 System.out.println("비밀번호가 일치하지 않습니다.");
		        		 JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "회원가입 불가", JOptionPane.WARNING_MESSAGE);
	        		   	}
	        	 }	 
	        	 
	        	 if(idFix == true && pwFix == true || idDuplicate == false) {
	        		 MySQLDB db = new MySQLDB();
	 	            db.insert(onlyEng, pw);
	 	            System.out.println("insert 완료");
	 	            setVisible(false);
		            Main main = new Main();
		            main.setVisible(true);
	        	 }
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
	        	 
//	            String testid = textField.getText();
//	            String testpw = textField_1.getText();
//	            
//	            System.out.println("id 값 : " + testid);
//	            System.out.println("pw 값 : " + testpw);
	            
//	            MySQLDB db = new MySQLDB();
//	            db.insert(testid, testpw);
//	            setVisible(false);
//	            Main main = new Main();
//	            main.setVisible(true);
	         }
	      });
	      
	      regButton.setBounds(242, 373, 105, 28);
	      contentPane.add(regButton);
	      
//	      JButton button = new JButton("테스트버튼");
//	      button.addActionListener(new ActionListener() {
//	         public void actionPerformed(ActionEvent e) {
//	            String testid = textField.getText();
//	            System.out.println(testid);
//	         }
//	      });
//	      button.setBounds(373, 139, 105, 28);
//	      contentPane.add(button);
		
		
	}

}
