package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUPController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button signupButton;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    void initialize() {
        signupButton.setOnAction(event -> {
            signUpNewUser();
            signupButton.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/sample.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    private void signUpNewUser() {
        Conection handler = new Conection();
        String firstname = name.getText();
        String lastname = surname.getText();
        String login = login_field.getText();
        String password = password_field.getText();

        User user = new User(firstname,lastname,login,password);
        handler.signupUser(user);
    }
}
