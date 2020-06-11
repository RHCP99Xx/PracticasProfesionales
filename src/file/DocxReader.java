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
public class DocxReader{

    private DocumentPojo document;

    public DocxReader(DocumentPojo document) {
        this.document = document;
    }

    public List<XWPFParagraph> getParagraphs() throws FileNotFoundException,
            IOException, NullPointerException {
        if(this.document == null){
            throw new NullPointerException("Por favor seleccione un archivo");
        }
        FileInputStream fileInputStream = new FileInputStream(this.document.getPath());
        XWPFDocument x = new XWPFDocument(fileInputStream);

        List<XWPFParagraph> paragraphs;
        paragraphs = x.getParagraphs();
        return paragraphs;
    }

}
