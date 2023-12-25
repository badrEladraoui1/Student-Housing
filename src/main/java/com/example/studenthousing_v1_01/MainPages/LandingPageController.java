//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01.MainPages;

import com.example.studenthousing_v1_01.ApplicationSL;
import com.example.studenthousing_v1_01.SessionManagment.SessionManager;
import com.example.studenthousing_v1_01.SessionManagment.User;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LandingPageController implements Initializable {
    private ApplicationSL mainApp;
    @FXML
    private Button btn_logout;

    public LandingPageController() {
    }

    @FXML
    void show() throws SQLException, IOException {
        ApplicationSL startProfile = new ApplicationSL();
        this.setMainApp(startProfile);
        SessionManager sm = SessionManager.getInstance();
        User Current = sm.getCurrentUser();
        boolean okClick = this.mainApp.showProfile(Current);
        if (okClick) {
            System.out.println("clicked");
        }

    }

    public void setMainApp(ApplicationSL mainApp) {
        this.mainApp = mainApp;
    }


    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            }
        });
    }
}
