package ba.unsa.etf.rpr;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
@ExtendWith(ApplicationExtension.class)
class RegisterControllerTest {
    @Start
    public void start(Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("/fxml/register.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }
}



