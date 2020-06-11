/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_validators_tests;

import file.DocxWriter;
import java.io.IOException;
import org.junit.Test;
import static org.junit.Assert.*;
import pojo.DocumentPojo;

/**
 *
 * @author Adair Hernández
 */
public class DocxWriterTest {
    
    public DocxWriterTest() {
    }
    
    @Test(expected = NullPointerException.class)
    public void writeDocumentThrowsNullPointerException() throws IOException,
            NullPointerException{
        DocxWriter writer = new DocxWriter(null);
        writer.write();
    }
    
}
