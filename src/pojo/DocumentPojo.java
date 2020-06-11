/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author Adair Hernández
 */
public class DocumentPojo {
    
    protected String name;
    protected String path;
    protected double size;
    protected Date uploadDate;    
    
    public DocumentPojo(String name, String path, double size){
        this.name = name;
        this.path = path;
        this.size = size;
    }
    
    public DocumentPojo(){
        
    }
    
    /**
     * Este método devuelve el nombre del documento.
     * @return  el nombre del documento.
     */
    public String getName() {
        return name;
    }

    /**
     * Este método asigna el nombre al documento.
     * @param name el nombre que se asignará al documento.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Este método devuelve el path del documento.
     * @return el path del documento.
     */
    public String getPath() {
        return path;
    }

    /**
     * Este método asigna el path al documento.
     * @param path el path que se asignará al documento.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Este método devuelve el tamaño del documento.
     * @return el tamaño del documento.
     */
    public double getSize() {
        return size;
    }

    /**
     * Este método asigna el tamaño al documento.
     * @param size el tamaño que se asignará al documento.
     */
    public void setSize(double size) {
        this.size = size;
    }
    

    /**
     * Este método devuelve la fecha de subida del documento.
     * @return la fecha de subida del documento.
     */
    public Date getUploadDate() {
        return uploadDate;
    }

    /**
     * Este método asigna la fecha de subida al documento.
     * @param uploadDate la fecha de subida que se asignará al documento.
     */
    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }
    
    
}
