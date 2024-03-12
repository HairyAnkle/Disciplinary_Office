package rulebook_frame;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;

public class rulebook extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static rulebook instance;
	private JComponent bar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
	private Dimension dimensionbar = null;
	public static rulebook getInstance() {
	    return instance;
	}

	public void removetitleBar() {
		bar = ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).getNorthPane();
		dimensionbar = bar.getPreferredSize();
		bar.setSize(0,0);
		bar.setPreferredSize(new Dimension(0,0));
		repaint();
	}
	/**
	 * Create the frame.
	 */
	public rulebook() {
		instance = this;
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(151, 91, 691, 422);
		getContentPane().add(panel);	
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(28, 69, 45, 0);
		
		JLabel lblNewLabel_2 = new JLabel("Category of Offense");
		lblNewLabel_2.setBounds(13, 19, 464, 32);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 24));
		
		JLabel monthly_cases = new JLabel("Category");
		monthly_cases.setBounds(28, 60, 156, 32);
		monthly_cases.setHorizontalAlignment(SwingConstants.CENTER);
		monthly_cases.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel.setLayout(null);
		panel.add(lblNewLabel_1);
		panel.add(lblNewLabel_2);
		panel.add(monthly_cases);
		
		JLabel num_stud = new JLabel("1");
		num_stud.setBounds(28, 95, 156, 32);
		panel.add(num_stud);
		num_stud.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JLabel num_stud_1 = new JLabel("2");
		num_stud_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_1.setBounds(28, 129, 156, 32);
		panel.add(num_stud_1);
		
		JLabel num_stud_1_1 = new JLabel("3");
		num_stud_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_1_1.setBounds(28, 163, 156, 32);
		panel.add(num_stud_1_1);
		
		JLabel monthly_cases_1 = new JLabel("Offense Type");
		monthly_cases_1.setHorizontalAlignment(SwingConstants.CENTER);
		monthly_cases_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		monthly_cases_1.setBounds(276, 63, 174, 26);
		panel.add(monthly_cases_1);
		
		JLabel num_stud_2 = new JLabel("Minor Offenses (e.g. Non-wearing prescribe uniform)");
		num_stud_2.setHorizontalAlignment(SwingConstants.LEFT);
		num_stud_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_2.setBounds(300, 102, 335, 19);
		panel.add(num_stud_2);
		
		JLabel num_stud_2_1 = new JLabel("Semi-major Offenses (e.g. Vape, Vandalism, etc.)");
		num_stud_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		num_stud_2_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_2_1.setBounds(300, 141, 371, 19);
		panel.add(num_stud_2_1);
		
		JLabel num_stud_2_1_1 = new JLabel("Major Offenses (e.g. Harassment, Cheating, etc.)");
		num_stud_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		num_stud_2_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_2_1_1.setBounds(300, 175, 371, 19);
		panel.add(num_stud_2_1_1);
		
		JLabel monthly_cases_2 = new JLabel("Duration");
		monthly_cases_2.setHorizontalAlignment(SwingConstants.CENTER);
		monthly_cases_2.setFont(new Font("SansSerif", Font.BOLD, 18));
		monthly_cases_2.setBounds(28, 239, 156, 32);
		panel.add(monthly_cases_2);
		
		JLabel monthly_cases_1_1 = new JLabel("Severity");
		monthly_cases_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		monthly_cases_1_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		monthly_cases_1_1.setBounds(289, 242, 174, 26);
		panel.add(monthly_cases_1_1);
		
		JLabel num_stud_3 = new JLabel("1 month");
		num_stud_3.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_3.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_3.setBounds(28, 277, 156, 32);
		panel.add(num_stud_3);
		
		JLabel num_stud_1_2 = new JLabel("3 months");
		num_stud_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_1_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_1_2.setBounds(28, 311, 156, 32);
		panel.add(num_stud_1_2);
		
		JLabel num_stud_1_1_1 = new JLabel("6 months");
		num_stud_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_1_1_1.setBounds(28, 345, 156, 32);
		panel.add(num_stud_1_1_1);
		
		JLabel num_stud_3_1 = new JLabel("LOW");
		num_stud_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_3_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_3_1.setBounds(300, 277, 156, 32);
		panel.add(num_stud_3_1);
		
		JLabel num_stud_1_2_1 = new JLabel("MEDIUM");
		num_stud_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_1_2_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_1_2_1.setBounds(300, 311, 156, 32);
		panel.add(num_stud_1_2_1);
		
		JLabel num_stud_1_1_1_1 = new JLabel("HIGH");
		num_stud_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		num_stud_1_1_1_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		num_stud_1_1_1_1.setBounds(300, 345, 156, 32);
		panel.add(num_stud_1_1_1_1);
		
		JLabel lblNewLabel = new JLabel("  Rulebooks");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(38, 25, 298, 41);
		Image img = new ImageIcon(this.getClass().getResource("/icons8-book-35.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		getContentPane().add(lblNewLabel);
		this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
		removetitleBar();
		setBounds(100, 100, 944, 588);

	}

}
