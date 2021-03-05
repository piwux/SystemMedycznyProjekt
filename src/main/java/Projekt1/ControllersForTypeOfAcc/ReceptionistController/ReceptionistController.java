package Projekt1.ControllersForTypeOfAcc.ReceptionistController;

import Projekt1.DataBaseConnection.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReceptionistController {

    @FXML
    AnchorPane tableA;
    @FXML
    ImageView bimage;
    @FXML
    AnchorPane tableW;
    @FXML
    TableView<usersp> tablew;
    @FXML
    TableColumn<usersp, Long> id_col;
    @FXML
    TableColumn<usersp, Long> at_col;
    @FXML
    TableColumn<usersp, String> code_col;
    @FXML
    TableColumn<usersp, String> p_col;
    @FXML
    TableColumn<usersp, String> un_col;
    @FXML
    TableColumn<usersp, String> n_col;
    @FXML
    TableColumn<usersp, String> s_col;
    @FXML
    TableColumn<usersp, Long> psl_col;
    @FXML
    TableColumn<usersp, String> em_col;

    ObservableList<usersp> listview = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        bimage.setDisable(true);
        tableW.setDisable(false);
        bimage.setVisible(false);
        tableA.setDisable(true);
        tableA.setVisible(false);
        tableW.setVisible(true);


        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDb = connectNow.getConnection();

            String sql = "SELECT * FROM personaldata, log_datapatient WHERE log_datapatient.id = personaldata.person_id";
            Statement statement = connectDb.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                listview.add(new usersp(resultSet.getLong("id"), resultSet.getLong("account_type"),
                        resultSet.getLong("pesel"), resultSet.getString("code"), resultSet.getString("password"),
                        resultSet.getString("username"), resultSet.getString("name"), resultSet.getString("surname"),
                        resultSet.getString("email")));
            }
            tablew.setItems(listview);

            id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
            at_col.setCellValueFactory(new PropertyValueFactory<>("accounttype"));
            code_col.setCellValueFactory(new PropertyValueFactory<>("code"));
            p_col.setCellValueFactory(new PropertyValueFactory<>("password"));
            un_col.setCellValueFactory(new PropertyValueFactory<>("username"));
            n_col.setCellValueFactory(new PropertyValueFactory<>("name"));
            s_col.setCellValueFactory(new PropertyValueFactory<>("surname"));
            psl_col.setCellValueFactory(new PropertyValueFactory<>("pesel"));
            em_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
