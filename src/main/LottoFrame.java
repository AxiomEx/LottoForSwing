package main;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class LottoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LottoFrame frame = new LottoFrame();
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
	public LottoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(1500, 1000, 582, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel one = new JLabel("★");
		one.setFont(new Font("Dialog", Font.BOLD, 20));
		one.setHorizontalAlignment(SwingConstants.CENTER);
		one.setBounds(24, 12, 72, 72);
		BevelBorder border=new BevelBorder(BevelBorder.RAISED);
		one.setBorder(border);
		contentPane.add(one);
		
		JLabel two = new JLabel("1");
		two.setFont(new Font("Dialog", Font.BOLD, 20));
		two.setHorizontalAlignment(SwingConstants.CENTER);
		two.setBounds(118, 12, 72, 72);
		two.setBorder(border);
		contentPane.add(two);
		
		JLabel three = new JLabel("등");
		three.setFont(new Font("Dialog", Font.BOLD, 20));
		three.setHorizontalAlignment(SwingConstants.CENTER);
		three.setBounds(212, 12, 72, 72);
		three.setBorder(border);
		contentPane.add(three);
		
		JLabel four = new JLabel("기");
		four.setFont(new Font("Dialog", Font.BOLD, 20));
		four.setHorizontalAlignment(SwingConstants.CENTER);
		four.setBounds(296, 12, 72, 72);
		four.setBorder(border);
		contentPane.add(four);
		
		JLabel five = new JLabel("원");
		five.setFont(new Font("Dialog", Font.BOLD, 20));
		five.setHorizontalAlignment(SwingConstants.CENTER);
		five.setBounds(397, 12, 72, 72);
		five.setBorder(border);
		contentPane.add(five);
		
		JLabel six = new JLabel("★");
		six.setFont(new Font("Dialog", Font.BOLD, 20));
		six.setHorizontalAlignment(SwingConstants.CENTER);
		six.setBounds(482, 12, 72, 72);
		six.setBorder(border);
		contentPane.add(six);
		
		JButton btnNewButton = new JButton("생성하기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Set<Integer> set = new HashSet<Integer>();

		        for (int i = 0; set.size() < 6; ++i) {
		            int num = (int) (Math.random()*45) + 1;
		            set.add((num));
		        }

		        System.out.println("set >>> " + set);

		        List<Integer> list = new ArrayList<Integer>(set);
		        Collections.sort(list);

		         one.setText(Integer.toString(list.get(0)));
		         two.setText(Integer.toString(list.get(1)));
		         three.setText(Integer.toString(list.get(2)));
		         four.setText(Integer.toString(list.get(3)));
		         five.setText(Integer.toString(list.get(4)));
		         six.setText(Integer.toString(list.get(5)));
			}
		});
		
		btnNewButton.setBounds(184, 207, 188, 84);
		contentPane.add(btnNewButton);
		
		
	}
}
