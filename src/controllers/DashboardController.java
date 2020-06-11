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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Adair Hernández
 */
public class DashboardController implements Initializable {

    @FXML
    protected Button goToUploadProgressReportButton;
    @FXML
    protected Button goToStudentProgressButton;
    @FXML
    protected Button goToSelectStudentButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    /**
     * Este método redirige al usuario a la pantalla de subir reporte.
     *
     * @throws IOException
     */
    public void goToUploadProgressReport() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/UploadProgressReport.fxml"));
        Stage stage = (Stage) goToUploadProgressReportButton.getScene().getWindow();
        stage.setScene(new Scene(root, 768, 510));
    }

    /**
     * Este método redirige al usuario a la pantalla de consultar progreso
     * @throws IOException
     */
    public void goToStudentProgress() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/StudentProgress.fxml"));
        Stage stage = (Stage) goToStudentProgressButton.getScene().getWindow();
        stage.setScene(new Scene(root, 768, 510));
    }



}
