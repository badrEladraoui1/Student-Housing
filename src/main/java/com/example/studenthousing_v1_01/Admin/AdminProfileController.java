//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01.Admin;

import com.example.studenthousing_v1_01.ApplicationSL;
import com.example.studenthousing_v1_01.SessionManagment.SessionManager;
import com.example.studenthousing_v1_01.SessionManagment.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class AdminProfileController {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/SignUpLogin";
    private static final String DB_USERNAME = "postgres";
    private static final String PASSWORD = "1234";
    private Stage dialogStage;
    private ApplicationSL mainApp;
    private User user;
    private boolean okClick = false;
    @FXML
    private Button btn_change;
    @FXML
    private Button btn_ok;
    @FXML
    private Label lbl_password;
    @FXML
    private Label lbl_username;
    @FXML
    private Label lbl_hellouser;

    public AdminProfileController() {
    }

    public boolean isOkClick() {
        return this.okClick;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setMainApp(ApplicationSL mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    void change(ActionEvent event) {
    }

    @FXML
    void ok() {
        this.okClick = true;
        this.dialogStage.close();
    }

    public void setUser(User u) throws SQLException {
        SessionManager sm = SessionManager.getInstance();
        this.user = sm.getCurrentUser();
        String selectQuery = "SELECT * FROM public.\"Admin\" WHERE username = ?";
        Connection cnx = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignUpLogin", "postgres", "1234");
            stm = cnx.prepareStatement(selectQuery);
            stm.setString(1, this.user.getUsername());
            rs = stm.executeQuery();

            while(rs.next()) {
                this.lbl_hellouser.setText("HELLO " + this.user.getUsername());
                this.lbl_username.setText(this.user.getUsername());
                this.lbl_password.setText(rs.getString("password"));
            }
        } catch (SQLException var11) {
            var11.printStackTrace();
        } finally {
            cnx.close();
            rs.close();
            stm.close();
        }

    }
}
