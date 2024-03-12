package student_frame;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class student_table extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();;
	private JComponent bar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension dimensionbar = null;
	private JLabel monthly_cases, num_stud, today_case;
	private int mc_counter;
	private int ns_counter = 0;
	private int tc_counter = -1;
	private static student_table instance;
	private String fname;
	private String lname;
	private String user;
	private String pass;
	private JButton update_student;

	public static student_table getInstance() {
	    return instance;
	}


	/**
	 * Create the frame.
	 */
	public void removetitleBar() {
		bar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		dimensionbar = bar.getPreferredSize();
		bar.setSize(0,0);
		bar.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	
	public student_table(String fname, String lname, String user, String pass) {
		this.fname = fname;
		this.lname = lname;
		this.user = user;
		this.pass = pass;
		instance = this;
		getContentPane().setBackground(new Color(255, 255, 255));
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		removetitleBar();
		setBounds(100, 100, 944, 588);
		
		JButton insert_student = new JButton("Add Student");
		insert_student.setBounds(21, 510, 115, 25);
		insert_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				students_form add = new students_form(fname,lname,user,pass);
				add.setVisible(true);
			}
		});
		insert_student.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		update_student = new JButton("Update");
		update_student.setBounds(146, 510, 115, 25);
		update_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog("Enter the student id: ");
				
				if (isStudentIdExists(id)) {
					student_update update = new student_update(id);
					update.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(student_table.this, "Student with ID " + id + " does not exist in the database.", "Student Not Found", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		update_student.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		JButton delete_student = new JButton("Delete");
		delete_student.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteDataByStudentNumber(e);
			}
		});
		delete_student.setBounds(271, 510, 115, 25);
		delete_student.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 307, 913, 193);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Segoe UI", Font.BOLD, 11));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"stud_num", "stud_Fname", "stud_Lname", "stud_year", "stud_dept", "stud_course", "stud_spec", "offense_desc", "ticket_num"
			}
		) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(8).setResizable(false);
		getContentPane().add(insert_student);
		getContentPane().add(update_student);
		getContentPane().add(delete_student);
		
		JLabel lblNewLabel = new JLabel("  Students");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(21, 27, 284, 41);
		Image image = new ImageIcon(this.getClass().getResource("/icons8-student-35 (1).png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(image));
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(21, 94, 284, 123);
		getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		JLabel lblNewLabel_2 = new JLabel("Total Monthly Cases");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		monthly_cases = new JLabel("0");
		monthly_cases.setHorizontalAlignment(SwingConstants.CENTER);
		monthly_cases.setFont(new Font("SansSerif", Font.BOLD, 24));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(monthly_cases, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(monthly_cases, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(331, 94, 284, 123);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		
		JLabel lblNewLabel_2_1 = new JLabel("Number of Students");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		num_stud = new JLabel("0");
		num_stud.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud.setFont(new Font("SansSerif", Font.BOLD, 24));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 284, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_1, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(num_stud, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 123, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_1)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(num_stud, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBackground(SystemColor.activeCaption);
		panel_2.setBounds(637, 94, 284, 123);
		getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		
		JLabel lblNewLabel_2_2 = new JLabel("Today's Cases");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		today_case = new JLabel("0");
		today_case.setHorizontalAlignment(SwingConstants.CENTER);
		today_case.setFont(new Font("SansSerif", Font.BOLD, 24));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 284, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2_2, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(today_case, GroupLayout.PREFERRED_SIZE, 258, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 123, Short.MAX_VALUE)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(24)
					.addComponent(lblNewLabel_2_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1_2)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(today_case, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(55))
		);
		panel_2.setLayout(gl_panel_2);
		fetchData(null);
		
	}
	
	private boolean isStudentIdExists(String studentId) {
	    String url = "jdbc:mysql://localhost:3306/admin";
	    String username = "admin";
	    String password = "nudoadmin";
	    String query = "SELECT * FROM students WHERE student_id = ?";

	    try (Connection connection = DriverManager.getConnection(url, username, password);
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setString(1, studentId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        return resultSet.next();

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        return false;
	    }
	}
	
	void fetchData(ActionEvent e) {
		String url = "jdbc:mysql://localhost:3306/admin";
		String username = "admin";
	    String password = "nudoadmin";
	    
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	    	String query = "SELECT * FROM students";
	    	
	    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    		ResultSet result = preparedStatement.executeQuery();
	    		
	    		int columnCount = result.getMetaData().getColumnCount();
	    		String[] columnNames = new String[columnCount];
	    		for (int i = 1; i <= columnCount; i++) {
	    			columnNames[i-1] = result.getMetaData().getColumnName(i);
	    		}
	    		
	    		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
	    		while(result.next()) {
	    			Object[] rowData = new Object[columnCount];
	    			for (int i = 1; i <= columnCount; i++) {
	    				rowData[i-1] = result.getObject(i);
	    			}
	    			model.addRow(rowData);
	    		}
	    		
	    		table.setModel(model);
	    		updateCounters();
	    		
	    	}
	    } catch (SQLException ex) {
            ex.printStackTrace();
        }
	    
	}
	

    private void deleteDataByStudentNumber(ActionEvent e) {
        String studentNumberToDelete = JOptionPane.showInputDialog(this, "Enter student id to delete:");

        if (studentNumberToDelete != null && !studentNumberToDelete.isEmpty()) {
            String url = "jdbc:mysql://localhost:3306/admin";
            String username = "admin";
            String password = "nudoadmin";

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String deleteQuery = "DELETE FROM students WHERE student_id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                    preparedStatement.setString(1, studentNumberToDelete);
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Data deleted successfully.");
                        model.setRowCount(0);
                        mc_counter--;
                        ns_counter--;
                        tc_counter--;
                        monthly_cases.setText(Integer.toString(mc_counter));
                        num_stud.setText(Integer.toString(ns_counter)); 
                        today_case.setText(Integer.toString(tc_counter));
                        fetchData(null);                        
                    } else {
                        JOptionPane.showMessageDialog(this, "No data found for the given student number.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
   
    
    public void updateCounters() {
        mc_counter = table.getRowCount();
        ns_counter = mc_counter;
        tc_counter = mc_counter;

        monthly_cases.setText(Integer.toString(mc_counter));
        num_stud.setText(Integer.toString(ns_counter));
        today_case.setText(Integer.toString(tc_counter));
    }
} 
