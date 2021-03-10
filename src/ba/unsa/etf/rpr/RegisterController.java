package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    private boolean containsEmptyFields = false;


    public void actionLogin() {
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
        if(fldEmail.getText().trim().isBlank() || fldFirstName.getText().trim().isBlank() || fldLastName.getText().trim().isBlank() || fldUsername.getText().trim().isBlank() || fldPassword.getText().trim().isBlank()) {
            containsEmptyFields = true;
            ok = false;
        }
        if(!checkPassword(fldPassword.getText())) ok = false;
        if(!ok) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Entered text fields do not meet the requirements");
            String content = new String("These requirements have not been satisfied: \n");
                if(containsEasilyGuessed) content+="Password should not contain first name or last name \n";
                if(!containsNumbers) content+="Password should contain at least one digit \n";
                if(!containsUppercase) content+="Password should contain at least one uppercase character \n";
                if(containsEmptyFields) content+="No field can remain empty \n";
            alert.setContentText(content);
            fldPassword.getStyleClass().removeAll("fieldOk");
            fldUsername.getStyleClass().removeAll("fieldOk");
            fldLastName.getStyleClass().removeAll("fieldOk");
            fldFirstName.getStyleClass().removeAll("fieldOk");
            fldEmail.getStyleClass().removeAll("fieldOk");
            fldPassword.getStyleClass().add("fieldNotOk");
            fldUsername.getStyleClass().add("fieldNotOk");
            fldLastName.getStyleClass().add("fieldNotOk");
            fldFirstName.getStyleClass().add("fieldNotOk");
            fldEmail.getStyleClass().add("fieldNotOk");
            alert.showAndWait();
        }
        else {
            // dodaj u bazi
            // bolje je dodat neki context text uz field koji je pogresan a ne otvarat novi prozor al nek zasad stoji da sva polja pocrvene
            fldPassword.getStyleClass().removeAll("fieldNotOk");
            fldUsername.getStyleClass().removeAll("fieldNotOk");
            fldLastName.getStyleClass().removeAll("fieldNotOk");
            fldFirstName.getStyleClass().removeAll("fieldNotOk");
            fldEmail.getStyleClass().removeAll("fieldNotOk");
            fldPassword.getStyleClass().add("fieldOk");
            fldUsername.getStyleClass().add("fieldOk");
            fldLastName.getStyleClass().add("fieldOk");
            fldFirstName.getStyleClass().add("fieldOk");
            fldEmail.getStyleClass().add("fieldOk");
            actionLogin();
        }
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
