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

public class StudentLoginController implements Initializable {
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

    public StudentLoginController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_towelcome.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "welcome.fxml", "welcome Page", (String)null);
            }
        });
        this.btn_continue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.StudentLogin(event, StudentLoginController.this.tf_username.getText(), StudentLoginController.this.tf_password.getText());
            }
        });
        this.btn_tosignup.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "Student/studentSignup.fxml", "Student Signup Page", (String)null);
            }
        });
    }
}
