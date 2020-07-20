/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.pojos;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pojo.ReportPojo;

/**
 *
 * @author edgar
 */
public class ReportPojoTest {
    
    private ReportPojo report;
    
    @Before
    public void initializeInstance(){
        this.report = new ReportPojo();
    }
    
    @Test
    public void setAndGetCommentsTest(){
       String comments = "Que buen reporte";
       report.setComments(comments);
       assertEquals(comments, report.getComments());
    }
    
    @Test
    public void setAndGetInitialDateTest(){
        Date date = new Date();
        report.setInitialDate(date);
        assertEquals(date, report.getInitialDate());
    }
    
    @Test
    public void setAndGetEndingDateTest(){
        Date date = new Date();
        report.setEndingDate(date);
        assertEquals(date, report.getEndingDate());
    }
    
    @Test
    public void setAndGetCoveredHoursTest(){
        int coveredHours = 23;
        report.setCoveredHours(coveredHours);
        assertEquals(coveredHours, report.getCoveredHours());
    }
    
    @Test
    public void setAndGetStatusTest(){
        String status = "Aprobado";
        report.setStatus(status);
        assertEquals(status, report.getStatus());
    }
    
}
