package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {
    public Button btnLoginMenu;
    public TextField fldEmail;
    public TextField fldUsername;
    public TextField fldLastName;
    public TextField fldFirstName;
    public PasswordField fldPassword;

    private boolean containsUppercase = true;
    private boolean containsNumbers = true;
    private boolean containsEasilyGuessed = false;

    public void actionLogin(ActionEvent actionEvent) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = (Stage)(btnLoginMenu.getScene().getWindow());
        stage.setScene(new Scene(root, Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE));
    }


    public void actionRegister(ActionEvent actionEvent) {
        // dodati provjeru unikatnosti emaila i usernamea
        boolean ok = true;
        if(fldEmail.getText().trim().isBlank() || fldFirstName.getText().trim().isBlank() || fldLastName.getText().trim().isBlank() || fldUsername.getText().trim().isBlank() || fldPassword.getText().trim().isBlank()) ok = false;
        else if(!checkPassword(fldPassword.getText())) ok = false;

    }

    private boolean checkPassword(String text) {
        boolean test = true;
        if(text.toLowerCase().equals(text)) {
            containsUppercase = false;
            test = false; // doesn't contain any uppercase
        }
        if(!containsDigit(text)) {
            containsNumbers = false;
            test = false;
        }
        if(text.toLowerCase().contains(fldFirstName.getText().toLowerCase()) || text.toLowerCase().contains(fldLastName.getText().toLowerCase())) {
            containsEasilyGuessed = true;
            test = false;
        }
        return test;
    }


    private boolean containsDigit(String s) {
        boolean containsDigit = false;
        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

}
