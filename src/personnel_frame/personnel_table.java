package personnel_frame;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import student_frame.student_table;

public class personnel_table extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel model = new DefaultTableModel();;
	private static personnel_table instance;
	private JComponent bar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension dimensionbar = null;
	public static personnel_table getInstance() {
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
	
	public personnel_table() {
	    instance = this;
	    getContentPane().setBackground(new Color(255, 255, 255));
	    this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
	    removetitleBar();
	    setBounds(100, 100, 944, 588);
	    getContentPane().setLayout(null);

	    JLabel lblPersonnel = new JLabel(" Personnel");
	    lblPersonnel.setFont(new Font("Segoe UI", Font.BOLD, 30));
	    lblPersonnel.setBounds(26, 33, 284, 41);
	    getContentPane().add(lblPersonnel);
	    Image img = new ImageIcon(this.getClass().getResource("/icons8-traditional-company-structure-35.png")).getImage();
	    lblPersonnel.setIcon(new ImageIcon(img));

	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(47, 124, 838, 375);
	    getContentPane().add(scrollPane);

	    table = new JTable();
	    scrollPane.setViewportView(table);
	    table.setFont(new Font("SansSerif", Font.BOLD, 12));
	    table.setModel(new DefaultTableModel(
	            new Object[][] {},
	            new String[] { "guard_id", "guard_Fname", "guard_Lname", "ticket_num" }) {
	        Class[] columnTypes = new Class[] { String.class, String.class, String.class, Object.class };

	        public Class getColumnClass(int columnIndex) {
	            return columnTypes[columnIndex];
	        }
	    });
	    table.getColumnModel().getColumn(2).setResizable(false);
	    fetchData();
	}

	
	void fetchData() {
		String url = "jdbc:mysql://localhost:3306/admin";
		String username = "admin";
	    String password = "nudoadmin";
	    
	    try (Connection connection = DriverManager.getConnection(url, username, password)) {
	    	String query = "SELECT * FROM guard";
	    	
	    	try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	    		ResultSet result = preparedStatement.executeQuery();
	    		
	    		int columnCount = result.getMetaData().getColumnCount();
	    		String[] columnNames = new String[columnCount];
	    		for (int i = 1; i <= columnCount; i++) {
	    			columnNames[i-1] = result.getMetaData().getColumnName(i);
	    		}
	    		
	    		model = new DefaultTableModel(columnNames, 0);
	    		while(result.next()) {
	    			Object[] rowData = new Object[columnCount];
	    			for (int i = 1; i <= columnCount; i++) {
	    				rowData[i-1] = result.getObject(i);
	    			}
	    			model.addRow(rowData);
	    		}
	    		
	    		table.setModel(model);
	    	}
	    } catch (SQLException ex) {
            ex.printStackTrace();
        }
	    
	}
}
