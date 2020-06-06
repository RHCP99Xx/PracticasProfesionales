/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Report;
import models.Student;
import pojo.ReportPojo;
import pojo.StudentPojo;

/**
 *
 * @author Adair Hernández
 */
public class StudentOverviewController implements Initializable {

    @FXML
    private TableView<StudentPojo> studentsTableView;
    @FXML
    private TableColumn<StudentPojo, String> namesTableColumn;
    @FXML
    private TableColumn<StudentPojo, String> lastNameTableColumn;
    @FXML
    private TableColumn<StudentPojo, String> enrollmentTableColumn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        loadData();
    }

    private void initTable() {
        initCols();
        studentsTableView.setItems(loadData());
    }

    private void initCols() {
        namesTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        lastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        enrollmentTableColumn.setCellValueFactory(new PropertyValueFactory<>("enrollment"));
    }

    public ObservableList<StudentPojo> loadData() {
        Student student = new Student();

        ArrayList<StudentPojo> studentsList = student.getStudents();
        ObservableList<StudentPojo> studentsObservableList = FXCollections.observableArrayList(studentsList);
        return studentsObservableList;
    }

}
