//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01.Landlord;

import com.example.studenthousing_v1_01.DbUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LandLordLoginController implements Initializable {
    @FXML
    private Button btn_towelcome;
    @FXML
    private Button btn_continue;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private Button btn_tosignup;

    public LandLordLoginController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_towelcome.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "welcome.fxml", "welcome page", (String)null);
            }
        });
        this.btn_continue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.LandlordLogin(event, LandLordLoginController.this.tf_username.getText(), LandLordLoginController.this.tf_password.getText());
            }
        });
        this.btn_tosignup.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "Landlord/landlordSignup.fxml", "Landlord Signup Page", (String)null);
            }
        });
    }
}
