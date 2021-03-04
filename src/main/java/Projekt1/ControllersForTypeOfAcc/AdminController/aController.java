package Projekt1.ControllersForTypeOfAcc.AdminController;

import Projekt1.DataBaseConnection.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class aController {

    @FXML
    Button addButton;
    @FXML
    Button refreshButton;
    @FXML
    Button removeButton;
    @FXML
    TableView<users> tablew;
    @FXML
    TableColumn<users, Long> id_col;
    @FXML
    TableColumn<users, Long> at_col;
    @FXML
    TableColumn<users, String> code_cole;
    @FXML
    TableColumn<users, String> p_col;
    @FXML
    TableColumn<users, String> un_col;
    @FXML
    TableColumn<users, String> n_col;
    @FXML
    TableColumn<users, String> s_col;
    @FXML
    TableColumn<users, Long> psl_col;
    @FXML
    TableColumn<users, String> em_col;

    ObservableList<users> listview = FXCollections.observableArrayList();

 @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        at_col.setCellValueFactory(new PropertyValueFactory<>("accounttype"));
        code_cole.setCellValueFactory(new PropertyValueFactory<>("code"));
        p_col.setCellValueFactory(new PropertyValueFactory<>("password"));
        un_col.setCellValueFactory(new PropertyValueFactory<>("username"));
        n_col.setCellValueFactory(new PropertyValueFactory<>("name"));
        s_col.setCellValueFactory(new PropertyValueFactory<>("surname"));
        psl_col.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        em_col.setCellValueFactory(new PropertyValueFactory<>("email"));

        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDb = connectNow.getConnection();

            String sql = "SELECT * FROM personaldatapersonel, log_datapersonel WHERE log_datapersonel.id = personaldatapersonel.person_id GROUP BY log_datapersonel.id";
            Statement statement = connectDb.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getLong("id"));
                System.out.println(resultSet.getLong("account_type"));
                System.out.println(resultSet.getLong("pesel"));
                System.out.println(resultSet.getString("code"));
                System.out.println(resultSet.getString("password"));
                System.out.println(resultSet.getString("username"));
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("surname"));
                System.out.println(resultSet.getString("email"));
            }

            while (resultSet.next()) {
                listview.add(new users(resultSet.getLong("id"), resultSet.getLong("account_type"),
                        resultSet.getLong("pesel"), resultSet.getString("code"), resultSet.getString("password"),
                        resultSet.getString("username"), resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("email")));
            }
            tablew.setItems(listview);
        } catch (Exception e) {

        }

    }
    @FXML
    private void cancelOnAction(ActionEvent event) {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }
}



