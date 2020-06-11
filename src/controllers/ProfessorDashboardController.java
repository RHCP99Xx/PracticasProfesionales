/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Adair Hernández
 */
public class ProfessorDashboardController {

    @FXML
    private Button assignProjectButton;
    @FXML
    private Button checkProgressButton;

    public void redirectToAssignProjectScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/StudentOverview.fxml"));
        Stage stage = (Stage) assignProjectButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 510));
    }

    public void redirectToCheckProgressScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/SelectStudent.fxml"));
        Stage stage = (Stage) assignProjectButton.getScene().getWindow();
        stage.setScene(new Scene(root, 800, 510));
    }

}
