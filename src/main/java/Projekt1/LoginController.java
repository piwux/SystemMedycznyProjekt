package Projekt1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
    private void cancelOnAction(ActionEvent event){
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();

    }
    @FXML
    private void checkLogAndOrForward(ActionEvent event){
    }
    @FXML
    private void getUsername(ActionEvent event){
    }
    @FXML
    private void getPassword(ActionEvent event){
    }
    @FXML
    private void displayMessage(ActionEvent event){

    }
    @FXML
    private void checkLog(ActionEvent event){
        try {
            checkLogin();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkLogin() throws IOException, InterruptedException {
        App m = new App();
        if(username.getText().toString().equals("javacode") && password.getText().toString().equals("123")) {
            WrongLogin.setText("Succes!");
            m.changeScene("patient.fxml",1560,1400);
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()){
            WrongLogin.setText("Please enter your username and password");
        }

        else{
            WrongLogin.setText("Wrong username or password");
            ForgetPassword.setText("Forget Password?");
        }
    }
    }
