package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Todopage {
    User user;

    @FXML
    private TextField addEvent;

    @FXML
    private Button addbutton;

    @FXML
    private VBox vbox;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mylistPane;

    @FXML
    private GridPane paneG;

    @FXML
    private TextField username;

    @FXML
    private Button myday;

    @FXML
    private Button todo;

    @FXML
    private VBox hbox;

    @FXML
    private Pane addpane;

    @FXML
    private Button add;

    @FXML
    private TextField namelist;

    @FXML
    private Button newlist;
    int i = 0;
    @FXML
    private Button nameofList;
    @FXML
    private Pane paneadd;
    @FXML
    private Text userLog;
    @FXML
    private Button editPage;

    @FXML
    private AnchorPane ortasy;
    @FXML
    void initialize() {
        editPage.setOnMouseClicked(event -> {
            mylistPane.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/sample/profile.fxml"));
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
        userLog.setText(Controller.Communication.communicateLogIn);
        newlist.setOnMouseClicked(event -> {

                paneadd.setVisible(false);
                Button buttonList = new Button();
                buttonList.setText(namelist.getText());
                buttonList.setContentDisplay(ContentDisplay.LEFT);
                buttonList.setMaxWidth(500);
                buttonList.setMinWidth(paneG.getWidth()-1);
                buttonList.setPrefWidth(paneG.getWidth()-1);
                buttonList.setStyle("-fx-border-color: silver;-fx-background-color: white");
                buttonList.setMaxHeight(36);
                hbox.getChildren().add(buttonList);
                buttonList.setContentDisplay(ContentDisplay.LEFT);
                buttonList.setFont(Font.font("Tw Cen MT Condensed Extra Bold",18));
                buttonList.setLayoutY(todo.getLayoutY()+36);




        });
        nameofList.setOnMouseClicked(event -> {
            paneadd.setVisible(true);
        });
        addbutton.setOnMouseClicked(event -> {
            Button buttonList = new Button();
            buttonList.setText(addEvent.getText());
            buttonList.setContentDisplay(ContentDisplay.LEFT);
            buttonList.setMaxWidth(500);
            buttonList.setMinWidth(vbox.getWidth()-1);
            buttonList.setPrefWidth(vbox.getWidth()-1);
            buttonList.setStyle("-fx-border-color: silver;-fx-background-color: white");
            vbox.getChildren().add(buttonList);
            buttonList.setContentDisplay(ContentDisplay.LEFT);
            buttonList.setFont(Font.font("Tw Cen MT Condensed Extra Bold",18));
            buttonList.setLayoutY(buttonList.getLayoutY()+36);
        });
    }
}
