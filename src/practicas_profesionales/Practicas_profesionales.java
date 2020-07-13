/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicas_profesionales;


import exceptions.NoFileChosenException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.FXRouter;



/**
 *
 * @author Adair Hernández
 */
public class Practicas_profesionales extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        /*FXRouter.bind(this, stage);
        FXRouter.when("login", "/views/Login.fxml");
        FXRouter.when("uploadProgressReport", "/views/UploadProgressReport.fxml");
        FXRouter.when("studentOverview", "/views/StudentOverview.fxml");
        FXRouter.when("projectOverview", "/views/ProjectOverview.fxml");
        FXRouter.goTo("login");*/
        
        Parent root = FXMLLoader.load(getClass().getResource("/views/SelectStudent.fxml"));
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
