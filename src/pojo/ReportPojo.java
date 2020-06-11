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
public class ReportPojo extends DocumentPojo {
    private String comments;    
    private Date initialDate;
    private Date endingDate;
    private int coveredHours;
    private String status;
    
    
    public ReportPojo(String name, String path, double size, Date initialDate, 
            Date endingDate, int coveredHours){
        super(name, path, size);
        this.initialDate = initialDate;
        this.endingDate = endingDate;
        this.coveredHours = coveredHours;
    }
    
    public ReportPojo(){
        
    }
    

    /**
     * Este método devuelve los comentarios que se han añadido al reporte.
     * @return los comentarios que se han añadido al reporte.
     */
    public String getComments() {
        return comments;
    }

    /**
     * Este método asigna los comentarios al reporte.
     * @param comments los comentarios que se asignarán al reporte.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Este método devuelve la fecha desde la que comienza el alcance del reporte.
     * @return la fecha desde la que comienza a abarcar el reporte.
     */
    public Date getInitialDate() {
        return initialDate;
    }

    /**
     * Este método asigna la fecha desde la que comienza el alcance del reporte.
     * @param initialDate la fecha desde la que comienza el periodo abarcado
     * por el reporte.
     */
    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    /**
     * Este método devuelve la fecha en la que termina el alcance del reporte.
     * @return la fecha en la que termina el periodo cubierto por el reporte.
     */
    public Date getEndingDate() {
        return endingDate;
    }

    /**
     * Este método asigna la fecha en la que termina el alcance del reporte.
     * @param endingDate la fecha en la que termina el periodo cubierto por el 
     * reporte.
     */
    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    /**
     * Este método devuelve las horas que cubre el reporte.
     * @return las horas que cubre el reporte.
     */
    public int getCoveredHours() {
        return coveredHours;
    }

    /**
     * Este método asigna las horas que cubre el reporte.
     * @param coveredHours las hroas que cubre el reporte.
     */
    public void setCoveredHours(int coveredHours) {
        this.coveredHours = coveredHours;
    }

    /**
     * Este método devuelve el estado del reporte. El estado puede ser "Aceptado",
     * "Pendiente de aceptación" y "No aceptado"
     * @return el estado del reporte.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Este método asigna el estado del reporte.
     * @param status el estado del reporte.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
