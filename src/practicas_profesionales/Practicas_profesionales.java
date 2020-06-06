/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_profesionales;


import exceptions.NoFileChosenException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Student;
import pojo.StudentPojo;


/**
 *
 * @author Adair Hernández
 */
public class Practicas_profesionales extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/views/StudentProgress.fxml"));

        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoFileChosenException, IOException {
        launch(args);
    }
    
}
