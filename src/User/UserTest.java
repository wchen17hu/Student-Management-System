package User;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.awt.event.ActionEvent;


public class UserTest {
    @Test
	@DisplayName("Add User with empty username")
    void AddUserWithEmpty() {
        UserAddFrame userAddFrame = new UserAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userAddFrame.jTextField1.setText("");
        assertEquals("Username should not be empty", userAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add User with unmatched password")
    void AddUserWithUnmatch() {
        UserAddFrame userAddFrame = new UserAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userAddFrame.jTextField1.setText("newuser");
        userAddFrame.jPasswordField2.setText("123");
        userAddFrame.jPasswordField1.setText("1234");
        assertEquals("Password is incorrect", userAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add User with existing username")
    void AddUserWithExistUser() {
        UserAddFrame userAddFrame = new UserAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userAddFrame.jTextField1.setText("admin");
        userAddFrame.jPasswordField2.setText("123");
        userAddFrame.jPasswordField1.setText("123");
        assertEquals("The username already exists", userAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Add New User")
    void AddUser() {
        UserAddFrame userAddFrame = new UserAddFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userAddFrame.jTextField1.setText("test");
        userAddFrame.jPasswordField2.setText("123");
        userAddFrame.jPasswordField1.setText("123");
        assertEquals("Congratulations! User has been created successfully", userAddFrame.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Delete User with empty username")
    void DeleteUserWithEmpty() {
        UserDelete userDelete = new UserDelete();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userDelete.jTextField1.setText("");
        assertEquals("Username should not be empty!", userDelete.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Delete User with non-existing username")
    void DeleteUserWithNotExist() {
        UserDelete userDelete = new UserDelete();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userDelete.jTextField1.setText("eeee");
        assertEquals("The username doesn't exist!", userDelete.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Delete Admin User")
    void DeleteAdminUser() {
        UserDelete userDelete = new UserDelete();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userDelete.jTextField1.setText("admin");
        assertEquals("You cannot delete admin user!", userDelete.jButton1_actionPerformed(event));
    }

    @Test
	@DisplayName("Delete User")
    void DeleteUser() {
        UserDelete userDelete = new UserDelete();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        userDelete.jTextField1.setText("test");
        assertEquals("Congratulations! You have successfully deleted the user!", userDelete.jButton1_actionPerformed(event));
    }

}
