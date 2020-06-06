/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import pojo.UserPojo;
import session.UserSession;

/**
 *
 * @author Adair Hernández
 */
public class LoginController implements Initializable {

    @FXML
    private TextField emailTextField;
    @FXML
    private PasswordField passwordField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loginButtonClicked() {
        String email = this.emailTextField.getText();
        String password = this.passwordField.getText();
        User user = new User();

        UserPojo myUser = user.getUser(email, password);

        UserSession userSession = UserSession.getInstance();

        userSession.login(myUser);

        try {
            if(myUser.getType().equals("estudiante")){
                redirectToUploadProgressReportScreen();
            }else{
                redirectToAssignProjectScreen();
            }
        } catch (IOException e) {
            System.out.println("Checking for session details...");
            e.printStackTrace();
        }
    }

    private void redirectToUploadProgressReportScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/UploadProgressReport.fxml"));
        Stage stage = (Stage) emailTextField.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 510));
    }

    private void redirectToAssignProjectScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/AssignProject.fxml"));
        Stage stage = (Stage) emailTextField.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 510));
    }

}
