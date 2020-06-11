/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.NonExistentUserException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import utils.FXRouter;

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

    /**
     * Este método se invoca cuando el usuario da clic en el botón de "iniciar
     * sesión". Con la ayuda de los otros métodos recupera el usuario de la base
     * de datos, inicia la sesión y redirige al usuario a la pantalla
     * correspondiente.
     */
    public void loginButtonClicked() {
        try {
            UserPojo myUser;
            String email = this.emailTextField.getText();
            String password = this.passwordField.getText();
            User user = new User();
            myUser = user.getUser(email, password);
            UserSession userSession = UserSession.getInstance();
            userSession.login(myUser);
            redirectUser(myUser.getType());
        } catch (NonExistentUserException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Este método evalúa el tipo de usuario que inició sesión en el sistema y
     * dependiendo de eso lo redirige a otra pantalla. Si el usuario es de tipo
     * estudiante, se redirige a la pantalla de subir reporte; si es de tipo
     * profesor, se redirige a la pantalla de asignar proyecto.
     *
     * @param userType
     * @throws IOException
     */
    private void redirectUser(String userType) {
        try {
            if (userType.equals("estudiante")) {
                FXRouter.goTo("uploadProgressReport");
            } else {
                FXRouter.goTo("studentOverview");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
