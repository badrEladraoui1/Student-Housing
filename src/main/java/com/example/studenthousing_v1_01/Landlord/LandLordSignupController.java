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

public class LandLordSignupController implements Initializable {
    @FXML
    private TextField tf_fname;
    @FXML
    private TextField tf_lname;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_address;
    @FXML
    private TextField tf_number;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private Button btn_continue;
    @FXML
    private Button btn_tologin;

    public LandLordSignupController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_continue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.LandlordSignup(event, LandLordSignupController.this.tf_fname.getText(), LandLordSignupController.this.tf_lname.getText(), LandLordSignupController.this.tf_username.getText(), LandLordSignupController.this.tf_password.getText(), LandLordSignupController.this.tf_email.getText(), LandLordSignupController.this.tf_address.getText(), LandLordSignupController.this.tf_number.getText());
            }
        });
        this.btn_tologin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "Landlord/landlordLogin.fxml", "Landlord Login Page", (String)null);
            }
        });
    }
}
