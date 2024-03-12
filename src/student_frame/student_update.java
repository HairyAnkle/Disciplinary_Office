package student_frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class student_update extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField crs;
	private JTextField specc;
	private JTextField firstname;
	private JTextField lastname;
	private JTextField off;
	private String fname;
    private String lname;
    private String year;
    private String dept;
    private String course;
    private String spec;
    private int cat_offense;
    private String studentId;
    private JComboBox yearlevel,department;
    private String id;


	public student_update(String id) {
		this.id = id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 644);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(35, 8, 113));
		panel.setBounds(0, 0, 573, 65);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Student");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 31));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 573, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_1)
					.addContainerGap(358, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 65, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 61, 573, 546);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateData();
				refreshTable();
				dispose();
			}				
		    
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setBounds(68, 333, 134, 21);
		panel_1.add(btnNewButton);
		
		JLabel lblSpecializationputNa = new JLabel("Specialization \r\n(put N/A if inapplicable) :");
		lblSpecializationputNa.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSpecializationputNa.setBounds(68, 225, 222, 16);
		panel_1.add(lblSpecializationputNa);
		
		JLabel lblOffenseType = new JLabel("Offense Type :");
		lblOffenseType.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblOffenseType.setBounds(68, 254, 119, 16);
		panel_1.add(lblOffenseType);
		
		JLabel lblCourse = new JLabel("Course :");
		lblCourse.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblCourse.setBounds(68, 196, 100, 16);
		panel_1.add(lblCourse);
		
		crs = new JTextField();
		crs.setColumns(10);
		crs.setBounds(331, 196, 134, 19);
		panel_1.add(crs);
		
		specc = new JTextField();
		specc.setColumns(10);
		specc.setBounds(331, 225, 134, 19);
		panel_1.add(specc);
		
		JLabel lblFirstname = new JLabel("Firstname :");
		lblFirstname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblFirstname.setBounds(68, 59, 100, 16);
		panel_1.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname :");
		lblLastname.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblLastname.setBounds(68, 88, 100, 16);
		panel_1.add(lblLastname);
		
		JLabel lblYearLevel = new JLabel("Year Level :");
		lblYearLevel.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblYearLevel.setBounds(68, 118, 100, 16);
		panel_1.add(lblYearLevel);
		
		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblDepartment.setBounds(68, 150, 100, 16);
		panel_1.add(lblDepartment);
		
		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(331, 63, 134, 19);
		panel_1.add(firstname);
		
		lastname = new JTextField();
		lastname.setColumns(10);
		lastname.setBounds(331, 92, 134, 19);
		panel_1.add(lastname);
		
		yearlevel = new JComboBox();
		yearlevel.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "1st Year", "2nd Year", "3rd Year", "4th Year", "5th Year"}));
		yearlevel.setBounds(331, 121, 134, 19);
		panel_1.add(yearlevel);
		
		department = new JComboBox();
		department.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "COAH", "COA", "CBA", "CCIT", "CEAS", "COE"}));
		department.setBounds(331, 151, 134, 19);
		panel_1.add(department);
		
		off = new JTextField();
		off.setColumns(10);
		off.setBounds(331, 254, 134, 19);
		panel_1.add(off);
	}
	
	void refreshTable() {
	    student_table tableInstance = student_table.getInstance();
	    if (tableInstance != null) {
	        tableInstance.fetchData(null);
	    }
	}
	
	void updateData() {
		String fname = firstname.getText().trim();
		String lname = lastname.getText().trim();
		String yearlvl = yearlevel.getSelectedItem().toString();
		String dept = department.getSelectedItem().toString();
		String course = crs.getText().trim();
		String spec = specc.getText().trim();
		int ot = Integer.parseInt(off.getText().trim());
		String url = "jdbc:mysql://localhost:3306/admin";
		String username = "admin";
	    String password = "nudoadmin";
	    String updateQuery = "UPDATE students SET student_Fname=?, student_Lname=?, student_year=?, student_dept=?, student_course=?, student_spec=?, cat_offense=? WHERE student_id=?";
	    try (Connection connection = DriverManager.getConnection(url, username, password);
		        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

		        preparedStatement.setString(1, fname);
		        preparedStatement.setString(2, lname);
		        preparedStatement.setString(3, yearlvl);
		        preparedStatement.setString(4, dept);
		        preparedStatement.setString(5, course);
		        preparedStatement.setString(6, spec);
		        preparedStatement.setInt(7, ot);
		        preparedStatement.setString(8, id);

		        int rowsUpdated = preparedStatement.executeUpdate();

		        if (rowsUpdated > 0) {
		            JOptionPane.showMessageDialog(student_update.this, "Update Successful!");
		        } else {
		            JOptionPane.showMessageDialog(student_update.this, "Update failed. Please check your input.", "Update Failed", JOptionPane.ERROR_MESSAGE);
		        }
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		        
		    }
	
	
	}


}
