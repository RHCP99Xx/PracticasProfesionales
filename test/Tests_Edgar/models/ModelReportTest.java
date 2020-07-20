/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.models;

import java.sql.SQLException;
import java.util.ArrayList;
import models.Record;
import models.Report;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pojo.ReportPojo;

/**
 *
 * @author edgar
 */
public class ModelReportTest {
    
    private Report report;
    private ReportPojo reportPojo;
    
    @Before
    public void initializeRecordInstance(){
        this.report = new Report();
        this.reportPojo = new ReportPojo();
    }
    
    @Test
    public void getRecordByNameSuccesfully() throws SQLException, NullPointerException, Exception{
        ArrayList<ReportPojo> reportList = report.getReportsByName("Adair Benjamin");
        assertTrue(reportList.size() > 0);
    }
}
