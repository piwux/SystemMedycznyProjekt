package Projekt1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import Projekt1.DataBaseConnection.DataBaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class LoginController {
    @FXML
    private Button CancelButton;
    @FXML
    private Label WrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button LoginButton;
    @FXML
    private Hyperlink ForgetPassword;
    @FXML
    private Hyperlink RegisterButton;


    @FXML
    private void cancelOnAction(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void registerButtonOnAction(ActionEvent event) throws IOException {
        App m = new App();
        m.changeScene("register.fxml", 1042, 664);


    }

    @FXML
    private void checkLogin() throws IOException, InterruptedException, SQLException {
        if (!username.getText().isBlank() && !password.getText().isBlank()) {
            validateLogin();
        }
        else {
            WrongLogin.setText("Please enter your username and password");
        }

    }

    public void validateLogin() throws IOException, SQLException {
        App m = new App();
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDb = connectNow.getConnection();


        redirectAfterValidateLogin((new TypesOfAccount(1,"patient")),m,connectDb);
        redirectAfterValidateLoginV2((new TypesOfAccount(2,"doctor")),m,connectDb);
        redirectAfterValidateLoginV2((new TypesOfAccount(3,"apothecary")),m,connectDb);
        redirectAfterValidateLoginV2((new TypesOfAccount(4,"admin")),m,connectDb);
        redirectAfterValidateLoginV2((new TypesOfAccount(5,"receptionist")),m,connectDb);


        connectDb.close();



    }

    public void redirectAfterValidateLogin(TypesOfAccount typ, App m, Connection connectDb) throws IOException, SQLException {
        String verifyLogin = "SELECT count(*) FROM log_datapatient WHERE username = '" + username.getText() + "' AND password ='" + password.getText() + "' "+ "AND account_type ='" + typ.getNumber() + "'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1){
                    WrongLogin.setText("Succes!");
                    m.changeScene(typ.getFxml() + ".fxml", 1366, 768);
                    //making session file

                } else{
                    WrongLogin.setText("Invalid login. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }


    public void redirectAfterValidateLoginV2(TypesOfAccount typ, App m, Connection connectDb) throws IOException, SQLException {
        String verifyLogin = "SELECT count(*) FROM log_datapersonel WHERE username = '" + username.getText() + "' AND password ='" + password.getText() + "' "+ "AND account_type ='" + typ.getNumber() + "'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);
            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1){
                    WrongLogin.setText("Succes!");
                    m.changeScene(typ.getFxml() + ".fxml", 1366, 768);
                    //making session file

                } else{
                    WrongLogin.setText("Invalid login. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

 public void makeSessionFile(Connection connection){

 }
}

