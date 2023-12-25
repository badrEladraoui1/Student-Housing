//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class WelcomeController implements Initializable {
    @FXML
    private RadioButton rb_admin;
    @FXML
    private RadioButton rb_student;
    @FXML
    private RadioButton rb_landlord;
    @FXML
    private Button btn_continue;

    public WelcomeController() {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        final ToggleGroup toggleGroup = new ToggleGroup();
        this.rb_admin.setToggleGroup(toggleGroup);
        this.rb_student.setToggleGroup(toggleGroup);
        this.rb_landlord.setToggleGroup(toggleGroup);
        this.rb_admin.setSelected(true);
        this.btn_continue.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String chosenRb = ((RadioButton)toggleGroup.getSelectedToggle()).getText();
                if (chosenRb.equals("Admin")) {
                    DbUtils.changeScene(event, "Admin/adminLogin.fxml", "Admin Login Page", chosenRb);
                }

                if (chosenRb.equals("Student")) {
                    DbUtils.changeScene(event, "Student/studentLogin.fxml", "Student Login Page", chosenRb);
                }

                if (chosenRb.equals("Landlord")) {
                    DbUtils.changeScene(event, "Landlord/landlordLogin.fxml", "Landlord Login Page", chosenRb);
                }

            }
        });
    }
}
