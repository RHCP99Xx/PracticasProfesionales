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
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import pojo.DocumentPojo;

/**
 *
 * @author Adair Hernández
 */
public class DocReader implements DocumentReader{

    private DocumentPojo document;
    
    public DocReader(DocumentPojo document){
        this.document = document;
    }
    
    public void task(){
        try{
            FileInputStream fis = new FileInputStream("myDirectory/Hola.doc");
            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor extractor = new WordExtractor(doc);
            String[] fileData = extractor.getParagraphText();
            
            for(String paragraph : fileData){
                System.out.println(paragraph);
            }
            
        }catch(FileNotFoundException e){
            
        }catch(IOException e2){
            
        }
    }
    
    
    
    @Override
    public List<XWPFParagraph> getParagraphs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
