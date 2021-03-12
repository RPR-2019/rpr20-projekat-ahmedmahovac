package ba.unsa.etf.rpr;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(ApplicationExtension.class)
class RegisterControllerTest {
    @Start
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("/fxml/register.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
    @Test
    public void basicFuncTest(FxRobot fxRobot) {
        Button btnLogin = fxRobot.lookup("#btnLogin").queryAs(Button.class);
        assertNotNull(btnLogin);
        Button btnCancel = fxRobot.lookup("#btnCancel").queryAs(Button.class);
        assertNotNull(btnCancel);
        TextField fldUsername = fxRobot.lookup("#fldUsername").queryAs(TextField.class);
        assertNotNull(fldUsername);
        TextField fldFirstName = fxRobot.lookup("#fldFirstName").queryAs(TextField.class);
        assertNotNull(fldFirstName);
        TextField fldLastName = fxRobot.lookup("#fldLastName").queryAs(TextField.class);
        assertNotNull(fldLastName);
        TextField fldEmail = fxRobot.lookup("#fldEmail").queryAs(TextField.class);
        assertNotNull(fldEmail);
        PasswordField fldPassword = fxRobot.lookup("#fldPassword").queryAs(PasswordField.class);
        assertNotNull(fldPassword);
        // dodaj jos malo opsirnije testove za validaciju
        fxRobot.clickOn("#btnLogin");
        Button OkOnDialog = fxRobot.lookup("OK").queryAs(Button.class);
        assertNull(OkOnDialog);
        fxRobot.clickOn("#fldUsername");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("Ahmed");
        fxRobot.clickOn("#fldFirstName");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("Ahmed");
        fxRobot.clickOn("#fldLastName");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("Ahmed");
        fxRobot.clickOn("#fldEmail");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("Ahmed");
        fxRobot.clickOn("#fldPassword");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("ahmA12");
        OkOnDialog = fxRobot.lookup("OK").queryAs(Button.class);
        assertNotNull(OkOnDialog);
        fxRobot.clickOn("OK");
        fxRobot.clickOn("#btnLoginMenu");
        Button btnRegisterMenu = fxRobot.lookup("#btnRegisterMenu").queryAs(Button.class);
        assertNotNull(btnRegisterMenu);
    }
}



