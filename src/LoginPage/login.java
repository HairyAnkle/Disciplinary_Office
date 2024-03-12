package LoginPage;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class login {

	private JFrame frame;
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JLabel disable;
	private JTextField admin_fname;
	private JTextField admin_lname;
	private int nudoidCounter = 0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1200, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(1151, 23, 12, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(252, 247, 135));
		panel_1.setBounds(139, 78, 463, 561);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(131, 36, 200, 200);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/NU_logo-removebg.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_5 = new JLabel("Welcome to NU ");
		lblNewLabel_5.setBounds(67, 229, 338, 59);
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 33));
		
		JLabel lblNewLabel_5_1 = new JLabel("Where discpline lies the office's strength");
		lblNewLabel_5_1.setBounds(25, 336, 428, 23);
		lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_5_1.setFont(new Font("SansSerif", Font.ITALIC, 19));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5_2 = new JLabel("Disciplinary Office");
		lblNewLabel_5_2.setBounds(67, 267, 338, 59);
		lblNewLabel_5_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_5_2.setFont(new Font("SansSerif", Font.BOLD, 33));
		panel_1.add(lblNewLabel_5_2);
		panel_1.add(lblNewLabel_5);
		panel_1.add(lblNewLabel_5_1);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(139, 78, 927, 561);
		frame.getContentPane().add(panel);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(35, 8, 113));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(461, Short.MAX_VALUE)
					.addComponent(panel_1_1, GroupLayout.PREFERRED_SIZE, 466, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_1_1, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
		);
		panel_1_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(35, 8, 113));
		panel_2.setBorder(new LineBorder(SystemColor.inactiveCaption, 3));
		panel_2.setBounds(10, 10, 446, 541);
		panel_1_1.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(SystemColor.info, 3));
		panel_3.setBackground(new Color(35, 8, 113));
		panel_3.setBounds(10, 10, 426, 521);
		panel_2.add(panel_3);
		
		JLabel person = new JLabel("");
		person.setBounds(166, 10, 96, 75);
		person.setHorizontalAlignment(SwingConstants.CENTER);
		Image personImg = new ImageIcon(this.getClass().getResource("/icons8-person-75.png")).getImage();
		person.setIcon(new ImageIcon(personImg));
		
		txtUsername = new JTextField();
		txtUsername.setBounds(60, 170, 291, 32);
		txtUsername.setToolTipText("");
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(60, 373, 291, 32);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(60, 144, 68, 20);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setBounds(60, 350, 74, 17);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(355, 170, 45, 32);
		Image person2 = new ImageIcon(this.getClass().getResource("/icons8-person-32.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(person2));
		
		disable = new JLabel("");
		disable.setBounds(355, 373, 47, 32);
		Image eyeimg = new ImageIcon(this.getClass().getResource("/icons9-hide-32.png")).getImage();
		disable.setIcon(new ImageIcon(eyeimg));
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBounds(166, 461, 96, 30);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginButtonActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));	
		panel_3.setLayout(null);
		panel_3.add(lblNewLabel_1_1);
		panel_3.add(person);
		panel_3.add(lblNewLabel_1);
		panel_3.add(txtUsername);
		panel_3.add(lblNewLabel_2);
		panel_3.add(passwordField);
		panel_3.add(disable);
		panel_3.add(btnNewButton);
		
		JCheckBox showPassword = new JCheckBox("Show Password");
		showPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (showPassword.isSelected()) {
					passwordField.setEchoChar((char)0);
				} else {
					passwordField.setEchoChar('*');
				}
			}
		});
		showPassword.setForeground(new Color(255, 255, 255));
		showPassword.setBackground(new Color(35, 8, 113));
		showPassword.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		showPassword.setBounds(60, 413, 131, 32);
		panel_3.add(showPassword);
		
		admin_fname = new JTextField();
		admin_fname.setToolTipText("");
		admin_fname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		admin_fname.setColumns(10);
		admin_fname.setBounds(60, 240, 291, 32);
		panel_3.add(admin_fname);
		
		JLabel lblNewLabel_1_2 = new JLabel("Firstname");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(60, 212, 68, 20);
		panel_3.add(lblNewLabel_1_2);
		
		admin_lname = new JTextField();
		admin_lname.setToolTipText("");
		admin_lname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		admin_lname.setColumns(10);
		admin_lname.setBounds(60, 308, 291, 32);
		panel_3.add(admin_lname);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Lastname");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(60, 282, 68, 20);
		panel_3.add(lblNewLabel_1_2_1);
		panel.setLayout(gl_panel);
		
		
		JLabel background = new JLabel("");
		background.setBounds(0, 0, 1200, 720);
		Image bgimg = new ImageIcon(this.getClass().getResource("/building_NU_Manila_3x2.png")).getImage();
		background.setIcon(new ImageIcon(bgimg));
		frame.getContentPane().add(background);
		
		
	}
	
	public String getUser() {
		return txtUsername.getText().trim();
	}
	
	public String getFname() {
		return admin_fname.getText().trim();
	}
	
	public String getLname() {
		return admin_lname.getText().trim();
	}
	
	@SuppressWarnings("deprecation")
	public String getPass() {
		return passwordField.getText().trim();
	}	
	
	public String generateNUDOID() {
		int nudoidCounter = 0;
        nudoidCounter++;
        String formattedCounter = String.format("%02d", nudoidCounter);
        return "NUDO_" + formattedCounter;
    }
	
	private void LoginButtonActionPerformed(ActionEvent e) {
		String user = getUser();
		String pass = getPass();
		
		if (user.equals("admin") && pass.equals("nudoadmin")) {
			JOptionPane.showMessageDialog(frame, "Login Successfully");
			dashboard db = new dashboard(getFname(), getLname(), user, pass);
			db.frame.setVisible(true);
			frame.dispose();
		}
		else {
			JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
		}
	}
	
}
