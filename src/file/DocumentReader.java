/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.util.List;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

/**
 *
 * @author Adair Hernández
 * 
 */
public interface DocumentReader {
    /**
     * 
     * @return Los párrafos del documento a leer
     */
    public List<XWPFParagraph> getParagraphs();
}
