package Student;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.awt.event.ActionEvent;


public class StudentTest {
    @Test
	@DisplayName("Search Student by ID with empty ID")
    void searchStudentByID_Empty() {
        StudentManager studentManager = new StudentManager();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        studentManager.jTextField1.setText("");
        assertEquals("Please type in student's ID", studentManager.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Search Student by ID with ID")
    void searchStudentByID() {
        StudentManager studentManager = new StudentManager();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        studentManager.jTextField1.setText("3001");
        assertEquals("Find student", studentManager.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Student With Empty ID")
    void AddStudentWithEmptyID() {
        StudentInfoAddFrame studentInfoAddFrame = new StudentInfoAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        studentInfoAddFrame.jTextField1.setText("");
        assertEquals("Please input Student ID!", studentInfoAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Student With Empty Name")
    void AddStudentWithEmptyName() {
        StudentInfoAddFrame studentInfoAddFrame = new StudentInfoAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);

        studentInfoAddFrame.jTextField1.setText("4001");
        studentInfoAddFrame.jTextField2.setText("");
        assertEquals("Please input Student Name!", studentInfoAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Student With Empty Department")
    void AddStudentWithEmptyDepartment() {
        StudentInfoAddFrame studentInfoAddFrame = new StudentInfoAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);

        studentInfoAddFrame.jTextField1.setText("4001");
        studentInfoAddFrame.jTextField2.setText("TestName");
        studentInfoAddFrame.jComboBox4.setSelectedIndex(0);
        assertEquals("Please select Student Department!", studentInfoAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Student With Empty Major")
    void AddStudentWithEmptyMajor() {
        StudentInfoAddFrame studentInfoAddFrame = new StudentInfoAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);

        studentInfoAddFrame.jTextField1.setText("4001");
        studentInfoAddFrame.jTextField2.setText("TestName");
        studentInfoAddFrame.jComboBox4.setSelectedIndex(1);
        studentInfoAddFrame.jComboBox5.setSelectedIndex(0);
        assertEquals("Please select Student Major!", studentInfoAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Student With Empty Class")
    void AddStudentWithEmptyClass() {
        StudentInfoAddFrame studentInfoAddFrame = new StudentInfoAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);

        studentInfoAddFrame.jTextField1.setText("4001");
        studentInfoAddFrame.jTextField2.setText("TestName");
        studentInfoAddFrame.jComboBox4.setSelectedIndex(1);
        studentInfoAddFrame.jComboBox5.setSelectedIndex(1);
        studentInfoAddFrame.jComboBox1.setSelectedIndex(0);
        assertEquals("Please select Student Class!", studentInfoAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add New Student")
    void AddStudent() {
        StudentInfoAddFrame studentInfoAddFrame = new StudentInfoAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);

        studentInfoAddFrame.jTextField1.setText("4001");
        studentInfoAddFrame.jTextField2.setText("TestName");
        studentInfoAddFrame.jComboBox4.setSelectedIndex(1);
        studentInfoAddFrame.jComboBox5.setSelectedIndex(1);
        studentInfoAddFrame.jComboBox1.setSelectedIndex(1);
        assertEquals("Add Successfully", studentInfoAddFrame.jButton1_actionPerformed(event));
    }
}
