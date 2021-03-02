package Projekt1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class RegisterController {
    @FXML
    private Button CancelRB;

    @FXML
    private void registerButtonCancel(ActionEvent event) throws IOException {
        App m = new App();
        m.changeScene("login.fxml", 1042, 664);
    }
}
