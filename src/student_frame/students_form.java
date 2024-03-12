package student_frame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;

import LoginPage.login;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;

public class students_form extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField Fname;
	private JTextField Lname;
	private JTextField stud_course;
	private JTextField stud_spec;
	private JTextField stud_num;
	private JComboBox department, yearLevel;
	private int ticketCounter = 1;
	private JTextField offensedescription;
	private JTextField guard_id;
	private JTextField guard_Fname;
	private JTextField guard_Lname;
	login log = new login();
	private String fname;
	private String lname;
	private String user;
	private String pass;
	/**
	 * Create the frame.
	 */
	public students_form(String fname, String lname, String user, String pass) {
		this.fname = fname;
		this.lname = lname;
		this.user = user;
		this.pass = pass;
		setBounds(100, 100, 581, 644);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 573, 65);
		panel.setBackground(new Color(35, 8, 113));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 61, 573, 546);
		panel_1.setBackground(new Color(255, 255, 255));
		
		Fname = new JTextField();
		Fname.setBounds(331, 63, 134, 19);
		Fname.setColumns(10);
		
		Lname = new JTextField();
		Lname.setBounds(331, 92, 134, 19);
		Lname.setColumns(10);
		
		stud_course = new JTextField();
		stud_course.setBounds(331, 196, 134, 19);
		stud_course.setColumns(10);
		
		stud_spec = new JTextField();
		stud_spec.setBounds(331, 225, 134, 19);
		stud_spec.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Student Number :");
		lblNewLabel.setBounds(68, 33, 100, 16);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblFirstname = new JLabel("Firstname :");
		lblFirstname.setBounds(68, 59, 100, 16);
		lblFirstname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblLastname = new JLabel("Lastname :");
		lblLastname.setBounds(68, 88, 100, 16);
		lblLastname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblYearLevel = new JLabel("Year Level :");
		lblYearLevel.setBounds(68, 118, 100, 16);
		lblYearLevel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setBounds(68, 150, 100, 16);
		lblDepartment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setBounds(68, 196, 100, 16);
		lblCourse.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblSpecializationputNa = new JLabel("Specialization \r\n(put N/A if inapplicable) :");
		lblSpecializationputNa.setBounds(68, 225, 222, 16);
		lblSpecializationputNa.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		JLabel lblOffenseType = new JLabel("Offense Type :");
		lblOffenseType.setBounds(68, 254, 119, 16);
		lblOffenseType.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
		department = new JComboBox();
		department.setBounds(331, 151, 134, 19);
		department.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "COAH", "COA", "CBA", "CCIT", "CEAS", "COE"}));
		
		yearLevel = new JComboBox();
		yearLevel.setBounds(331, 121, 134, 19);
		yearLevel.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year"}));
		
		stud_num = new JTextField();
		stud_num.setBounds(331, 34, 134, 19);
		stud_num.setColumns(10);
		getContentPane().setLayout(null);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Student");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 31));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_1)
					.addContainerGap(315, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(68, 457, 134, 21);
		panel_1.add(btnNewButton);
		panel_1.add(lblSpecializationputNa);
		panel_1.add(lblOffenseType);
		panel_1.add(lblCourse);
		panel_1.add(stud_course);
		panel_1.add(stud_spec);
		panel_1.add(lblNewLabel);
		panel_1.add(lblFirstname);
		panel_1.add(lblLastname);
		panel_1.add(lblYearLevel);
		panel_1.add(lblDepartment);
		panel_1.add(stud_num);
		panel_1.add(Fname);
		panel_1.add(Lname);
		panel_1.add(yearLevel);
		panel_1.add(department);
		
		offensedescription = new JTextField();
		offensedescription.setColumns(10);
		offensedescription.setBounds(331, 254, 134, 19);
		panel_1.add(offensedescription);
		
		JLabel lblGuardId = new JLabel("Guard ID :");
		lblGuardId.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblGuardId.setBounds(68, 354, 100, 16);
		panel_1.add(lblGuardId);
		
		guard_id = new JTextField();
		guard_id.setColumns(10);
		guard_id.setBounds(331, 354, 134, 19);
		panel_1.add(guard_id);
		
		guard_Fname = new JTextField();
		guard_Fname.setColumns(10);
		guard_Fname.setBounds(331, 380, 134, 19);
		panel_1.add(guard_Fname);
		
		JLabel lblFirstname_1 = new JLabel("Firstname :");
		lblFirstname_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblFirstname_1.setBounds(68, 380, 100, 16);
		panel_1.add(lblFirstname_1);
		
		JLabel lblLastname_1 = new JLabel("Lastname :");
		lblLastname_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblLastname_1.setBounds(68, 409, 100, 16);
		panel_1.add(lblLastname_1);
		
		guard_Lname = new JTextField();
		guard_Lname.setColumns(10);
		guard_Lname.setBounds(331, 409, 134, 19);
		panel_1.add(guard_Lname);
		
		JLabel lblNewLabel_1_1 = new JLabel("Guard's Information");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(35, 8, 113));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 31));
		lblNewLabel_1_1.setBounds(68, 302, 299, 42);
		panel_1.add(lblNewLabel_1_1);
	}
	String readStud_num() {
		return stud_num.getText().trim();
	}
	
	String readFname() {
		return Fname.getText().trim();
	}
	
	String readLname() {
		return Lname.getText().trim();
	}
	
	String readyearlvl() {
		return yearLevel.getSelectedItem().toString();
	}
	
	String readdept() {
		return department.getSelectedItem().toString();
	}
	
	String readCourse() {
		return stud_course.getText().trim();
	}
	
	String readSpec() {
		return stud_spec.getText().trim();
	}
	
	int readoffense() {
	    String offenseText = offensedescription.getText().trim();
	    if (!offenseText.isEmpty()) {
	        try {
	            return Integer.parseInt(offenseText);
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Invalid offense type. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	    return 0;
	}
	
	String getGuardID() {
		return guard_id.getText().trim();
	}
	
	String getFname() {
		return guard_Fname.getText().trim();
	}
	
	String getLname() {
		return guard_Lname.getText().trim();
	}
	
	private void addPerformed(ActionEvent e) {
	    String student_num = readStud_num();
	    String firstname = readFname();
	    String lastname = readLname();
	    String year = readyearlvl();
	    String dept = readdept();
	    String course = readCourse();
	    String spec = readSpec();
	    int off = readoffense();
	    
	    if (isValidInput(student_num, firstname, lastname, year, dept, course, spec, off) && isValidInput2(getGuardID(), getFname(), getLname())){
	    	String ticketNumber = generateTicket(student_num);
	        insertToSQLTicket(ticketNumber, student_num, readoffense());
	        insertToSQL(readStud_num(), readFname(), readLname(), readyearlvl(), readdept(), readCourse(), readSpec(), readoffense(), ticketNumber);
	        insertToSQLGuard(getGuardID(), getFname(), getLname(), ticketNumber);
	        insertToSQLAdmin(fname, lname, user, pass, getGuardID(), student_num, ticketNumber);
	        refreshTable();
	        JOptionPane.showMessageDialog(this, "Added Successfully!");
	        dispose();
	        
	    } else {
	        JOptionPane.showMessageDialog(this, "Please fill in all required fields.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	void refreshTable() {
	    student_table tableInstance = student_table.getInstance();
	    if (tableInstance != null) {
	        tableInstance.fetchData(null);
	    }
	}
	
	void updateCounters() {
	    student_table tableInstance = student_table.getInstance();
	    if (tableInstance != null) {
	        tableInstance.updateCounters();
	    }
	}

	private boolean isValidInput(String student_num, String firstname, String lastname, String year, String dept, String course, String spec, int off) {
	    return !student_num.isEmpty() && !firstname.isEmpty() && !lastname.isEmpty() && !year.isEmpty() && !dept.isEmpty() && !course.isEmpty() && !spec.isEmpty() && off != 0;
	}
	
	private boolean isValidInput2(String id, String firstname, String lastname) {
	    return !id.isEmpty() && !firstname.isEmpty() && !lastname.isEmpty();
	}

	String generateTicket(String student_num) {
	    String ticketNumber = student_num + "-" + String.format("%03d", ticketCounter++);
	    return ticketNumber;
	}
	
	
	private void insertToSQLGuard(String guardid, String fname, String lname, String ticketNumber) {
	    String url = "jdbc:mysql://localhost:3306/admin";
	    String username = "admin";
	    String password = "nudoadmin";

	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "INSERT INTO guard (guard_id, guard_Fname, guard_Lname, ticket_num) VALUES (?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, guardid);
	            preparedStatement.setString(2, fname);
	            preparedStatement.setString(3, lname);
	            preparedStatement.setString(4, ticketNumber);

	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	
	private void insertToSQLTicket(String ticket, String id, int offense) {
	    String url = "jdbc:mysql://localhost:3306/admin";
	    String username = "admin";
	    String password = "nudoadmin";
	    
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "INSERT INTO tickets (ticket_num, student_id, cat_offense) VALUES (?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        	preparedStatement.setString(1, ticket);
	            preparedStatement.setString(2, id);
	            preparedStatement.setInt(3, offense);

	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}

	private void insertToSQLAdmin(String firstname, String lastname, String user, String pass, String g_id, String s_id, String t_id) {
	    String url = "jdbc:mysql://localhost:3306/admin";
	    String username = "admin";
	    String password = "nudoadmin";
	    
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "INSERT INTO admin (admin_Fname, admin_Lname, admin_user, admin_pass, guard_id, student_id, ticket_num) VALUES (?, ?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, firstname);
	            preparedStatement.setString(2, lastname);
	            preparedStatement.setString(3, user);
	            preparedStatement.setString(4, pass);
	            preparedStatement.setString(5, g_id);
	            preparedStatement.setString(6, s_id);
	            preparedStatement.setString(7, t_id);

	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	
	private void insertToSQL(String student_num, String firstname, String lastname, String year, String dept, String course, String spec, int off, String ticketNumber) {
	    String url = "jdbc:mysql://localhost:3306/admin";
	    String username = "admin";
	    String password = "nudoadmin";
	    
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	        String query = "INSERT INTO students (student_id, student_Fname, student_Lname, student_year, student_dept, student_course, student_spec, cat_offense, ticket_num) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	            preparedStatement.setString(1, student_num);
	            preparedStatement.setString(2, firstname);
	            preparedStatement.setString(3, lastname);
	            preparedStatement.setString(4, year);
	            preparedStatement.setString(5, dept);
	            preparedStatement.setString(6, course);
	            preparedStatement.setString(7, spec);
	            preparedStatement.setInt(8, off);
	            preparedStatement.setString(9, ticketNumber);

	            preparedStatement.executeUpdate();
	        }
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
}
