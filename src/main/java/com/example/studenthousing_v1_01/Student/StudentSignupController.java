//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01.Student;

import com.example.studenthousing_v1_01.DbUtils;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentSignupController implements Initializable {
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
    private TextField tf_uniname;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;
    @FXML
    private Button btn_continue;
    @FXML
    private Button btn_tologin;

    public StudentSignupController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_continue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.StudentSignup(event, StudentSignupController.this.tf_fname.getText(), StudentSignupController.this.tf_lname.getText(), StudentSignupController.this.tf_username.getText(), StudentSignupController.this.tf_password.getText(), StudentSignupController.this.tf_uniname.getText(), StudentSignupController.this.tf_address.getText(), StudentSignupController.this.tf_number.getText(), StudentSignupController.this.tf_email.getText());
            }
        });
        this.btn_tologin.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "Student/studentLogin.fxml", "Student Login Page", (String)null);
            }
        });
    }
}
