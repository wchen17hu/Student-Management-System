package stuManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stuManager.LoginFrame;
import java.awt.event.ActionEvent;


public class LoginTest {
    @Test
	@DisplayName("Login fail with empty username")
    void loginWithEmptyUsername() {
        LoginFrame lf = new LoginFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        lf.jTextField_userName.setText("");
        assertEquals("Username should not be empty!", lf.jButton_Login_actionPerformed(event));
    }

    @Test
	@DisplayName("Login fail with incorrect username and password")
    void loginWithIncorrectUsername() {
        LoginFrame lf = new LoginFrame();
        int uniqueId = 1;
        String commandName = ""; 
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        lf.jTextField_userName.setText("test");
        assertEquals("Username or Password is wrong!", lf.jButton_Login_actionPerformed(event));
    }

    @Test
	@DisplayName("Login success")
    void loginWithCorrectUsername() {
        LoginFrame lf = new LoginFrame();
        int uniqueId = 1;
        String commandName = "";
        ActionEvent event = new ActionEvent(this, uniqueId, commandName);
        lf.jTextField_userName.setText("test");
        lf.jPasswordField_pwd.setText("bbb");
        assertEquals("", lf.jButton_Login_actionPerformed(event));
    }
}

