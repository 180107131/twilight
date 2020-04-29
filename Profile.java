package sample;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Profile {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane userLab;

    @FXML
    private Text userLog;

    @FXML
    private Text points;

    @FXML
    private Button saveB;

    @FXML
    private TextField nameC;

    @FXML
    private TextField surnameC;

    @FXML
    private TextField loginC;

    @FXML
    private TextField passwordC;

    @FXML
    void initialize() {
        Connection connect = Conection.getConnect();
        saveB.setOnAction(event -> {
            try {
                String query = "UPDATE users SET firstname=?, lastname=?, login=?,password=? where login='"+Controller.Communication.communicateLogIn+"'";
                PreparedStatement prst = connect.prepareStatement(query);
                prst.setString(1,nameC.getText());
                prst.setString(2,surnameC.getText());
                prst.setString(3,loginC.getText());
                prst.setString(4,passwordC.getText());
                prst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            saveB.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/todopage.fxml"));
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
}
