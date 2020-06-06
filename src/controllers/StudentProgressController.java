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
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Participation;
import models.Report;
import pojo.ParticipationPojo;
import pojo.RecordPojo;
import pojo.ReportPojo;
import session.UserSession;
import models.Record;

public class StudentProgressController extends DashboardController implements Initializable {
    
    @FXML
    private Label studentName;
    @FXML
    private Label studentEnrollment;
    @FXML
    private Label nameLinkedOrganization;
    @FXML
    private Label defaultTagContact;
    @FXML
    private Label studentEmail;
    @FXML
    private Label studentPhone;
    @FXML
    private Label projectName;
    @FXML
    private ProgressIndicator studentProgress;
    @FXML
    private TableView<ReportPojo> reportsTable;
    @FXML
    private TableColumn<ReportPojo, String> reportsName;
    @FXML
    private ParticipationPojo participationPojo;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       getData();
       table();
       getReports();
       calculateProgress();
    }    
    public void getData(){
       Participation participation = new Participation();
       participationPojo = participation.getParticipation("S18012122");
        
       this.projectName.setText(participationPojo.getProject().getName());
       this.studentName.setText(participationPojo.getStudent().getName());
       this.studentEnrollment.setText(participationPojo.getStudent().getEnrollment());
       this.studentEmail.setText(participationPojo.getStudent().getEmail());
       this.studentPhone.setText(participationPojo.getStudent().getPhone());
       this.nameLinkedOrganization.setText(participationPojo.getOrganization().getName());
    }
    public void calculateProgress(){
        int progress = this.getProgress();
        this.setProgress(progress);
    }
    
    public void table(){
        columns();
        reportsTable.setItems(getReports());
    }
    
    public void columns(){
        reportsName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
    }
    
    public ObservableList<ReportPojo> getReports(){
        Report report = new Report();
        ArrayList<ReportPojo> reports = report.getReports(1);
        ObservableList<ReportPojo> reportsObservableList = FXCollections.observableArrayList(reports);
        return reportsObservableList;
    }
    private int getProgress(){
        UserSession userSession = UserSession.getInstance();
        Record record = new Record();
        RecordPojo recordPojo = record.getRecord(1);
        return recordPojo.getTotalHoursCovered();
        
    }
    private void setProgress(int hoursCovered){
        this.studentProgress.setProgress(hoursCovered*100 / 480);
    }
}
