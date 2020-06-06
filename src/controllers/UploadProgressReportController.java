/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exceptions.NoFileChosenException;
import file.DocumentWriter;
import file.DocxWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UserSession userSession = UserSession.getInstance();
        user = userSession.getUser();
        initTable();
        loadData();

        int progress = this.getProgress();
        this.setProgressToProgressBar(progress);

    }

    public void chooseDocumentButtonClicked() {
        try {
            this.handleChooseDocumentButtonClicked();
        } catch (NoFileChosenException e) {
            documentPathTextField.setText("");
        } catch (IOException e2) {

        }
    }

    private void handleChooseDocumentButtonClicked() throws NoFileChosenException, IOException {
        FileChooserWindow fileChooser = new FileChooserWindow();
        this.chosenDocument = fileChooser.selectFile();
        documentPathTextField.setText(this.chosenDocument.getName());
    }

    public void uploadDocumentButtonClicked() {
        DocumentWriter docxWriter = new DocxWriter(this.chosenDocument);
        boolean fileHasBeenWritten = docxWriter.write();
        boolean fileHasBeenSaved = false;
        Report report = new Report();
        ReportPojo reportToBeUploaded = new ReportPojo();
        reportToBeUploaded.setName(this.chosenDocument.getName());
        reportToBeUploaded.setPath(this.chosenDocument.getPath());
        reportToBeUploaded.setSize(this.chosenDocument.getSize());
        //reportToBeUploaded.setUploadDate(this.chosenDocument.getUploadDate());
        int hoursCovered = Integer.parseInt(this.hoursCoveredTextField.getText());
        reportToBeUploaded.setCoveredHours(hoursCovered);
        reportToBeUploaded.setStatus("Aprobado");

        //DatePicker to Date
        LocalDate initialDateLocalDate = initialDateDatePicker.getValue();
        Instant initialDateInstant = Instant.from(initialDateLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date initialDate = Date.from(initialDateInstant);
        
        
        LocalDate finalDateLocalDate = finalDateDatePicker.getValue();
        Instant finalDateInstant = Instant.from(finalDateLocalDate.atStartOfDay(ZoneId.systemDefault()));
        Date finalDate = Date.from(finalDateInstant);
        
        reportToBeUploaded.setInitialDate(initialDate);
        reportToBeUploaded.setEndingDate(finalDate);

        try {
            fileHasBeenSaved = report.saveReport(reportToBeUploaded);
        } catch (SQLException ex) {

        }
    }

    private void initTable() {
        initCols();
        uploadedDocumentsTableView.setItems(loadData());
    }

    private void initCols() {
        nameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        uploadDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("uploadDate"));

    }

    public ObservableList<ReportPojo> loadData() {
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
