package Projekt1.ControllersForTypeOfAcc.AdminController;

import Projekt1.DataBaseConnection.DataBaseConnection;
import com.github.javafaker.Faker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.xml.transform.Result;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;

public class aController {


    @FXML
    AnchorPane tableA;
    @FXML
    ImageView bimage;
    @FXML
    AnchorPane tableW;
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
    TableColumn<users, String> code_col;
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
    @FXML
    TextField Aname;
    @FXML
    TextField Asurname;
    @FXML
    TextField Apesel;
    @FXML
    TextField Adate;
    @FXML
    TextField Atelephone;
    @FXML
    TextField Aemail;
    @FXML
    Label codeLabel;
    ToggleGroup toggleGroup = new ToggleGroup();
    @FXML
    ToggleButton ButtonA;
    @FXML
    ToggleButton ButtonR;
    @FXML
    ToggleButton ButtonCh;
    @FXML
    ToggleButton ButtonD;
    @FXML
    Label submitLabel;
    @FXML
    Button generateCode;
    @FXML
    Button submitButton;

    int type = -1;

    ObservableList<users> listview = FXCollections.observableArrayList();


    @FXML
    public void initialize() {
        ButtonA.setToggleGroup(toggleGroup);
        ButtonR.setToggleGroup(toggleGroup);
        ButtonCh.setToggleGroup(toggleGroup);
        ButtonD.setToggleGroup(toggleGroup);


        bimage.setDisable(true);
        tableW.setDisable(false);
        bimage.setVisible(false);
        tableA.setDisable(true);
        tableA.setVisible(false);
        tableW.setVisible(true);


        try {
            DataBaseConnection connectNow = new DataBaseConnection();
            Connection connectDb = connectNow.getConnection();

            String sql = "SELECT * FROM personaldatapersonel, log_datapersonel WHERE log_datapersonel.id = personaldatapersonel.person_id";
            Statement statement = connectDb.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);


            while (resultSet.next()) {
                listview.add(new users(resultSet.getLong("id"), resultSet.getLong("account_type"),
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

    @FXML
    private void cancelOnAction(ActionEvent event) {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void addUserButton() {
        changeScene();
    }

    @FXML
    private void addUserOnAction() throws SQLException {
changeScene();

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDb = connectNow.getConnection();

        if (checkIfCodeIsGenerated() && checkIfTogglePressed() && validateIfFill()) {

            String sql = "INSERT INTO LOG_DATAPERSONEL (CODE, ACCOUNT_TYPE) VALUES(" + (codeLabel.getText()) + ", " + type + ");";
            String sql2 = "SELECT * FROM LOG_DATAPERSONEL";


            Statement statement = connectDb.createStatement();
            statement.executeUpdate(sql);
            ResultSet rs = statement.executeQuery(sql2);
            int id = 0;
            while(rs.next()){
                id++;
            }

            String sql1 = "INSERT INTO PERSONALDATAPERSONEL (person_id, email, date_of_birth, name, pesel, telephone, surname) VALUES ('" + (id) + "', '" + (Aemail.getText()) + "', '" +
                    Adate.getText() + "', '" + Aname.getText() + "', '" + Apesel.getText() + "', '" + Atelephone.getText() + "', '" +
                    Asurname.getText() + "');";

            statement.executeUpdate(sql1);
        }
    }


    private boolean validateIfFill() {
        if (!Aname.getText().trim().isBlank() && !Asurname.getText().trim().isEmpty() && !Apesel.getText().trim().isEmpty() &&
                !Adate.getText().trim().isEmpty() && !Atelephone.getText().trim().isEmpty() && !(Aemail.getText()).trim().isEmpty()) {
            return true;
        }
        submitLabel.setText("Fill form!");
        return false;
    }

    private boolean checkIfCodeIsGenerated() {
        if (!codeLabel.getText().isEmpty()) {
            return true;
        }
        submitLabel.setText("Please generate Code!");
        return false;

    }

    private void changeScene() {
        bimage.setDisable(false);
        bimage.setVisible(true);
        tableW.setDisable(true);
        tableW.setVisible(false);
        tableA.setDisable(false);
        tableA.setVisible(true);
    }

    private boolean checkIfTogglePressed() {
        if (toggleGroup.getSelectedToggle() != null) {
            return true;
        }
        submitLabel.setText("You need to choose account type!");
        return false;
    }


    @FXML
    private void buttonAAction() {
        if (ButtonA.isSelected()) {
            type = 4;

        }
    }

    @FXML
    private void buttonRAction() {
        if (ButtonR.isSelected()) {
            type = 5;

        }
    }

    @FXML
    private void buttonChAction() {
        if (ButtonCh.isSelected()) {
            type = 3;

        }
    }

    @FXML
    private void buttonDAction() {
        if (ButtonD.isSelected()) {
            type = 2;

        }
    }

    @FXML
    private void generatingCodeAndDisplayCode() {
        Faker faker = new Faker();
        String code = faker.code().gtin8();
        codeLabel.setText(code);
    }

}



