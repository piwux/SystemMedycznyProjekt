package Projekt1;

import Projekt1.DataBaseConnection.DataBaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class RegisterController {
    @FXML
    private Button CancelRB;
    @FXML
    private Button RegisterR;
    @FXML
    private TextField MailR;
    @FXML
    private TextField UsernameR;
    @FXML
    private PasswordField PasswordR;
    @FXML
    private PasswordField PasswordRR;
    @FXML
    private Label RegisterText;
    @FXML
    private Label WrongRegisterR;


    @FXML
    private void registerButtonOnAction(ActionEvent event) throws SQLException, IOException {
        App m = new App();
        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDb = connectNow.getConnection();
        if (validateIfFill() && validateLoginUnique(connectDb) && validatePasswordCorrect()) {
            WrongRegisterR.setText("Register succesful");
            String register = "INSERT INTO log_data (username, password, accounttype) VALUES (" + UsernameR.getText() + ", " + PasswordR.getText() +", " + 1+ ");";
            Statement statement = connectDb.createStatement();
            statement.executeUpdate(register);
            m.changeScene("login.fxml", 1042, 664);

        } else {
            WrongRegisterR.setText("Please enter your username and password");
        }
    }

    @FXML
    private void registerButtonCancel(ActionEvent event) throws IOException {
        App m = new App();
        m.changeScene("login.fxml", 1042, 664);
    }

    private boolean validateIfFill() {
        if (!MailR.getText().isBlank() && !UsernameR.getText().isBlank() && !PasswordR.getText().isBlank() && !PasswordRR.getText().isBlank()) {

            return true;
        }
        return false;
    }

    private boolean validatePasswordCorrect() {
        String password = PasswordR.getText();
        int digitCounter = 0;
        int upperCaseCounter = 0;
        int charCounter = 0;

        for (Character ch : password.toCharArray()) {
            if(Character.isDigit(ch)){
                digitCounter++;
            }
            if(Character.isUpperCase(ch)){
                upperCaseCounter++;
            }
            if(Character.isWhitespace(ch)){
                WrongRegisterR.setText("Your password cannot contain space");
                return false;
            }
            charCounter++;

        }
        if(digitCounter >= 3 && upperCaseCounter >=1 && charCounter >= 9 && PasswordRR.equals(PasswordR)){
            return true;
        }
        WrongRegisterR.setText("Your password must contain 1 upper, 3 digits, and at least 8 char");
        return false;

    }


    private boolean validateLoginUnique(Connection connection){
        String validateLogin = "SELECT count(*) FROM log_data WHERE username = '" + UsernameR.getText() + "'";

        try {
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(validateLogin);
        } catch (SQLException throwables) {
            WrongRegisterR.setText("Login is not unique");
            return true;
        }
        return false;
    }
}

