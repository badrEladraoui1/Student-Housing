package com.example.studenthousing_v1_01.Admin;

import com.example.studenthousing_v1_01.ApplicationSL;
import com.example.studenthousing_v1_01.SessionManagment.SessionManager;
import com.example.studenthousing_v1_01.SessionManagment.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class EditAdminProfileController {
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
    private Label lbl_hellouser;

//    @FXML
//    private Label lbl_password;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    @FXML
    public void cancel() {
        dialogStage.close();
    }


    @FXML
    public void ok() {
        if(isValid()){
            String sql = "UPDATE public.\"Admin\" SET username=?, password=? WHERE admin_id=?";
            try{
                Connection cnx = DriverManager.getConnection(DB_URL , DB_USERNAME , PASSWORD);
                PreparedStatement preparedStatement = cnx.prepareStatement(sql);
                SessionManager sm = SessionManager.getInstance();
                User user1 = sm.getCurrentUser();
                {
                    preparedStatement.setString(1,tf_username.getText());
                    preparedStatement.setString(2,tf_password.getText());
                    preparedStatement.setInt(3,EditAdminProfileController.getID(user1.getUsername()));
                    int rowUpdated = preparedStatement.executeUpdate();
                    if(rowUpdated > 0){
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.initOwner(dialogStage);
                        alert.setTitle("SUCCESS");
                        alert.setContentText("INFOS MODIFIED SUCCESSFULLY");
                        alert.show();
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getID(String user){
        String str = "SELECT admin_id FROM public.\"Admin\" WHERE username = ?";
        int id=0;
        try (Connection cnx = DriverManager.getConnection(DB_URL , DB_USERNAME , PASSWORD);
            PreparedStatement stm = cnx.prepareStatement(str)){

            stm.setString(1,user);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
              id = rs.getInt("admin_id");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    private boolean isValid(){
        String msg = "";
        if(tf_username.getText() == null) msg+="NO VALID PASSWORD \n";
        if(tf_password.getText() == null) msg+="NO VALID PASSWORD \n";
        if(msg.isEmpty()) return true;
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("invalid CREDENTIALS");
            alert.setContentText("PROVIDED CREDENTIALS ARE INCORRECT");
            alert.show();
        }
        return false;
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
                this.tf_username.setText(this.user.getUsername());
                this.tf_password.setText(rs.getString("password"));
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
