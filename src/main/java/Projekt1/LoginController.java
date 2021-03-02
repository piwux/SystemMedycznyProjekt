package Projekt1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
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
    private void checkLogin() throws IOException, InterruptedException {
        if(!username.getText().isBlank() && !password.getText().isBlank()){
            validateLogin();
        }
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            WrongLogin.setText("Please enter your username and password");
        }
    }

    public void validateLogin() {
        App m = new App();
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDb = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM log_data WHERE username = '" + username.getText() + "' AND password ='" + password.getText() + "'";

        try {
            Statement statement = connectDb.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) == 1) {
                    WrongLogin.setText("Succes!");
                    m.changeScene("patient.fxml", 1042, 664);
                } else {
                    WrongLogin.setText("Invalid login. Please try again.");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }

    }
}

