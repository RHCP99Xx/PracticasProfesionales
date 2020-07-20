/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.ArrayList;

/**
 *
 * @author Adair Hernández
 */
public class RecordPojo {
    private double finalGrade;
    private String comments;
    private int totalHoursCovered;
    ArrayList<DocumentPojo> documents;
    
    public RecordPojo(){
        this.documents = new ArrayList<>();
    }

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }
    
    public double getFinalGrade() {
        return finalGrade;
    }
    

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getTotalHoursCovered() {
        return totalHoursCovered;
    }

    public void setTotalHoursCovered(int totalHoursCovered) {
        this.totalHoursCovered = totalHoursCovered;
    }
    
    public void addDocument(DocumentPojo document){
        this.documents.add(document);
    }
    
}
