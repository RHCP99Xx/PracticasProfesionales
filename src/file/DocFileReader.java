/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;


/**
 *
 * @author Adair Hernández
 */
public class DocFileReader {
    
    private String filePath;
    
    public DocFileReader(String filePath){
        this.filePath = filePath;
    }
    
        public void read(String filePath){
        try{
          readDocument();
        }catch(FileNotFoundException e){
            
        }catch(IOException e2){
            
        }  
    }
        
        private void readDocument() throws FileNotFoundException, IOException{
            FileInputStream fis = new FileInputStream(this.filePath);
            HWPFDocument doc = new HWPFDocument(fis);
            
            WordExtractor extractor = new WordExtractor(doc);
            
            String[] fileData = extractor.getParagraphText();
            for(String paragraph : fileData){
              System.out.println(paragraph);
            }
        }


}
