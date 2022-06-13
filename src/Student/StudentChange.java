package Student;

import java.awt.*;
import javax.swing.*;

import db.dbConn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class StudentChange extends JFrame {
	JPanel contentPane;
	JLabel jLabel2 = new JLabel();
	JLabel jLabel3 = new JLabel();
	JLabel jLabel4 = new JLabel();
	JLabel jLabel7 = new JLabel();
	JLabel jLabel8 = new JLabel();
	JTextField jTextField1 = new JTextField();
	JTextField jTextField2 = new JTextField();
	JComboBox jComboBox4 = new JComboBox();
	JComboBox jComboBox5 = new JComboBox();
	JButton jButton1 = new JButton();
	JButton jButton2 = new JButton();
	dbConn con = new dbConn();
	Object clas[] = {};
	JLabel jLabel10 = new JLabel();
	JComboBox jComboBox1 = new JComboBox();
	dbConn conn = new dbConn();
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();
	String number, name, sdepart, sspec, sclass;
	int find;

	public StudentChange(int find) {
		this.find = find;
		try {
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		setSize(new Dimension(592, 500));
		setTitle("ѧ����Ϣ�޸�");
		jLabel2.setFont(new java.awt.Font("Dialog", Font.BOLD, 23));
		jLabel2.setText("ѧ  ��  ��  Ϣ  ��  ��");
		jLabel2.setBounds(new Rectangle(197, 17, 231, 25));
		jLabel3.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel3.setText("ѧ       ��:");
		jLabel3.setBounds(new Rectangle(50, 74, 90, 22));
		jLabel4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel4.setText("��       ��:");
		jLabel4.setBounds(new Rectangle(50, 124, 90, 22));
		jLabel7.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel7.setText("����ѧԺ:");
		jLabel7.setBounds(new Rectangle(50, 174, 90, 22));
		jLabel8.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel8.setText("����רҵ:");
		jLabel8.setBounds(new Rectangle(297, 174, 90, 22));
		jTextField1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField1.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField1.setBounds(new Rectangle(150, 74, 195, 23));
		jTextField2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jTextField2.setBorder(BorderFactory.createLoweredBevelBorder());
		jTextField2.setText("");
		jTextField2.setBounds(new Rectangle(150, 124, 195, 23));
		jComboBox4.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox4.setBorder(BorderFactory.createLoweredBevelBorder());
		jComboBox4.setBounds(new Rectangle(150, 174, 125, 25));
		jComboBox4.addActionListener(new StudentUp_jComboBox4_actionAdapter(this));
		jComboBox5.setEnabled(false);
		jComboBox5.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox5.setBorder(BorderFactory.createLoweredBevelBorder());
		jComboBox5.setBounds(new Rectangle(390, 174, 125, 25));
		jComboBox5.addActionListener(new StudentUp_jComboBox5_actionAdapter(this));
		jButton2.setBounds(new Rectangle(375, 274, 90, 27));
		jButton1.setBounds(new Rectangle(147, 274, 90, 27));
		jButton1.setBorder(BorderFactory.createRaisedBevelBorder());
		jButton1.setText("��  ��");
		jButton1.addActionListener(new StudentUp_jButton1_actionAdapter(this));
		jButton2.setText("��  ��");
		jButton2.addActionListener(new StudentUp_jButton2_actionAdapter(this));
		jLabel10.setFont(new java.awt.Font("Dialog", Font.PLAIN, 18));
		jLabel10.setText("���ڰ༶��");
		jLabel10.setBounds(new Rectangle(47, 224, 93, 29));
		jComboBox1.setEnabled(false);
		jComboBox1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jComboBox1.setBounds(new Rectangle(150, 224, 125, 25));
		contentPane.add(jLabel2);
		contentPane.add(jLabel8);
		contentPane.add(jComboBox5);
		contentPane.add(jLabel7);
		contentPane.add(jComboBox4);
		contentPane.add(jLabel3);
		contentPane.add(jTextField1);
		contentPane.add(jLabel4);
		contentPane.add(jTextField2);
		contentPane.add(jButton1);
		contentPane.add(jButton2);
		contentPane.add(jLabel10);
		contentPane.add(jComboBox1);
		jButton2.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		jButton1.setFont(new java.awt.Font("Dialog", Font.PLAIN, 16));
		this.jComboBox4.addItem("��ѡ��ѧԺ");
		// ѡ��ѧԺ
		try {
			ResultSet rs = con.getRs("select * from tb_depart ");
			while (rs.next()) {
				String xibu = rs.getString("departName");
				jComboBox4.addItem(xibu);
			}
		} catch (Exception ce) {
			System.out.println(ce);
		}
		showstu();
		jComboBox5.setEnabled(false);
		jComboBox1.setEnabled(false);

	}

	// ѡ��ѧԺ�󴥷�
	public void jComboBox4_actionPerformed(ActionEvent e) {
		jcb();
		jComboBox5.setEnabled(true);

	}

	// ѡ��רҵ�󴥷�
	public void jComboBox5_actionPerformed(ActionEvent e) {
		classAdd();
		jComboBox1.setEnabled(true);
	}

	// �޸�
	public void jButton1_actionPerformed(ActionEvent e) {
		// �쳣�ж�
		if (jTextField1.getText().trim().equals("")) {
			jOptionPane_LoginFeedback.showMessageDialog(this, "������ѧ��ѧ�ţ�", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
		} else if (jTextField2.getText().trim().equals("")) {
			jOptionPane_LoginFeedback.showMessageDialog(this, "������ѧ��������", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
		} else if (jComboBox4.getSelectedIndex() == 0) {
			jOptionPane_LoginFeedback.showMessageDialog(this, "��ѡ��ѧ������ѧԺ��", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
		} else if (jComboBox5.getSelectedIndex() == 0) {
			jOptionPane_LoginFeedback.showMessageDialog(this, "��ѡ��ѧ������רҵ��", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
		} else if (jComboBox1.getSelectedIndex() == 0) {
			jOptionPane_LoginFeedback.showMessageDialog(this, "��ѡ��ѧ�����ڰ༶��", "�� ʾ",
					jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
		} else {
			try {
				findDepart();
				findSpec();
				findClass();

				if (find == Integer.parseInt(jTextField1.getText().trim())) {

					// ���޸�ѧ�ŵ����
					number = jTextField1.getText().trim();
					name = jTextField2.getText().trim();
					instu();
				} else {

					// �޸�ѧ�ŵ����
					boolean Num = false;
					ResultSet rs = conn.getRs("select * from tb_student");
					while (rs.next()) {
						if (jTextField1.getText().trim().equals(rs.getString("stuNumber").trim())) {
							Num = true;
						}
					}
					rs.close();
					if (Num) {
						// �ж�ѧ���Ƿ����
						jOptionPane_LoginFeedback.showMessageDialog(this, "ѧ��ѧ���Ѵ��ڣ����������룡", "��ʾ",
								JOptionPane.INFORMATION_MESSAGE, null);
					} else {
						number = jTextField1.getText().trim();
						name = jTextField2.getText().trim();
						instu();
					}
				}
			} catch (Exception ce) {
				System.out.println(ce.getMessage());
			}
		}
	}

	// �˳�
	public void jButton2_actionPerformed(ActionEvent e) {
		this.dispose();
	}

	// ����ѧԺ
	public void findDepart() {
		try {
			ResultSet rs = conn.getRs(
					"select * from tb_depart where departName='" + String.valueOf(jComboBox4.getSelectedItem()) + "' ");
			while (rs.next()) {
				sdepart = rs.getString("departName");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ����רҵ
	public void findSpec() {
		try {
			ResultSet rs = conn.getRs(
					"select * from tb_spec where specName='" + String.valueOf(jComboBox5.getSelectedItem()) + "' ");
			while (rs.next()) {
				sspec = rs.getString("specName");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ���Ұ༶
	public void findClass() {
		try {
			ResultSet rs = conn.getRs(
					"select * from tb_class where className='" + String.valueOf(jComboBox1.getSelectedItem()) + "' ");
			while (rs.next()) {
				sclass = rs.getString("className");
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ѡ��רҵ
	public void jcb() {
		jComboBox5.removeAllItems();
		jComboBox5.addItem("��ѡ��רҵ");
		try {
			ResultSet rs = conn.getRs(
					"select * from tb_spec where departName='" + String.valueOf(jComboBox4.getSelectedItem()) + "' ");
			while (rs.next()) {
				String zhy = rs.getString("specName");
				jComboBox5.addItem(zhy);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// ѡ��༶
	public void classAdd() {
		jComboBox1.removeAllItems();
		jComboBox1.addItem("��ѡ��༶");
		try {
			ResultSet rs = conn.getRs(
					"select * from tb_class where specName='" + String.valueOf(jComboBox5.getSelectedItem()) + "' ");
			while (rs.next()) {
				String zhy = rs.getString("className");
				jComboBox1.addItem(zhy);
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// �޸�
	public void instu() {
		try {
			if (0 < conn.getUpdate("update tb_student set stuNumber = '" + number + "', stuName = '" + name
					+ "', stuDepart = '" + sdepart + "', stuSpec = '" + sspec + "', stuClass = '" + sclass
					+ "' where stuNumber = '" + find + "'")) {
				jOptionPane_LoginFeedback.showMessageDialog(this, "ѧ����Ϣ�޸ĳɹ���", "�� ʾ",
						jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			} else {
				System.err.printf("�޸� tb_student ���� stuNumber = %d �ļ�¼ʧ��\n", find);
				jOptionPane_LoginFeedback.showMessageDialog(this, "ѧ����Ϣ�޸�ʧ�ܣ�", "�� ʾ",
						jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
			}
		} catch (Exception ce) {
			System.out.println(ce.getMessage());
		}
	}

	// ��ʾ
	public void showstu() {
		if (find < 0) {
			return;
		} else {
			try {
				ResultSet rs = con.getRs("select * from tb_student where stuNumber='" + find + "' ");
				while (rs.next()) {
					number = rs.getString(2);
					name = rs.getString(3);
					sdepart = rs.getString(4);
					sspec = rs.getString(5);
					sclass = rs.getString(5);
				}
			} catch (Exception ce) {
				System.out.println(ce);
			}
			jTextField1.setText(number);
			jTextField2.setText(name);
			jComboBox4.setSelectedItem(sdepart);
			jComboBox5.addItem(sspec);
			jComboBox1.addItem(sclass);
		}
	}
}

class StudentUp_jButton2_actionAdapter implements ActionListener {
	private StudentChange adaptee;

	StudentUp_jButton2_actionAdapter(StudentChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton2_actionPerformed(e);
	}
}

class StudentUp_jButton1_actionAdapter implements ActionListener {
	private StudentChange adaptee;

	StudentUp_jButton1_actionAdapter(StudentChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jButton1_actionPerformed(e);
	}
}

class StudentUp_jComboBox5_actionAdapter implements ActionListener {
	private StudentChange adaptee;

	StudentUp_jComboBox5_actionAdapter(StudentChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jComboBox5_actionPerformed(e);
	}
}

class StudentUp_jComboBox4_actionAdapter implements ActionListener {
	private StudentChange adaptee;

	StudentUp_jComboBox4_actionAdapter(StudentChange adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jComboBox4_actionPerformed(e);
	}
}
