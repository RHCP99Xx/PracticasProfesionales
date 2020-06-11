/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_validators_tests;

import exceptions.NoFileChosenException;
import file.DocxReader;
import java.io.IOException;

import org.junit.Test;
import static org.junit.Assert.*;
import pojo.DocumentPojo;
import utils.FileChooserWindow;

/**
 *
 * @author Adair Hernández
 */
public class DocxReaderTest {

    public DocxReaderTest() {
    }


    @Test(expected = IOException.class)
    public void readDocumentThrowsIOException() throws IOException {
        DocumentPojo document = new DocumentPojo();
        document.setPath("");
        DocxReader reader = new DocxReader(document);
        reader.getParagraphs();
    }

    @Test(expected = NullPointerException.class)
    public void readDocumentThrowsNullPointerException()
            throws NullPointerException, IOException {
        DocxReader reader = new DocxReader(null);
        reader.getParagraphs();
    }
    
    @Test
    public void readDocument() throws NoFileChosenException, IOException{
        DocumentPojo document = new DocumentPojo();
        document.setPath("/myDirectory/Hola.docx");
        DocxReader reader = new DocxReader(document);
        
        reader.getParagraphs();
    }

}
