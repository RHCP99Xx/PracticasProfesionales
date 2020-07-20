/*
public class SelectStudentController extends ProfessorDashboardController implements Initializable 

1. public void initialize(URL url, ResourceBundle rb)

2. public void startComboStudents(String status)

3. public ObservableList<StudentPojo> getStudents(String status)

4. private ObservableList<String> getStudentNames(ObservableList<StudentPojo> olName, String status)

5. public void openStudentProgress(ActionEvent e) throws IOException
*/
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
    private final ObservableList<String> defaultStatus = FXCollections.observableArrayList("Activo", "Concluido");
    private String comboxd;
    

    @Override
    public void initialize(URL url, ResourceBundle rb){
        comboStudentType.setItems(defaultStatus);
        
        /* Esta es una función lambda que permite estar a la escucha del combobox
        comboStudentType que determina el parámetro de búsqueda para obtener los alumnos.
        Cabe recalcar que comboStudentType contiene valores por defecto declarados en una
        ObservableList llamada defaultStatus.
        */
            comboStudentType.valueProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
                if(newValue != null){
                    startComboStudents(newValue);
                }
        });
        
    }
    
    /* Este método inicializa el combobox que contiene los nombres de los estudiantes.
    Coloca en el combobox los nombres de los estudiantes mediante el metodo setItems propio
    de javafx, como parámetro lleva la variable items que contiene un ObservableList
    que retorna el método getStudentNames y contiene los nomrbes de los estudiantes.
    */
    /**
     * 
     * @param status 
     */
    public void startComboStudents(String status){
        try{
            ObservableList<String> items = this.getStudentNames(this.getStudents(status), status);
            comboStudentsNames.setItems(items);
        }catch(Exception ex){
            System.out.println("Excepción en el método startComboStudents");
        }
        

    }
    
    /* Este método retorna un ObservableList de los objetos que contienen el estudiante, haciendo una llamada
    al método getStudentByStatus y se le manda como parámetro de búsqueda el status del estudiante
    */
    
    /**
     * 
     * @param status
     * @return 
     */
    public ObservableList<StudentPojo> getStudents(String status){
        ArrayList<StudentPojo> students = null;
        ObservableList<StudentPojo> studentsObservableList;
        Student student = new Student(); 
        try{
            students = student.getStudentsByStatus(status);
        }catch(Exception a){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error, se perdió la conexión con la base de datos");
            alert.setContentText("Intente más tarde");
            alert.showAndWait();
        }
        studentsObservableList = FXCollections.observableArrayList(students);

        return studentsObservableList;
    }
    
    /* Este método recibe como parámetro de entrada un ObservableList que contiene los objetos StudentPojo y el status
    que utiliza para la búsqueda de los estudiantes. Al final regresa un ObservableList de tipo String con unicamente
    el atributo names que pertenece al estudiante.
    */
    
    /**
     * 
     * @param olName
     * @param status
     * @return 
     */
    private ObservableList<String> getStudentNames(ObservableList<StudentPojo> olName, String status){
        ObservableList<String> names = FXCollections.observableArrayList();
        for(int i=0;i<getStudents(status).size();i++){
            names.add(olName.get(i).getName());
        }
        return names;
    }
   
    /* Este método contiene un ActionEvent que está a la espera de dar clic en el botón consultar. Al momento de darle clic
    Se obtiene el valor del combobox con el nombre, se crea una instancia de la pantalla StudentProgress y se le asigna un
    controlador. Posteriormente se mandan a llamar a los métodos que están contenidos en la clase StudentProgressController
    */
    /**
     * 
     * @param e
     * @throws IOException 
     */
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
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Error, no se encontró el estudiante seleccionado o no tiene registros");
            alert.setContentText("Intente más tarde");
            alert.showAndWait();
        }
    }
}
