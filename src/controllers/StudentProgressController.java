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
    
    private String name;
    
    
    
    public StudentProgressController(){
        
    }
    
    public StudentProgressController(String name){
        this.name = name;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    /*Este método se encarga de obtener los nombres, apellidos, telefono,
    matricula y correo electrónico del estudiante. También recupera el nombre
    del proyecto y el nombre de la organización vinculada.
    */
    public void loadData(){
       Participation participation = new Participation();
       participationPojo = participation.getParticipation(name);
        
       this.projectName.setText(participationPojo.getProject().getName());
       this.studentName.setText(participationPojo.getStudent().getName() +" "+ participationPojo.getStudent().getLastName());
       this.studentEnrollment.setText(participationPojo.getStudent().getEnrollment());
       this.studentEmail.setText(participationPojo.getStudent().getEmail());
       this.studentPhone.setText(participationPojo.getStudent().getPhone());
       this.nameLinkedOrganization.setText(participationPojo.getOrganization().getName());
    }
    /* Este método manda a llamar al método getProgress() y al método
    setProgress()
    */
    public void calculateProgress(){
        int progress = this.getProgress();
        this.setProgress(progress);
    }
    
    /* Este método inicializa las columnas y se colocan los elementos en la
    tabla
    */
    public void initTable(){
        initColumns();
        reportsTable.setItems(getReports());
    }
    
    /* Este método inicializa las columnas y enlista los reportes por
    nombre
    */
    public void initColumns(){
        reportsName.setCellValueFactory(new PropertyValueFactory<>("name"));
        
    }
    
    /* Este método crea una instancia de la clase Report(), posteriormente
    obtiene los reportes mediante el método getReportsByName() enviando como
    parámetro de búsqueda la variable name que almacena el nombre del estudiante
    y los guarda en una OnservableList que sera procesada por el método initTable()
    */
    public ObservableList<ReportPojo> getReports(){
        Report report = new Report();
        ArrayList<ReportPojo> reports = report.getReportsByName(name);
        ObservableList<ReportPojo> reportsObservableList = FXCollections.observableArrayList(reports);
        return reportsObservableList;
    }
    
    /* Este método crea una instancia de la clase Record, luego crea
    una variable de tipo ReportPojo que almacenará los atributos del expediente
    obtenidos por el método getRecordByName. FInalmente retorna el toal de horas
    cubiertas que es un atributo de la clase reportPojo.
    */
    private int getProgress(){
        Record record = new Record();
        RecordPojo recordPojo = record.getRecordByName(name);
        return recordPojo.getTotalHoursCovered();
        
    }
    
    /* Este método se encarga de rellenar la barra de progreso en base
    a la operacion hoursCovered*100 / 480. El método obtiene hoursCovered gracias
    a getProgress() y ambos se llama en el método calculateProgress
    */
    private void setProgress(int hoursCovered){
        this.studentProgress.setProgress(hoursCovered*100 / 480);
    }
}
