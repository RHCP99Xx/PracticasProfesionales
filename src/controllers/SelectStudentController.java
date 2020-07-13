/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import models.Student;
import pojo.StudentPojo;
import javafx.scene.control.Alert;




public class SelectStudentController extends ProfessorDashboardController implements Initializable {
    @FXML
    private ComboBox<String> comboStudentsNames;
    @FXML
    private ComboBox<String> comboStudentType;
    private ObservableList<String> defaultStatus = FXCollections.observableArrayList("Activo", "Concluido");
    private String comboxd;
    

    @Override
    public void initialize(URL url, ResourceBundle rb){
        comboStudentType.setItems(defaultStatus);
        
        /* Esta es una función lambda que permite estar a la escucha del combobox
        comboStudentType que determina el parámetro de búsqueda para obtener los alumnos.
        Cabe recalcar que comboStudentType contiene valores por defecto declarados en una
        ObservableList llamada defaultStatus.
        */
            comboStudentType.valueProperty().addListener(new ChangeListener<String>(){

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null){
                    startComboStudents(newValue);
                }
            }
            
        });
        
    }
    
    /* Este método inicializa el combobox que contiene los nombres de los estudiantes.
    Coloca en el combobox los nombres de los estudiantes mediante el metodo setItems propio
    de javafx, como parámetro lleva la variable items que contiene un ObservableList
    que retorna el método getStudentNames y contiene los nomrbes de los estudiantes.
    */
    public void startComboStudents(String status){
        ObservableList<String> items = this.getStudentNames(this.getStudents(status), status);
        comboStudentsNames.setItems(items);
    }
    
    /* 
    */
    public ObservableList<StudentPojo> getStudents(String status){
        ArrayList<StudentPojo> students;
        ObservableList<StudentPojo> studentsObservableList;
        Student student = new Student(); 
        students = student.getStudentsByStatus(status);
        studentsObservableList = FXCollections.observableArrayList(students);

        return studentsObservableList;
    }
    
   private ObservableList<String> getStudentNames(ObservableList<StudentPojo> olName, String status){
        ObservableList<String> names = FXCollections.observableArrayList();
        for(int i=0;i<getStudents(status).size();i++){
            names.add(olName.get(i).getName());
        }
        return names;
    }
   
    public void openStudentProgress(ActionEvent e) throws IOException{
        try{
            StudentProgressController studentProgress = new StudentProgressController(comboStudentsNames.getValue());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/StudentProgress.fxml"));
            loader.setController(studentProgress);
            Parent root = (Parent) loader.load();
            
            studentProgress.loadData();
            studentProgress.calculateProgress();
            studentProgress.initTable();
            
            System.out.println(comboStudentsNames.getValue());
            
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();

        }catch(NullPointerException a){
            System.out.println(a.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No se encontró el estudiante seleccionado o no tiene registros");
            alert.showAndWait();
        }
    }
}
