//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01.Admin;

import com.example.studenthousing_v1_01.DbUtils;
import com.example.studenthousing_v1_01.SessionManagment.SessionManager;
import com.example.studenthousing_v1_01.SessionManagment.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminLoginController implements Initializable {
    @FXML
    private Button btn_towelcome;
    @FXML
    private Button btn_continue;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;

    public AdminLoginController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_towelcome.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.changeScene(event, "welcome.fxml", "welcome Page", (String)null);
            }
        });
        this.btn_continue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                DbUtils.AdminLogin(event, AdminLoginController.this.tf_username.getText(), AdminLoginController.this.tf_password.getText());
                User user = new User(AdminLoginController.this.tf_username.getText());
                SessionManager sessionManager = SessionManager.getInstance();
                sessionManager.startSession(user);
            }
        });
    }
}
