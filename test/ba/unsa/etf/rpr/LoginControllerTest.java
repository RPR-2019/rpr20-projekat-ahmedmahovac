package ba.unsa.etf.rpr;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)
class LoginControllerTest {
    @Start
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("/fxml/login.fxml"));
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
        fxRobot.clickOn("#fldUsername");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("Ahmed");
        fxRobot.clickOn("#fldUsername");
        fxRobot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        fxRobot.write("Abdulah");
        assertEquals(fldUsername.getText(), "Abdulah");
        Button btnRegister = fxRobot.lookup("#btnRegisterMenu").queryAs(Button.class);
        assertNotNull(btnRegister);
        fxRobot.clickOn("#btnRegisterMenu");
        Button btnLoginMenu = fxRobot.lookup("#btnLoginMenu").queryAs(Button.class);
        assertNotNull(btnLoginMenu);
    }

    // testove za validnost unesenih login podataka dodati kasnije


}