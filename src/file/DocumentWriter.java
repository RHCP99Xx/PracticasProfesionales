/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.FileNotFoundException;
import java.io.IOException;
import pojo.DocumentPojo;

/**
 *
 * @author Adair Hernández
 */
public interface DocumentWriter {
    public boolean write() throws FileNotFoundException, IOException;
}
