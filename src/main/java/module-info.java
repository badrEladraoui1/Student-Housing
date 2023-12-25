module com.example.studenthousing_v1_01 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.example.studenthousing_v1_01;
    exports com.example.studenthousing_v1_01.Admin;
    exports com.example.studenthousing_v1_01.Landlord;
    exports com.example.studenthousing_v1_01.Student;
    exports com.example.studenthousing_v1_01.SessionManagment;
    exports com.example.studenthousing_v1_01.MainPages;

    opens com.example.studenthousing_v1_01 to
            javafx.fxml;
    opens com.example.studenthousing_v1_01.Admin to
            javafx.fxml;
    opens com.example.studenthousing_v1_01.Landlord to
            javafx.fxml;
    opens com.example.studenthousing_v1_01.Student to
            javafx.fxml;
    opens com.example.studenthousing_v1_01.SessionManagment to
            javafx.fxml;
    opens com.example.studenthousing_v1_01.MainPages to
            javafx.fxml;

}