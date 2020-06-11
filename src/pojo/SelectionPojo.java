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
public class SelectionPojo {
        
    private Date date;
    private int position;
    private int period;
    
    private StudentPojo student;
    private ProjectPojo project;

    public StudentPojo getStudent() {
        return student;
    }

    public void setStudent(StudentPojo student) {
        this.student = student;
    }

    public ProjectPojo getProject() {
        return project;
    }

    public void setProject(ProjectPojo project) {
        this.project = project;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
    
    public String getProjectName(){
        return this.project.getName();
    }
    
    
}
