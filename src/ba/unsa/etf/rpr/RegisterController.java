package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    public Tooltip ttEmail;
    public Tooltip ttUsername;
    public Tooltip ttLastName;
    public Tooltip ttFirstName;
    public Tooltip ttPassword;

    private boolean containsUppercase = true;
    private boolean containsNumbers = true;
    private boolean containsEasilyGuessed = false;
    private boolean containsEmptyFields = false;
    private boolean containsFiveChars = true;

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


            if(!checkPassword(fldPassword.getText())) {
                ok = false;
                fldPassword.getStyleClass().removeAll("fieldOk");
                fldPassword.getStyleClass().add("fieldNotOk");
            }
            else {
                fldPassword.getStyleClass().removeAll("fieldNotOk");
                fldPassword.getStyleClass().add("fieldOk");
            }
            // dodaj i da je unique u bazi email i username
            if(fldUsername.getText().trim().isBlank()) {
                ok = false;
                fldUsername.getStyleClass().removeAll("fieldOk");
                fldUsername.getStyleClass().add("fieldNotOk");
            }
            else {
                fldUsername.getStyleClass().removeAll("fieldNotOk");
                fldUsername.getStyleClass().add("fieldOk");
            }
            if(fldLastName.getText().trim().isBlank()) {
                ok = false;
                fldLastName.getStyleClass().removeAll("fieldOk");
                fldLastName.getStyleClass().add("fieldNotOk");
            }
            else {
                fldLastName.getStyleClass().removeAll("fieldNotOk");
                fldLastName.getStyleClass().add("fieldOk");
            }
            if(fldFirstName.getText().trim().isBlank()) {
                ok = false;
                fldFirstName.getStyleClass().removeAll("fieldOk");
                fldFirstName.getStyleClass().add("fieldNotOk");
            }
            else {
                fldFirstName.getStyleClass().removeAll("fieldNotOk");
                fldFirstName.getStyleClass().add("fieldOk");
            }
            if(fldEmail.getText().trim().isBlank()) {
                ok = false;
                fldEmail.getStyleClass().removeAll("fieldOk");
                fldEmail.getStyleClass().add("fieldNotOk");
            }
            else {
                fldEmail.getStyleClass().removeAll("fieldNotOk");
                fldEmail.getStyleClass().add("fieldOk");
            }
        if(ok) {
            // dodaj u bazi
            // bolje je dodat neki context text uz field koji je pogresan a ne otvarat novi prozor al nek zasad stoji da sva polja pocrvene

            /*fldPassword.getStyleClass().removeAll("fieldNotOk");
            fldUsername.getStyleClass().removeAll("fieldNotOk");
            fldLastName.getStyleClass().removeAll("fieldNotOk");
            fldFirstName.getStyleClass().removeAll("fieldNotOk");
            fldEmail.getStyleClass().removeAll("fieldNotOk");
            fldPassword.getStyleClass().add("fieldOk");
            fldUsername.getStyleClass().add("fieldOk");
            fldLastName.getStyleClass().add("fieldOk");
            fldFirstName.getStyleClass().add("fieldOk");
            fldEmail.getStyleClass().add("fieldOk");
             */
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Registration is successful");
            alert.setContentText("You can proceed to login");
            alert.showAndWait();
            actionLogin();
        }
    }

    private boolean checkPassword(String text) {
        if(text.isBlank()) return false;
        boolean test = true;
        if(text.trim().length()<5) {
            containsFiveChars = false;
            test = false;
        }
        if(text.toLowerCase().equals(text)) {
            containsUppercase = false; // mozes skladno ovome mijenjat sadrzaj tooltip-a kako bi korisnik jos bolje znao sta je poslo po zlu, ovako nemaju smisla ova dodjeljivanja
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
