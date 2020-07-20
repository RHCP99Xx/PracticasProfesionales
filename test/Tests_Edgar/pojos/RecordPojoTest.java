/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.pojos;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pojo.RecordPojo;

/**
 *
 * @author edgar
 */
public class RecordPojoTest {
    
    private RecordPojo record;
    
    @Before
    public void initializeIntance(){
        this.record = new RecordPojo();
    }
    
    @Test
    public void setAndGetFinalGradeTest(){
        double fGrade = 10.0;
        record.setFinalGrade(fGrade);
        assertEquals(fGrade, record.getFinalGrade(), 0.1);
    }
    
    @Test
    public void setAndGetCommentsTest(){
        String comment = "Hola, buenas noches";
        record.setComments(comment);
        assertEquals(comment, record.getComments());
    }
    
    @Test
    public void setAndGetHoursCovered(){
        int hoursCovered = 220;
        record.setTotalHoursCovered(hoursCovered);
        assertEquals(hoursCovered, record.getTotalHoursCovered());
    }
}
