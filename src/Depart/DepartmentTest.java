package Depart;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.awt.event.ActionEvent;


public class DepartmentTest {
    @Test
	@DisplayName("Add Department with empty department")
    void AddDepartmentWithEmptyDepartment() {
        DepartAddFrame departAddFrame = new DepartAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departAddFrame.jComboBox1.setSelectedIndex(0);
        assertEquals("Please select the department!", departAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Department with empty major")
    void AddDepartmentWithEmptyMajor() {
        DepartAddFrame departAddFrame = new DepartAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departAddFrame.jComboBox1.setSelectedIndex(1);
        departAddFrame.jComboBox2.setSelectedIndex(0);
        assertEquals("Please select the major!", departAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add Department with existing department and major")
    void AddDepartmentWithExistingDepartmentMajor() {
        DepartAddFrame departAddFrame = new DepartAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departAddFrame.jComboBox1.setSelectedIndex(6);
        departAddFrame.jComboBox2.setSelectedIndex(1);
        assertEquals("The department and major already exist!", departAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add New Department with new major")
    void AddNewDepartment() {
        DepartAddFrame departAddFrame = new DepartAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departAddFrame.jComboBox1.setSelectedIndex(6);
        departAddFrame.jComboBox2.setSelectedIndex(1);
        assertEquals("Congratulations! Department has been added successfully!", departAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Modify department with empty department")
    void ModifyDepartmentWithEmptyDepartment() {
        DepartChange departChange = new DepartChange("3");
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departChange.jComboBox1.setSelectedIndex(0);
        departChange.jComboBox2.setSelectedIndex(0);
        assertEquals("Please select department!", departChange.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Modify department with empty major")
    void ModifyDepartmentWithEmptyMajor() {
        DepartChange departChange = new DepartChange("3");
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departChange.jComboBox1.setSelectedIndex(1);
        departChange.jComboBox2.setSelectedIndex(0);
        assertEquals("Please select major!", departChange.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Modify Department to existing department and major")
    void ModifyDepartmentWithExistingDepartmentMajor() {
        DepartChange departChange = new DepartChange("3");
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departChange.jComboBox1.setSelectedIndex(1);
        departChange.jComboBox2.setSelectedIndex(1);
        assertEquals("The department and major already exist!", departChange.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Modify Department to new department and major")
    void ModifyDepartmentWithNewDepartmentMajor() {
        DepartChange departChange = new DepartChange("3");
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        departChange.jComboBox1.setSelectedIndex(7);
        departChange.jComboBox2.setSelectedIndex(1);
        assertEquals("Congratulations! Department has been modified successfully", departChange.jButton1_actionPerformed(event));
    }

}