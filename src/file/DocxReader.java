/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import pojo.DocumentPojo;

/**
 *
 * @author Adair Hernández
 */
public class DocxReader implements DocumentReader {

    private DocumentPojo document;

    public DocxReader(DocumentPojo document) {
        this.document = document;
    }

    @Override
    public List<XWPFParagraph> getParagraphs() {
        List<XWPFParagraph> paragraphs = null;
        try {
            paragraphs = getDocumentParagraphs();
            return paragraphs;
        } catch (FileNotFoundException e) {

        } catch (IOException e2) {

        }
        return null;
    }

    private List<XWPFParagraph> getDocumentParagraphs() throws FileNotFoundException, IOException {
        FileInputStream fileInputStream = new FileInputStream(this.document.getPath());
        XWPFDocument x = new XWPFDocument(fileInputStream);

        List<XWPFParagraph> paragraphs;
        paragraphs = x.getParagraphs();
        return paragraphs;
    }

}
