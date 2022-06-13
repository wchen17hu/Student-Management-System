package Student;

import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import com.borland.jbcl.layout.XYLayout;

import db.dbConn;

import com.borland.jbcl.layout.*;
import stuManager.MainFrame;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class StudentManager extends JFrame {
	String sql, zhy;
	JLabel jLabel1 = new JLabel();
	XYLayout xYLayout1 = new XYLayout();
	JLabel jLabel2 = new JLabel();
	JComboBox jComboBox1 = new JComboBox();
	JPanel jPanel1 = new JPanel();
	JLabel jLabel3 = new JLabel();
	JButton jButton1 = new JButton();
	JPanel jPanel2 = new JPanel();
	XYLayout xYLayout2 = new XYLayout();
	JLabel jLabel4 = new JLabel();
	JTextField jTextField2 = new JTextField();
	JButton jButton2 = new JButton();
	ButtonGroup buttonGroup1 = new ButtonGroup();
	JPanel jPanel4 = new JPanel();
	JLabel jLabel6 = new JLabel();
	XYLayout xYLayout4 = new XYLayout();
	JTextField jTextField3 = new JTextField();
	JButton jButton4 = new JButton();
	XYLayout xYLayout5 = new XYLayout();
	JTextField jTextField1 = new JTextField();
	JButton jButton5 = new JButton();
	JButton jButton6 = new JButton();
	JScrollPane jScrollPane1 = new JScrollPane();
	JTable jTable1 = new JTable();
	int intRow;
	dbConn conn = new dbConn();
	String[] arrField = { "ID", "Name", "Department", "Major", "Class" };
	DefaultTableModel model = new DefaultTableModel();
	Object[][] arrData = {};
	static int find;
	JButton jButton7 = new JButton();
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();

	public StudentManager() {
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {

		getContentPane().setLayout(xYLayout1);
		jLabel1.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
		jLabel1.setText("Student Management");
		jLabel2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel2.setText("Please select search option");
		this.setTitle("Student Management");
		jPanel1.setBorder(BorderFactory.createEtchedBorder());
		jPanel1.setLayout(xYLayout5);
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel3.setText("Please type in ID");
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton1.setText("Search");
		jButton1.addActionListener(new StudentC_jButton1_actionAdapter(this));
		jPanel2.setBorder(BorderFactory.createEtchedBorder());
		jPanel2.setLayout(xYLayout2);
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel4.setText("Please type in Name");
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton2.setText("Search");
		jButton2.addActionListener(new StudentC_jButton2_actionAdapter(this));
		jPanel4.setBorder(BorderFactory.createEtchedBorder());
		jPanel4.setLayout(xYLayout4);
		jLabel6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jLabel6.setText("Please type in Class");
		jButton4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton4.setText("Search");
		jButton4.addActionListener(new StudentC_jButton4_actionAdapter(this));
		jComboBox1.addActionListener(new StudentC_jComboBox1_actionAdapter(this));
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton5.setText("Modify");
		jButton5.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton5_actionPerformed(e);
			}
		});

		jButton6.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton6.setText("Back");
		jButton6.addActionListener(new StudentC_jButton6_actionAdapter(this));
		jScrollPane1.setBorder(BorderFactory.createEtchedBorder());
		jTable1.setCellSelectionEnabled(true);
		jButton7.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton7.setText("Delete");
		jButton7.addActionListener(new StudentC_jButton7_actionAdapter(this));
		this.getContentPane().add(jPanel2, new XYConstraints(150, 125, 510, 50));
		jPanel2.add(jButton2, new XYConstraints(381, 8, 85, 27));
		this.getContentPane().add(jPanel4, new XYConstraints(150, 125, 510, 50));
		jPanel4.add(jButton4, new XYConstraints(388, 8, 89, 26));
		ShowPanel();
		jComboBox1.addItem("Please select");
		jComboBox1.addItem("Search by ID");
		jComboBox1.addItem("Search by Name");
		jComboBox1.addItem("Search by Class");
		jPanel1.add(jTextField1, new XYConstraints(164, 8, 149, 25));
		jPanel1.add(jButton1, new XYConstraints(360, 8, 80, 29));
		jPanel1.add(jLabel3, new XYConstraints(21, 8, 155, 26));
		jPanel2.add(jLabel4, new XYConstraints(21, 8, 164, 31));
		jPanel2.add(jTextField2, new XYConstraints(206, 8, 132, 27));
		jPanel4.add(jLabel6, new XYConstraints(16, 8, 181, 30));
		jPanel4.add(jTextField3, new XYConstraints(212, 8, 152, 28));
		this.getContentPane().add(jLabel1, new XYConstraints(281, 12, 280, 38));
		this.getContentPane().add(jComboBox1, new XYConstraints(420, 76, -1, 30));
		this.getContentPane().add(jLabel2, new XYConstraints(119, 74, 251, 32));
		this.getContentPane().add(jPanel1, new XYConstraints(150, 125, 510, 50));
		jScrollPane1.getViewport().add(jTable1, null);
		this.getContentPane().add(jScrollPane1, new XYConstraints(20, 193, 759, 325));
		this.getContentPane().add(jButton5, new XYConstraints(225, 545, 95, 34));
		this.getContentPane().add(jButton6, new XYConstraints(525, 545, 95, 34));
		this.getContentPane().add(jButton7, new XYConstraints(375, 545, 95, 34));


		if (MainFrame.level.equals("1")) {
		}
		else if (MainFrame.level.equals("2")) {
			jButton5.setVisible(false);
			jButton7.setVisible(false);
		}

		sql = "select * from tb_student";
		UpdateRecord();
	}

	public void UpdateRecord() {
		Object[][] arrTmp = {}; 
		Vector vec = new Vector(1, 1);
		model = new DefaultTableModel(arrTmp, arrField);
		jTable1 = new JTable(model);
		jScrollPane1.getViewport().add(jTable1, null);

		try {
			ResultSet rs = conn.getRs(sql);
			while (rs.next()) {
				vec = new Vector();
				vec.add(rs.getString("stuNumber").trim());
				vec.add(rs.getString("stuName").trim());
				vec.add(rs.getString("stuDepart").trim());
				vec.add(rs.getString("stuSpec").trim());
				vec.add(rs.getString("stuClass").trim());
				model.addRow(vec);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		jScrollPane1.getHorizontalScrollBar();
		jTable1.setGridColor(Color.blue);
		jTable1.setDragEnabled(true);
		jTable1.setSelectionForeground(Color.red);
		jTable1.setSelectionBackground(Color.green);
		jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jTable1.setRowSelectionAllowed(true);
		jTable1.setShowVerticalLines(true);
	}

	public void ShowPanel() {
		jPanel1.setVisible(false);
		jPanel2.setVisible(false);
		jPanel4.setVisible(false);
		if (jComboBox1.getSelectedIndex() == 1)
			jPanel1.setVisible(true);
		else if (jComboBox1.getSelectedIndex() == 2)
			jPanel2.setVisible(true);
		else if (jComboBox1.getSelectedIndex() == 3)
			jPanel4.setVisible(true);
	}

	public void getM() {
		intRow = jTable1.getSelectedRow();
		if (intRow == -1)
			return;
		try {
			find = Integer.parseInt(model.getValueAt(intRow, 0).toString());
			System.err.println(find);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void jButton6_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	public String jButton1_actionPerformed(ActionEvent e) {
		if (!jTextField1.getText().trim().equals("")) {
			sql = "select * from tb_student where stuNumber='" + jTextField1.getText().trim() + "'";
			UpdateRecord();
			return "Find student";
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "Please type in student's ID", "Alert",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			return "Please type in student's ID";
	}

	public void jComboBox1_actionPerformed(ActionEvent e) {
		ShowPanel();
	}

	public void jButton2_actionPerformed(ActionEvent e) {
		if (!jTextField2.getText().trim().equals("")) {
			sql = "select * from tb_student where stuName='" + jTextField2.getText().trim() + "'";
			UpdateRecord();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "Please type in student's name", "Alert",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	public void jButton4_actionPerformed(ActionEvent e) {
		if (!jTextField3.getText().trim().equals("")) {
			sql = "select * from tb_student where stuClass='" + jTextField3.getText().trim() + "'";
			UpdateRecord();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "Please type in student's class", "Alert",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	public void jButton5_actionPerformed(ActionEvent e) {
		getM();
		if (intRow != -1) {
			StudentChange siadd = new StudentChange(find);
			siadd.setLocation(400, 200);
			siadd.setSize(592, 350);
			siadd.setVisible(true);
			siadd.setResizable(false);
			siadd.validate();
			this.dispose();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "Please select what you want to modify", "Alert",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	public void jButton7_actionPerformed(ActionEvent e) {
		getM();
		if (intRow != -1) {
			delstu();
		} else
			jOptionPane_LoginFeedback.showMessageDialog(this, "Please select what you want to delete", "Alert",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);

	}

	public void delstu() {
		try {
			if (0 < conn.getUpdate("delete from tb_student where stuNumber='" + find + "'")) {
				jOptionPane_LoginFeedback.showMessageDialog(this, "Change successfully", "Alert",
						jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			} else {
				System.err.printf("delete stuNumber = %d record from tb_student table \n", find);
				jOptionPane_LoginFeedback.showMessageDialog(this, "Change failed", "Alert",
						jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			}
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		}
	}
}

class StudentC_jButton7_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton7_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton7_actionPerformed(e);
	}
}

class StudentC_jButton4_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton4_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton4_actionPerformed(e);
	}
}

class StudentC_jButton2_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton2_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}

class 	StudentC_jButton1_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton1_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class StudentC_jButton6_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jButton6_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton6_actionPerformed(e);
	}
}

class StudentC_jComboBox1_actionAdapter implements ActionListener {
	private StudentManager adaptee;

	StudentC_jComboBox1_actionAdapter(StudentManager adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jComboBox1_actionPerformed(e);
	}
}
