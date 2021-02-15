package eg.edu.alexu.csd.oop.calculator.cs21;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;


public class Calc {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JButton button_2;
	private JButton button_3;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton btnNewButton;
	private JButton button_13;
	private JButton button_14;
	private JButton DEL;

	String s="";
	private JButton btnP;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnCurrent;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
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
	public Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		operating d=new operating();
		
		frame = new JFrame();
		frame.getContentPane().setFocusCycleRoot(true);
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.getContentPane().setEnabled(false);
		frame.setResizable(false);
		frame.setBounds(100, 100, 316, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setBackground(new Color(255, 255, 255));
		t1.setDisabledTextColor(new Color(0, 0, 0));
		t1.setEnabled(false);
		t1.setBounds(34, 41, 192, 30);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setDisabledTextColor(new Color(0, 0, 0));
		t2.setEnabled(false);
		t2.setBounds(45, 22, 172, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		DEL = new JButton("del");
		DEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.isEmpty()) {
					s=s.substring(0, s.length()-1);
					t1.setText(s);}
			}
		});
		DEL.setBounds(34, 90, 51, 28);
		frame.getContentPane().add(DEL);
		
		JButton button = new JButton("/");
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(!s.isEmpty()) {
					s+=e.getActionCommand();
					t1.setText(s);
				}
			}
		});
		button.setBounds(95, 90, 51, 28);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("*");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.isEmpty()) {
					s+=e.getActionCommand();
					t1.setText(s);
				}
			}
		});
		button_1.setBounds(156, 90, 51, 28);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("7");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_2.setBounds(34, 129, 51, 28);
		frame.getContentPane().add(button_2);
		
		button_3 = new JButton("8");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_3.setBounds(95, 129, 51, 28);
		frame.getContentPane().add(button_3);
		
		button_4 = new JButton("9");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_4.setBounds(156, 129, 51, 28);
		frame.getContentPane().add(button_4);
		
		button_5 = new JButton("4");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_5.setBounds(34, 168, 51, 28);
		frame.getContentPane().add(button_5);
		
		button_6 = new JButton("5");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_6.setBounds(95, 168, 51, 28);
		frame.getContentPane().add(button_6);
		
		button_7 = new JButton("6");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_7.setBounds(156, 168, 51, 28);
		frame.getContentPane().add(button_7);
		
		button_8 = new JButton("1");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_8.setBounds(34, 207, 51, 28);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("3");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_9.setBounds(156, 207, 51, 28);
		frame.getContentPane().add(button_9);
		
		button_10 = new JButton("2");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_10.setBounds(95, 207, 51, 28);
		frame.getContentPane().add(button_10);
		
		button_11 = new JButton("0");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_11.setBounds(34, 246, 112, 28);
		frame.getContentPane().add(button_11);
		
		button_12 = new JButton(".");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_12.setBounds(156, 246, 51, 28);
		frame.getContentPane().add(button_12);
		
		btnNewButton = new JButton("=");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.isEmpty()) {
					System.out.println("here");
					d.input(s);
					String ans=d.getResult();
					t1.setText(ans);
					t2.setText(s);
					s="";
				}
			}
		});
		btnNewButton.setBounds(217, 207, 51, 65);
		frame.getContentPane().add(btnNewButton);
		
		button_13 = new JButton("+");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!s.isEmpty()) {
					s+=e.getActionCommand();
					t1.setText(s);
				}
			}
		});
		button_13.setBounds(217, 129, 51, 65);
		frame.getContentPane().add(button_13);
		
		button_14 = new JButton("-");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s+=e.getActionCommand();
				t1.setText(s);
			}
		});
		button_14.setBounds(217, 90, 51, 28);
		frame.getContentPane().add(button_14);
		
		JButton btnN = new JButton("P");
		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String prev=d.prev();
				if(!prev.equals("Error: No Prev")) {
					t2.setText(prev);
					t1.setText(d.ansNum);
					s=prev;
				}else {
					t1.setText(prev);
					s="";
				}
				
			}
		});
		btnN.setBounds(226, 41, 42, 15);
		frame.getContentPane().add(btnN);
		
		btnP = new JButton("N");
		btnP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String next=d.next();
				if(!next.equals("Error: No Next")) {
					t2.setText(next);
					t1.setText(d.ansNum);
					s=next;
				}else {
					t1.setText(next);
					s="";
				}
				
			}
		});
		btnP.setBounds(226, 56, 42, 15);
		frame.getContentPane().add(btnP);
		
		btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("saved");
				d.save();
			}
		});
		btnSave.setBounds(34, 281, 74, 23);
		frame.getContentPane().add(btnSave);
		
		btnLoad = new JButton("load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t1.setText("Loaded");
				d.load();
			}
		});
		btnLoad.setBounds(114, 281, 74, 23);
		frame.getContentPane().add(btnLoad);
		
		btnCurrent = new JButton("current");
		btnCurrent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ans=d.current();
				if(ans.equals("Error: you didn't insert antthing")) {
					t1.setText(ans);
				}else {
					t2.setText(ans);
					t1.setText(d.ansNum);
					s=d.ansNum;
				}
				
			}
		});
		btnCurrent.setBounds(194, 281, 74, 23);
		frame.getContentPane().add(btnCurrent);
	}
}
