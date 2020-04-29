package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

public class Admin {

    @FXML
    private AnchorPane userLabel;

    @FXML
    private Text userLog;

    @FXML
    private TableView<ModelTable> MainTable;

    @FXML
    private TableColumn<ModelTable, String> col_id;

    @FXML
    private TableColumn<ModelTable, String> col_name;

    @FXML
    private TableColumn<ModelTable, String> col_surname;

    @FXML
    private TableColumn<ModelTable, String> col_login;

    @FXML
    private TableColumn<ModelTable, String> col_password;

    @FXML
    private TableColumn<ModelTable, String> col_privelege;

    @FXML
    private TableColumn<ModelTable, Integer> col_points;

    @FXML
    private TextField search_field;

    @FXML
    private Button search_button;
    @FXML
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    void initialize() {
        ResultSet rs;
        Connection con = Conection.getConnect();

        try {
            rs = con.createStatement().executeQuery("select * from users");
            while (rs.next()){
                oblist.add(new ModelTable(rs.getString("id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("login"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        col_id.setCellFactory( new PropertyValueFactory("id"));
        col_name.setCellFactory(new PropertyValueFactory("name"));
        col_surname.setCellFactory(new PropertyValueFactory("surname"));
        col_login.setCellFactory(new PropertyValueFactory("login"));
        col_password.setCellFactory(new PropertyValueFactory("password"));

        MainTable.setItems(oblist);

    }


}
