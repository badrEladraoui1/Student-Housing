//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01;

import com.example.studenthousing_v1_01.Admin.AdminProfileController;
import com.example.studenthousing_v1_01.SessionManagment.User;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ApplicationSL extends Application {
    static Stage stage;

    public ApplicationSL() {
    }

    public void start(Stage stage) throws IOException {
        ApplicationSL.stage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(ApplicationSL.class.getResource("welcome.fxml"));
        Scene scene = new Scene((Parent)fxmlLoader.load(), 600.0, 600.0);
        stage.setTitle("WelcomePage");
        stage.setScene(scene);
        stage.show();
    }

    public boolean showProfile(User user) throws IOException, SQLException {
        FXMLLoader fxmlLoaderProfile = new FXMLLoader(ApplicationSL.class.getResource("Admin/adminProfile.fxml"));
        AnchorPane profile = (AnchorPane)fxmlLoaderProfile.load();
        Stage adminProfileStage = new Stage();
        adminProfileStage.setTitle("view Profile");
        adminProfileStage.initModality(Modality.WINDOW_MODAL);
        adminProfileStage.initOwner(stage);
        Scene scene = new Scene(profile);
        adminProfileStage.setScene(scene);
        AdminProfileController adminProfileController = (AdminProfileController)fxmlLoaderProfile.getController();
        adminProfileController.setDialogStage(adminProfileStage);
        adminProfileController.setUser(user);
        adminProfileController.setMainApp(this);
        adminProfileStage.show();
        return adminProfileController.isOkClick();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
