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
import pojo.LinkedOrganizationPojo;
import pojo.ParticipationPojo;
import pojo.ProjectPojo;
import pojo.StudentPojo;

/**
 *
 * @author edgar
 */
public class ParticipationPojoTest {
    
    private ParticipationPojo participation;
    
    
    @Before
    public void initializeInstance() throws Exception{
        this.participation = new ParticipationPojo();
    }
    
    @Test
    public void setAndGetProjectTest(){
        ProjectPojo project = new ProjectPojo();
        participation.setProject(project);
        assertEquals(project, participation.getProject());
    }
    
    @Test
    public void setAndGetStudentTest(){
        StudentPojo student = new StudentPojo();
        participation.setStudent(student);
        assertEquals(student, participation.getStudent());
    }
    
    @Test
    public void setAndGetLinkedOrganizationTest(){
        LinkedOrganizationPojo lo = new LinkedOrganizationPojo();
        participation.setOrganization(lo);
        assertEquals(lo, participation.getOrganization());
    }
    
    @Test
    public void setAndGetBlockTest(){
        int block = 1;
        participation.setBlock(block);
        assertEquals(block, participation.getBlock());
    }
    
    @Test
    public void setAndGetFinalDateTest(){
        Date fDate = new Date();
        participation.setFinalDate(fDate);
        assertEquals(fDate, participation.getFinalDate());
    }
    
    @Test
    public void setAndGetInitialDateTest(){
        Date iDate = new Date();
        participation.setInitialDate(iDate);
        assertEquals(iDate, participation.getInitialDate());
    }
    
    @Test
    public void setAndGetNRCTest(){
        String nrc = "23432";
        participation.setNrc(nrc);
        assertEquals(nrc, participation.getNrc());
    }
    
    @Test
    public void setAndGetPeriodTest(){
        String period = "Periodo 1";
        participation.setPeriod(period);
        assertEquals(period, participation.getPeriod());
    }
    
    @Test
    public void setAndGetSectionTest(){
        int section = 2;
        participation.setSection(section);
        assertEquals(section, participation.getSection());
    }
}
