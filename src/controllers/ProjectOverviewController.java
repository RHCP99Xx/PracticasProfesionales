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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import models.Project;
import models.Selection;
import models.Student;
import pojo.LinkedOrganizationPojo;
import pojo.ProjectPojo;
import pojo.SelectionPojo;
import pojo.StudentPojo;

/**
 *
 * @author Adair Hernández
 */
public class ProjectOverviewController implements Initializable {

    @FXML private TableView<ProjectPojo> projectsTableView;
    
    @FXML private Button saveButton;
    @FXML private TableColumn<Integer, String> optionProjectTableColumn;
    @FXML private TableColumn<ProjectPojo, String> projectNameTableColumn;
    @FXML private TableColumn<ProjectPojo, LinkedOrganizationPojo> linkedOrganizationTableColumn;
    @FXML private TableColumn<ProjectPojo, Integer> assignedStudentsTableColumn;
    @FXML private TableColumn<ProjectPojo, Integer> requiredStudentsTableColumn;
    
    private ArrayList<SelectionPojo> selectedProjects = new ArrayList<>(3);
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        loadData();
        
        projectsTableView.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {                
                ProjectPojo selectedProject = projectsTableView.getSelectionModel().getSelectedItem();
                addChoice(selectedProject);
            }
            
        });
        
    }
    
    public void saveButtonClicked(){
        Selection selection = new Selection();
        selection.saveSelections(selectedProjects);
    }

    private void initTable() {
        initCols();
        projectsTableView.setItems(loadData());
    }

    private void initCols() {
        //optionProjectTableColumn.setCellValueFactory(new PropertyValueFactory<>("option"));
        projectNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        //linkedOrganizationTableColumn.setCellValueFactory(new PropertyValueFactory<>("enrollment"));
        //linkedOrganizationTableColumn.setCellValueFactory(new PropertyValueFactory<>("linkedOrganization"));
        assignedStudentsTableColumn.setCellValueFactory(new PropertyValueFactory("assignedStudents"));
        requiredStudentsTableColumn.setCellValueFactory(new PropertyValueFactory("requiredStudents"));
    }

    public ObservableList<ProjectPojo> loadData() {
        Project project = new Project();

        ArrayList<ProjectPojo> projectsList = project.getProjects();
        ObservableList<ProjectPojo> projectsObservableList = FXCollections.observableArrayList(projectsList);
        return projectsObservableList;
    }
    
    public void addChoice(ProjectPojo selectedProject){
        if(selectedProjects.size() < 3){
            SelectionPojo sp = new SelectionPojo();
            sp.setProject(selectedProject);
            System.out.println(sp.getProject().getName());
            sp.setPosition(selectedProjects.size() + 1);
            selectedProjects.add(sp);
        }
    }

}
