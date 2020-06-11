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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import models.Report;
import models.Student;
import static org.bouncycastle.asn1.cms.CMSObjectIdentifiers.data;
import pojo.ReportPojo;
import pojo.StudentPojo;




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
        startComboStudents();
    }
    public void comboChanged(ActionEvent event){
        System.out.println(comboStudentType.getValue());
        System.out.println();
    }
    public void startComboStudents(){
        ObservableList<StudentPojo> getStudents = this.getStudents();
        System.out.println(this.getStudents());
        comboStudentsNames.setItems(this.getStudentNames(getStudents));
    }

    public ObservableList<StudentPojo> getStudents(){
        ArrayList<StudentPojo> students;
        ObservableList<StudentPojo> studentsObservableList;
        Student student = new Student(); 
        students = student.getStudentsByStatus(comboStudentType.getValue());
        studentsObservableList = FXCollections.observableArrayList(students);

        return studentsObservableList;
    }
    
    private ObservableList<String> getStudentNames(ObservableList<StudentPojo> olName){
        ObservableList<String> names = FXCollections.observableArrayList();
        for(int i=0;i<getStudents().size();i++){
            names.add(olName.get(i).getName());
        }
        return names;
    }
 
    public void checkStudentProgress(){
        try {
            System.out.println(comboStudentsNames.getValue());
            StudentProgressController spc = new StudentProgressController((String) comboStudentsNames.getValue());
            super.redirectToCheckProgressScreen();
        } catch (IOException ex) {
            
        }
        
    }
}
