package LoginPage;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;

import personnel_frame.personnel_table;
import rulebook_frame.rulebook;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import student_frame.student_table;

import java.awt.SystemColor;

public class dashboard {
	
	
	JFrame frame;
	student_table studframe;
	personnel_table perframe;
	rulebook rule;
	JDesktopPane desktopPane;
	private String fname;
	private String lname;
	private String user;
	private String pass;

	public dashboard(String fname, String lname, String user, String pass) {
		initialize();
		this.fname = fname;
		this.lname = lname;
		this.user = user;
		this.pass = pass;
		studentFrame();
		
	}

	

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 105, 1200, 10);
		panel_1.setBackground(Color.YELLOW);
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 112, 1200, 588);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(35, 8, 113));
		panel_3.setBounds(0, 0, 257, 588);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setVisible(true);
		panel_4.setBackground(new Color(255, 255, 102));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setVisible(false);
		panel_4_1.setBackground(new Color(255, 255, 102));
		
		JPanel panel_4_3 = new JPanel();
		panel_4_3.setVisible(false);
		panel_4_3.setBackground(new Color(255, 255, 102));
		
		JButton students_menu = new JButton("        Students");
		students_menu.setForeground(new Color(255, 255, 255));
		students_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				students_menu.setBackground(Color.gray);
				students_menu.setForeground(Color.white);
				Image stud_img = new ImageIcon(this.getClass().getResource("/icons8-student-35.png")).getImage();
				students_menu.setIcon(new ImageIcon(stud_img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				students_menu.setBackground(new Color(35,8,113));
				students_menu.setForeground(Color.white);
				Image stud_img = new ImageIcon(this.getClass().getResource("/icons8-student-35.png")).getImage();
				students_menu.setIcon(new ImageIcon(stud_img));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(students_menu.isVisible() == true) {
						panel_4.setVisible(true);
						panel_4_1.setVisible(false);
						panel_4_3.setVisible(false);
					}
					studentFrame();
				} catch (Exception ex) {
					System.err.print(ex.toString());
				}
			}
		});
		students_menu.setHorizontalTextPosition(SwingConstants.RIGHT);
		students_menu.setHorizontalAlignment(SwingConstants.LEFT);
		students_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		students_menu.setFocusTraversalPolicyProvider(true);
		students_menu.setFocusCycleRoot(true);
		students_menu.setFocusable(false);
		students_menu.setBackground(new Color(35, 8, 113));
		students_menu.setBorder(null);
		students_menu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		Image stud_img = new ImageIcon(this.getClass().getResource("/icons8-student-35.png")).getImage();
		students_menu.setIcon(new ImageIcon(stud_img));
		
		
		JButton log_menu = new JButton("        Logbook");
		log_menu.setForeground(new Color(255, 255, 255));
		log_menu.setHorizontalTextPosition(SwingConstants.RIGHT);
		log_menu.setHorizontalAlignment(SwingConstants.LEFT);
		log_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		log_menu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		log_menu.setBackground(new Color(35, 8, 113));
		log_menu.setBorder(null);
		log_menu.setFocusable(false);
		Image log_img = new ImageIcon(this.getClass().getResource("/icons8-logbook-35.png")).getImage();
		log_menu.setIcon(new ImageIcon(log_img));
		log_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				log_menu.setBackground(Color.gray);
				log_menu.setForeground(Color.white);
				Image log_img = new ImageIcon(this.getClass().getResource("/icons8-logbook-35.png")).getImage();
				log_menu.setIcon(new ImageIcon(log_img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				log_menu.setBackground(new Color(35,8,113));
				log_menu.setForeground(Color.white);
				Image log_img = new ImageIcon(this.getClass().getResource("/icons8-logbook-35.png")).getImage();
				log_menu.setIcon(new ImageIcon(log_img));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(log_menu.isVisible() == true) {
						panel_4.setVisible(false);
						panel_4_1.setVisible(true);
						panel_4_3.setVisible(false);
					}
					rulebookFrame();
				} catch (Exception ex) {
					System.err.print(ex.toString());
				}
			}
		});
		
		JButton personnel_menu = new JButton("       Personnel");
		personnel_menu.setForeground(new Color(255, 255, 255));
		personnel_menu.setHorizontalTextPosition(SwingConstants.RIGHT);
		personnel_menu.setHorizontalAlignment(SwingConstants.LEFT);
		personnel_menu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		personnel_menu.setFont(new Font("Segoe UI", Font.BOLD, 17));
		personnel_menu.setBackground(new Color(35, 8, 113));	
		personnel_menu.setBorder(null);
		personnel_menu.setFocusable(false);
		Image personnel_img = new ImageIcon(this.getClass().getResource("/icons8-staff-35.png")).getImage();
		personnel_menu.setIcon(new ImageIcon(personnel_img));
		personnel_menu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				personnel_menu.setBackground(Color.gray);
				personnel_menu.setForeground(Color.white);
				Image personnel_img = new ImageIcon(this.getClass().getResource("/icons8-staff-35.png")).getImage();
				personnel_menu.setIcon(new ImageIcon(personnel_img));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				personnel_menu.setBackground(new Color(35,8,113));
				personnel_menu.setForeground(Color.white);
				Image personnel_img = new ImageIcon(this.getClass().getResource("/icons8-staff-35.png")).getImage();
				personnel_menu.setIcon(new ImageIcon(personnel_img));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if(personnel_menu.isVisible() == true) {
						panel_4.setVisible(false);
						panel_4_1.setVisible(false);
						panel_4_3.setVisible(true);
					}
					personnelFrame();
				} catch (Exception ex) {
					System.err.print(ex.toString());
				}
			}
		});
		Image dbimg = new ImageIcon(this.getClass().getResource("/icons8-dashboard-35.png")).getImage();
		
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(students_menu, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel_3.createSequentialGroup()
								.addComponent(log_menu, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
								.addGap(10)
								.addComponent(panel_4_1, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(personnel_menu, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(panel_4_3, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(204)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(students_menu, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(log_menu, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addComponent(personnel_menu, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(227, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBounds(256, 0, 944, 588);
		
		panel_2.add(desktopPane);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1200, 106);
		panel.setBackground(new Color(35, 8, 113));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 100, 100);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/NU_logo-removebg-preview (1) (1).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_1 = new JLabel("NU DO");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblNewLabel_1.setBounds(109, 36, 119, 32);
		panel.add(lblNewLabel_1);	
		
		JButton btnNewButton = new JButton("Hi, Admin!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setHorizontalTextPosition(SwingConstants.LEFT);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFocusable(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 21));
		btnNewButton.setBackground(new Color(35, 8, 113));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(993, 39, 161, 29);
		Image imgg = new ImageIcon(this.getClass().getResource("/icons8-down-arrow-35.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(imgg));
		panel.add(btnNewButton);
	}
	
	void studentFrame() {
		if (studframe == null || studframe.isVisible()) {
			studframe = new student_table(fname,lname,user,pass);		
			studframe.setBounds(0,0,944,588);
			desktopPane.add(studframe);
			studframe.show();
		}
	}

	void personnelFrame() {
		if (perframe == null || perframe.isVisible()) {
			this.perframe = new personnel_table();
			perframe.setBounds(0,0,944,588);
			desktopPane.add(perframe);
			perframe.show();
		}
	}
	
	void rulebookFrame() {
		if (rule == null || rule.isVisible()) {
			this.rule = new rulebook();
			rule.setBounds(0,0,944,588);
			desktopPane.add(rule);
			rule.show();
		}
	}
}
