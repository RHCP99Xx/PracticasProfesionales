/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import pojo.DocumentPojo;

/**
 *
 * @author Adair Hernández
 */
public class DocxWriter implements DocumentWriter {

    private DocumentPojo document;

    public DocxWriter(DocumentPojo document) {
        this.document = document;
    }

    @Override
    public boolean write() throws FileNotFoundException, IOException {
        if(this.document == null){
            throw new NullPointerException("Por favor seleccione un archivo");
        }
        boolean fileHasBeenWritten = false;
        XWPFDocument myDocument = new XWPFDocument();
        XWPFParagraph newParagraph = myDocument.createParagraph();
        XWPFRun run = newParagraph.createRun();
        FileOutputStream fileOutputStream = new FileOutputStream("reports/" + this.document.getName());
        
        DocxReader docxReader = new DocxReader(this.document);
        List<XWPFParagraph> originalDocumentParagraphs = docxReader.getParagraphs();
        for (XWPFParagraph paragraph : originalDocumentParagraphs) {
            run.setText(paragraph.getText());
        }
        myDocument.write(fileOutputStream);
        fileHasBeenWritten = true;
        return fileHasBeenWritten;
    }

}
