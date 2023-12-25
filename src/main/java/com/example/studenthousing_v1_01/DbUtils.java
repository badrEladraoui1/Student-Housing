//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.studenthousing_v1_01;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DbUtils {
    public DbUtils() {
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String chosenRb) {
        Parent root = null;

        try {
            root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(DbUtils.class.getResource(fxmlFile)));
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle(title);

        assert root != null;

        stage.setScene(new Scene(root, 600.0, 600.0));
        stage.show();
    }

    public static void AdminLogin(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignUpLogin", "postgres", "1234");
            preparedStatement = connection.prepareStatement("SELECT password FROM public.\"Admin\" WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("USER NOT FOUND !!! ");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("PROVIDED CREDENTIALS ARE INCORRECT");
                alert.show();
            } else {
                while(resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "MainPages/landingPage.fxml", "LandingPage", (String)null);
                    }else{
                        System.out.println("PASSWORD INCORRECT");
                        Alert alert = new Alert(AlertType.ERROR);
                        alert.setContentText("PROVIDED CREDENTIALS ARE INCORRECT");
                        alert.show();
                    }
                }
            }
        } catch (SQLException var23) {
            var23.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException var22) {
                    var22.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var21) {
                    var21.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var20) {
                    var20.printStackTrace();
                }
            }

        }

    }

    public static void StudentLogin(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignUpLogin", "postgres", "1234");
            preparedStatement = connection.prepareStatement("SELECT password FROM public.\"Student\" WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("USER NOT FOUND !!! ");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("PROVIDED CREDENTIALS ARE INCORRECT");
                alert.show();
            } else {
                while(resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "MainPages/landingPage.fxml", "LandingPage", (String)null);
                    }
                }
            }
        } catch (SQLException var23) {
            var23.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException var22) {
                    var22.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var21) {
                    var21.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var20) {
                    var20.printStackTrace();
                }
            }

        }

    }

    public static void LandlordLogin(ActionEvent event, String username, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignUpLogin", "postgres", "1234");
            preparedStatement = connection.prepareStatement("SELECT password FROM public.\"Landlord\" WHERE username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("USER NOT FOUND !!! ");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("PROVIDED CREDENTIALS ARE INCORRECT");
                alert.show();
            } else {
                while(resultSet.next()) {
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)) {
                        changeScene(event, "MainPages/landingPage.fxml", "LandingPage", (String)null);
                    }
                }
            }
        } catch (SQLException var23) {
            var23.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException var22) {
                    var22.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException var21) {
                    var21.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var20) {
                    var20.printStackTrace();
                }
            }

        }

    }

    public static void StudentSignup(ActionEvent event, String fName, String lName, String userName, String password, String uniName, String address, String number, String email) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignUpLogin", "postgres", "1234");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM public.\"Student\" WHERE username = ?");
            psCheckUserExists.setString(1, userName);
            resultSet = psCheckUserExists.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("USER ALREADY EXISTS !!!");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("YOU CANNOT USE THIS USERNAME !!!");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO public.\"Student\"(firstname, lastname, username, password, uniname, address, phonenumber, email)VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, fName);
                psInsert.setString(2, lName);
                psInsert.setString(3, userName);
                psInsert.setString(4, password);
                psInsert.setString(5, uniName);
                psInsert.setString(6, address);
                psInsert.setString(7, number);
                psInsert.setString(8, email);
                psInsert.executeUpdate();
                changeScene(event, "Student/studentLogin.fxml", "Student Login page", (String)null);
            }
        } catch (SQLException var34) {
            var34.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException var33) {
                    var33.printStackTrace();
                }
            }

            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException var32) {
                    var32.printStackTrace();
                }
            }

            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException var31) {
                    var31.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var30) {
                    var30.printStackTrace();
                }
            }

        }

    }

    public static void LandlordSignup(ActionEvent event, String fName, String lName, String userName, String password, String email, String address, String number) {
        Connection connection = null;
        PreparedStatement psInsert = null;
        PreparedStatement psCheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SignUpLogin", "postgres", "1234");
            psCheckUserExists = connection.prepareStatement("SELECT * FROM public.\"Landlord\" WHERE username = ?");
            psCheckUserExists.setString(1, userName);
            resultSet = psCheckUserExists.executeQuery();
            if (resultSet.isBeforeFirst()) {
                System.out.println("USER ALREADY EXISTS !!!");
                Alert alert = new Alert(AlertType.ERROR);
                alert.setContentText("YOU CANNOT USE THIS USERNAME !!!");
                alert.show();
            } else {
                psInsert = connection.prepareStatement("INSERT INTO public.\"Landlord\"(firstname, lastname, username, password, email , address ,phonenumber)VALUES (?, ?, ?, ?, ?, ?, ?)");
                psInsert.setString(1, fName);
                psInsert.setString(2, lName);
                psInsert.setString(3, userName);
                psInsert.setString(4, password);
                psInsert.setString(5, email);
                psInsert.setString(6, address);
                psInsert.setString(7, number);
                psInsert.executeUpdate();
                changeScene(event, "Landlord/landlordLogin.fxml", "Landlord Login page", (String)null);
            }
        } catch (SQLException var33) {
            var33.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException var32) {
                    var32.printStackTrace();
                }
            }

            if (psCheckUserExists != null) {
                try {
                    psCheckUserExists.close();
                } catch (SQLException var31) {
                    var31.printStackTrace();
                }
            }

            if (psInsert != null) {
                try {
                    psInsert.close();
                } catch (SQLException var30) {
                    var30.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException var29) {
                    var29.printStackTrace();
                }
            }

        }

    }
}
