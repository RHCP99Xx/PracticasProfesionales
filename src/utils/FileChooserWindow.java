/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import exceptions.NoFileChosenException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import pojo.DocumentPojo;

/**
 *
 * @author Adair Hernández
 */
public class FileChooserWindow {

    private FileChooser fileChooser;
    private ObservableList<ExtensionFilter> extensionFilters;

    public FileChooserWindow() {
        this.fileChooser = new FileChooser();
        this.extensionFilters = this.fileChooser.getExtensionFilters();
        this.initializeValidExtensions();
    }

    private void initializeValidExtensions() {
        ExtensionFilter docxExtension = new FileChooser.ExtensionFilter("Word document (docx)", "*.docx");
        ExtensionFilter docExtension = new FileChooser.ExtensionFilter("Word document (doc)", "*.doc");
        ExtensionFilter pdfExtension = new FileChooser.ExtensionFilter("PDF", "*.PDF");
        this.extensionFilters.addAll(docxExtension, docExtension, pdfExtension);
    }

    public DocumentPojo selectFile() throws NoFileChosenException, IOException {
        File selectedFile = this.fileChooser.showOpenDialog(null);
        if (selectedFile == null) {
            throw new NoFileChosenException("No file has been chosen");
        }
        DocumentPojo document = new DocumentPojo();
        document.setName(selectedFile.getName());
        document.setPath(selectedFile.getPath());
        document.setSize(selectedFile.length());

        return document;
    }

}
