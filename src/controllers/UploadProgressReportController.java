/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.FormInputException;
import exceptions.NoFileChosenException;
import file.DocumentWriter;
import file.DocxWriter;
import inputvalidators.DatePickerValidator;
import inputvalidators.TextFieldValidator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Record;
import models.Report;
import pojo.DocumentPojo;
import pojo.RecordPojo;
import pojo.ReportPojo;
import pojo.UserPojo;
import session.UserSession;
import utils.DateFormatter;
import utils.FileChooserWindow;

/**
 * FXML Controller class
 *
 * @author Adair Hernández
 */
public class UploadProgressReportController extends DashboardController implements Initializable {

    @FXML
    private TextField documentPathTextField;
    @FXML
    private Button chooseDocumentButton;
    @FXML
    private DatePicker initialDateDatePicker;
    @FXML
    private DatePicker finalDateDatePicker;
    @FXML
    private TextField hoursCoveredTextField;
    @FXML
    private Button uploadDocumentButton;
    @FXML
    private TableView<ReportPojo> uploadedDocumentsTableView;
    @FXML
    private TableColumn<ReportPojo, String> nameTableColumn;
    @FXML
    private TableColumn<ReportPojo, Date> uploadDateTableColumn;
    TableColumn deleteReportColumn;
    @FXML
    private ProgressBar studentProgressBar;
    
    private DocumentPojo chosenDocument;
    private UserPojo user;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.chosenDocument = null;
        UserSession userSession = UserSession.getInstance();
        user = userSession.getUser();
        try {
            initTable();
        } catch (Exception ex) {
            Logger.getLogger(UploadProgressReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            loadData();
        } catch (Exception ex) {
            Logger.getLogger(UploadProgressReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        int progress = this.getProgress();
        this.setProgressToProgressBar(progress);
    }

    public void chooseDocumentButtonClicked() {
        FileChooserWindow fileChooser = new FileChooserWindow();
        try {
            this.chosenDocument = fileChooser.selectFile();
            documentPathTextField.setText(this.chosenDocument.getName());
            System.out.println(this.chosenDocument.getSize());
        } catch (NoFileChosenException e) {
            System.out.println("Por favor seleccione un archivo");
        } catch (IOException e2) {

        }
    }



    public void uploadDocumentButtonClicked() {
        TextFieldValidator tfv = new TextFieldValidator();
        DatePickerValidator dpv = new DatePickerValidator();

        try {
            tfv.validate(hoursCoveredTextField);
            dpv.validate(finalDateDatePicker);
            dpv.validate(initialDateDatePicker);
            DocumentWriter docxWriter = new DocxWriter(this.chosenDocument);
            docxWriter.write();

            DateFormatter dateFormatter = new DateFormatter();
            Date initialDate = dateFormatter.getLocalDate(initialDateDatePicker);
            Date finalDate = dateFormatter.getLocalDate(finalDateDatePicker);

            String reportName = this.chosenDocument.getName();
            String reportPath = this.chosenDocument.getPath();
            double reportSize = this.chosenDocument.getSize();
            int hoursCovered = Integer.parseInt(this.hoursCoveredTextField.getText());

            ReportPojo reportToBeUploaded = new ReportPojo(reportName, reportPath,
                    reportSize, initialDate, finalDate, hoursCovered);
            Report report = new Report();
            report.saveReport(reportToBeUploaded, user.getUserId());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException | SQLException e2) {
            System.out.println(e2.getMessage());
        } catch (FormInputException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void initTable() throws Exception {
        initCols();
        uploadedDocumentsTableView.setItems(loadData());
    }

    private void initCols() {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        uploadDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));
    }

    public ObservableList<ReportPojo> loadData() throws Exception {
        Report report = new Report();
        ArrayList<ReportPojo> reports = report.getReports(user.getUserId());
        ObservableList<ReportPojo> reportsObservableList = FXCollections.observableArrayList(reports);
        return reportsObservableList;
    }

    private int getProgress() {
        Record record = new Record();
        RecordPojo recordPojo = record.getRecord(user.getUserId());
        return recordPojo.getTotalHoursCovered();
    }

    private void setProgressToProgressBar(int hoursCovered) {
        this.studentProgressBar.setProgress((hoursCovered * 100) / 480);
    }
}
