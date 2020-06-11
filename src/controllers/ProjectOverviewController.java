/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import models.Project;
import models.Selection;
import models.Student;
import pojo.LinkedOrganizationPojo;
import pojo.ProjectPojo;
import pojo.SelectionPojo;
import pojo.StudentPojo;
import utils.FXRouter;

/**
 *
 * @author Adair Hernández
 */
public class ProjectOverviewController extends ProfessorDashboardController implements Initializable {

    @FXML
    private TableView<SelectionPojo> projectsTableView;

    @FXML
    private Button saveButton;
    @FXML
    private TableColumn<SelectionPojo, Integer> positionTableColumn;
    @FXML
    private TableColumn<SelectionPojo, String> projectNameTableColumn;
    @FXML
    private TableColumn<SelectionPojo, String> linkedOrganizationTableColumn;
    @FXML
    private TableColumn<SelectionPojo, String> assignedStudentsTableColumn;
    @FXML
    private TableColumn<SelectionPojo, String> requiredStudentsTableColumn;

    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        loadData();

        projectsTableView.setOnMousePressed(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                SelectionPojo selection = projectsTableView.getSelectionModel().getSelectedItem();
                //addChoice(selectedProject);
            }

        });

    }

    public void saveButtonClicked() {
        
    }

    private void initTable() {
        initCols();
        projectsTableView.setItems(loadData());
    }

    private void initCols() {
        positionTableColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        
        projectNameTableColumn.setCellValueFactory(cellDataFeatures -> 
                new SimpleStringProperty(cellDataFeatures.getValue().
                        getProject().getName()));                                                
       

        

        assignedStudentsTableColumn.setCellValueFactory(cellDataFeatures -> 
            new SimpleStringProperty(cellDataFeatures.getValue().getProject().getAssignedStudents()+""));
        
        linkedOrganizationTableColumn.setCellValueFactory(cellDataFeatures -> 
            new SimpleStringProperty(cellDataFeatures.getValue().getProject().getLinkedOrganization().getName()));
        
        requiredStudentsTableColumn.setCellValueFactory(cellDataFeatures -> 
            new SimpleStringProperty(cellDataFeatures.getValue().getProject().getRequiredStudents()+""));
    }

    public ObservableList<SelectionPojo> loadData() {
        int selectedStudentId = (int) FXRouter.getData();
        System.out.println(selectedStudentId);
        Selection selection = new Selection();

        ArrayList<SelectionPojo> selectionsList = selection.getStudentSelections(selectedStudentId);
        ObservableList<SelectionPojo> selectionsObservableList = FXCollections.observableArrayList(selectionsList);
        return selectionsObservableList;
    }



}
