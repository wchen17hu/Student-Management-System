package stuManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.*;

import Class.ClassAddFrame;
import Class.ClassManager;
import Cource.CourceAddFrame;
import Cource.CourceManager;
import Depart.DepartAddFrame;
import Depart.DepartManager;
import Score.ScoreAddFrame;
import Score.ScoreManager;
import Student.StudentInfoAddFrame;
import Student.StudentManager;
import User.UserAddFrame;
import User.UserDelete;
import User.UserPasswordFrame;


public class MainFrame extends JFrame {
	JPanel contentPane;
	public static String level;
	static String name;
	
	URL url = getClass().getResource("/img/bg_1.jpg");
	ImageIcon mainBg = new ImageIcon(url);
	
	JLabel jLabel_welcomeTitle = new JLabel();
	JLabel jLabel_welcomeTitle2 = new JLabel();
	JLabel jLabel_help1 = new JLabel();
	JLabel jLabel_help2 = new JLabel();
	JLabel jLabel_help3 = new JLabel();

	JMenuBar jMenuBar = new JMenuBar();

	JMenu jMenu_stuManager = new JMenu();
	JMenuItem jMenuItem_stuInfoSignUp = new JMenuItem();
	JMenuItem jMenuItem_stuInfoInquire = new JMenuItem();

	JMenu jMenu_classManager = new JMenu();
	JMenuItem jMenuItem_classInput = new JMenuItem();
	JMenuItem jMenuItem_classManager = new JMenuItem();

	JMenu jMenu_departManager = new JMenu();
	JMenuItem jMenuItem_departInput = new JMenuItem();
	JMenuItem jMenuItem_departManager = new JMenuItem();

	JMenu jMenu_courceManager = new JMenu();
	JMenuItem jMenuItem_courceInput = new JMenuItem();
	JMenuItem jMenuItem_courceManager = new JMenuItem();

	JMenu jMenu_scoreManager = new JMenu();
	JMenuItem jMenuItem_scoreInput = new JMenuItem();
	JMenuItem jMenuItem_scoreManager = new JMenuItem();

	JMenu jMenu_userManager = new JMenu();
	JMenuItem jMenuItem_userSignUp = new JMenuItem();
	JMenuItem jMenuItem_userChangePwd = new JMenuItem();
	JMenuItem jMenuItem_userDelete = new JMenuItem();

	JMenu jMenu_about = new JMenu();
	JMenuItem jMenuItem_about = new JMenuItem();

	JMenu jMenu_quit = new JMenu();
	JMenuItem jMenuItem_quit = new JMenuItem();
	JMenuItem jMenuItem_reboot = new JMenuItem();

	JPanel jPane_box = new JPanel();
	JLabel jLabe_mainBgBox = new JLabel();
	BorderLayout borderLayout = new BorderLayout();
	JOptionPane jOptionPane_LoginFeedback = new JOptionPane();

	public MainFrame(String level, String name) {

		this.level = level;
		this.name = name;
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			jbInit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		contentPane = (JPanel) getContentPane();
		contentPane.setLayout(null);
		this.setJMenuBar(jMenuBar);
		setSize(new Dimension(100, 850));
		setTitle("Welcome Student Management System");

		jLabel_welcomeTitle.setText("Welcome Student Management System");
		jLabel_welcomeTitle.setBounds(new Rectangle(180, 130, 1200, 33));
		jLabel_welcomeTitle.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
		jLabel_welcomeTitle.setForeground(Color.lightGray);

		jLabel_welcomeTitle2.setFont(new java.awt.Font("Dialog", Font.BOLD, 30));
		jLabel_welcomeTitle2.setText("Welcome Student Management System");
		jLabel_welcomeTitle2.setBounds(new Rectangle(181, 131, 1200, 33));

		jLabel_help1.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		jLabel_help1.setText("The following: ");
		jLabel_help1.setBounds(new Rectangle(500, 340, 400, 30));
		
		jLabel_help2.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		jLabel_help2.setText("student, class, department, course, grade");
		jLabel_help2.setBounds(new Rectangle(500, 370, 550, 30));
		
		jLabel_help3.setFont(new java.awt.Font("Dialog", Font.BOLD, 20));
		jLabel_help3.setText("can be added, searched, modified or deleted");
		jLabel_help3.setBounds(new Rectangle(500, 400, 550, 30));
		
		jMenu_stuManager.setText("Student Management");
		jMenuItem_stuInfoSignUp.setText("Add");
		jMenuItem_stuInfoSignUp.addActionListener(new MainFrame_jMenuItem_stuInfoSignUp_actionAdapter(this));
		jMenuItem_stuInfoInquire.setText("Manage");
		jMenuItem_stuInfoInquire.addActionListener(new MainFrame_jMenuItem_stuInfoInquire_actionAdapter(this));

		jMenu_classManager.setText("Class Management");
		jMenuItem_classInput.setText("Add");
		jMenuItem_classInput.addActionListener(new MainFrame_jMenuItem_classInput_actionAdapter(this));
		jMenuItem_classManager.setText("Manage");
		jMenuItem_classManager.addActionListener(new MainFrame_jMenuItem_classManager_actionAdapter(this));

		jMenu_departManager.setText("Department Management");
		jMenuItem_departInput.setText("Add");
		jMenuItem_departInput.addActionListener(new MainFrame_jMenuItem_departInput_actionAdapter(this));
		jMenuItem_departManager.setText("Manage");
		jMenuItem_departManager.addActionListener(new MainFrame_jMenuItem_departManager_actionAdapter(this));

		jMenu_courceManager.setText("Course Management");
		jMenuItem_courceInput.setText("Add");
		jMenuItem_courceInput.addActionListener(new MainFrame_jMenuItem_courceInput_actionAdapter(this));
		jMenuItem_courceManager.setText("Manage");
		jMenuItem_courceManager.addActionListener(new MainFrame_jMenuItem_courceManager_actionAdapter(this));

		jMenu_scoreManager.setText("Grade Management");
		jMenuItem_scoreInput.setText("Add");
		jMenuItem_scoreInput.addActionListener(new MainFrame_jMenuItem_scoreInput_actionAdapter(this));
		jMenuItem_scoreManager.setText("Manage");
		jMenuItem_scoreManager.addActionListener(new MainFrame_jMenuItem_scoreManager_actionAdapter(this));

		jMenu_userManager.setText("User Management");
		jMenuItem_userSignUp.setText("Add User");
		jMenuItem_userSignUp.addActionListener(new MainFrame_jMenuItem_userSignUp_actionAdapter(this));
		jMenuItem_userChangePwd.setText("Change Password");
		jMenuItem_userChangePwd.addActionListener(new MainFrame_jMenuItem_userChangePwd_actionAdapter(this));
		jMenuItem_userDelete.setEnabled(true);
		jMenuItem_userDelete.setText("Delete User");
		jMenuItem_userDelete.addActionListener(new MainFrame_jMenuItem_userDelete_actionAdapter(this));

		jMenu_about.setText("About");
		jMenuItem_about.setText("About");
		jMenuItem_about.addActionListener(new MainFrame_jMenuItem_about_actionAdapter(this));

		jMenu_quit.setText("Exit");
		jMenuItem_quit.setText("Exit");
		jMenuItem_quit.addActionListener(new MainFrame_jMenuItem_quit_actionAdapter(this));
		jMenuItem_reboot.setText("Restart");
		jMenuItem_reboot.addActionListener(new MainFrame_jMenuItem_reboot_actionAdapter(this));

		jPane_box.setBounds(new Rectangle(0, 0, 1100, 850));
		jPane_box.setLayout(borderLayout);
		jLabe_mainBgBox.setIcon(mainBg);

		contentPane.add(jLabel_welcomeTitle2);
		contentPane.add(jLabel_welcomeTitle);
		contentPane.add(jLabel_help1);
		contentPane.add(jLabel_help2);
		contentPane.add(jLabel_help3);
		contentPane.add(jPane_box);

		jPane_box.add(jLabe_mainBgBox, java.awt.BorderLayout.NORTH);

		jMenuBar.add(jMenu_stuManager);
		jMenuBar.add(jMenu_classManager);
		jMenuBar.add(jMenu_departManager);
		jMenuBar.add(jMenu_courceManager);
		jMenuBar.add(jMenu_scoreManager);
		jMenuBar.add(jMenu_userManager);
		jMenuBar.add(jMenu_about);
		jMenuBar.add(jMenu_quit);

		jMenu_stuManager.add(jMenuItem_stuInfoSignUp);
		jMenu_stuManager.add(jMenuItem_stuInfoInquire);

		jMenu_classManager.add(jMenuItem_classInput);
		jMenu_classManager.add(jMenuItem_classManager);

		jMenu_departManager.add(jMenuItem_departInput);
		jMenu_departManager.add(jMenuItem_departManager);

		jMenu_courceManager.add(jMenuItem_courceInput);
		jMenu_courceManager.add(jMenuItem_courceManager);

		jMenu_scoreManager.add(jMenuItem_scoreInput);
		jMenu_scoreManager.add(jMenuItem_scoreManager);

		jMenu_userManager.add(jMenuItem_userSignUp);
		jMenu_userManager.add(jMenuItem_userDelete);
		jMenu_userManager.add(jMenuItem_userChangePwd);

		jMenu_about.add(jMenuItem_about);

		jMenu_quit.add(jMenuItem_quit);
		jMenu_quit.add(jMenuItem_reboot);


		if (level.equals("1")) {

		}
		else if (level.equals("2")) {
			this.jMenuItem_userSignUp.setVisible(false);
			this.jMenuItem_userDelete.setVisible(false);
			this.jMenuItem_stuInfoSignUp.setVisible(false);
			this.jMenuItem_classInput.setVisible(false);
			this.jMenuItem_departInput.setVisible(false);
			this.jMenuItem_courceInput.setVisible(false);
			this.jMenuItem_scoreInput.setVisible(false);
		}
	}

	public void jMenuItem_about_actionPerformed(ActionEvent e) {
		jOptionPane_LoginFeedback.showMessageDialog(this, "Student Management System\n Version: 1.0",
				"About", jOptionPane_LoginFeedback.INFORMATION_MESSAGE);
	}

	public void jMenuItem_quit_actionPerformed(ActionEvent e) {
		System.exit(0);
	}

	public void jMenuItem_reboot_actionPerformed(ActionEvent e) {
		this.dispose();
		LoginFrame login = new LoginFrame();
		login.setLocation(400, 200);
		login.setSize(504, 344);
		login.setVisible(true);
		login.setResizable(false);
		login.validate();
	}

	public void jMenuItem_stuInfoSignUp_actionPerformed(ActionEvent e) {
		StudentInfoAddFrame siadd = new StudentInfoAddFrame();
		siadd.setLocation(400, 200);
		siadd.setSize(592, 350);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_stuInfoInquire_actionPerformed(ActionEvent e) {
		StudentManager siadd = new StudentManager();
		siadd.setLocation(250, 60);
		siadd.setSize(800, 620);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_classInput_actionPerformed(ActionEvent e) {
		ClassAddFrame siadd = new ClassAddFrame();
		siadd.setLocation(400, 200);
		siadd.setSize(465, 310);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_classManager_actionPerformed(ActionEvent e) {
		ClassManager siadd = new ClassManager();
		siadd.setLocation(400, 100);
		siadd.setSize(530, 560);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_departInput_actionPerformed(ActionEvent e) {
		DepartAddFrame siadd = new DepartAddFrame();
		siadd.setLocation(400, 200);
		siadd.setSize(465, 310);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_departManager_actionPerformed(ActionEvent e) {
		DepartManager siadd = new DepartManager();
		siadd.setLocation(400, 100);
		siadd.setSize(530, 560);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_courceInput_actionPerformed(ActionEvent e) {
		CourceAddFrame siadd = new CourceAddFrame();
		siadd.setLocation(400, 200);
		siadd.setSize(482, 320);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_courceManager_actionPerformed(ActionEvent e) {
		CourceManager siadd = new CourceManager();
		siadd.setLocation(400, 100);
		siadd.setSize(530, 560);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_scoreInput_actionPerformed(ActionEvent e) {
		ScoreAddFrame siadd = new ScoreAddFrame();
		siadd.setLocation(400, 200);
		siadd.setSize(482, 320);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();

	}

	public void jMenuItem_scoreManager_actionPerformed(ActionEvent e) {
		ScoreManager siadd = new ScoreManager();
		siadd.setLocation(400, 100);
		siadd.setSize(550, 560);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_userSignUp_actionPerformed(ActionEvent e) {
		UserAddFrame siadd = new UserAddFrame();
		siadd.setLocation(400, 200);
		siadd.setSize(469, 315);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_userDelete_actionPerformed(ActionEvent e) {
		UserDelete siadd = new UserDelete();
		siadd.setLocation(400, 200);
		siadd.setSize(444, 280);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}

	public void jMenuItem_userChangePwd_actionPerformed(ActionEvent e) {
		UserPasswordFrame siadd = new UserPasswordFrame(level, name);
		siadd.setLocation(400, 200);
		siadd.setSize(444, 340);
		siadd.setVisible(true);
		siadd.setResizable(false);
		siadd.validate();
	}
}

class MainFrame_jMenuItem_courceManager_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_courceManager_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_courceManager_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_scoreManager_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_scoreManager_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_scoreManager_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_stuInfoInquire_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_stuInfoInquire_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_stuInfoInquire_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_classManager_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_classManager_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_classManager_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_classInput_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_classInput_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_classInput_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_departManager_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_departManager_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_departManager_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_departInput_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_departInput_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_departInput_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_courceInput_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_courceInput_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_courceInput_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_scoreInput_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_scoreInput_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_scoreInput_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_userSignUp_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_userSignUp_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {

		adaptee.jMenuItem_userSignUp_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_userChangePwd_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_userChangePwd_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_userChangePwd_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_userDelete_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_userDelete_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_userDelete_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_about_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_about_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_about_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_quit_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_quit_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_quit_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_stuInfoSignUp_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_stuInfoSignUp_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_stuInfoSignUp_actionPerformed(e);
	}
}

class MainFrame_jMenuItem_reboot_actionAdapter implements ActionListener {
	private MainFrame adaptee;

	MainFrame_jMenuItem_reboot_actionAdapter(MainFrame adaptee) {
		this.adaptee = adaptee;
	}

	public void actionPerformed(ActionEvent e) {
		adaptee.jMenuItem_reboot_actionPerformed(e);
	}
}
