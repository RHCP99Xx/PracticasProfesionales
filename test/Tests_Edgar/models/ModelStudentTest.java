/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.models;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Report;
import models.Student;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pojo.ReportPojo;
import pojo.StudentPojo;

/**
 *
 * @author edgar
 */
public class ModelStudentTest {
    
    private Student student;
    private StudentPojo studentPojo;
    
    
    @Before
    public void initializeRecordInstance(){
        this.student = new Student();
    }
    
    @Test
    public void getStudentsByStatusTest() throws SQLException, NullPointerException, Exception{
        ArrayList<StudentPojo> studentsList = student.getStudentsByStatus("Activo");
        assertTrue(studentsList.size() > 0);
    }
}

