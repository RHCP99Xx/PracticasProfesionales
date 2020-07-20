/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.models;

import java.sql.SQLException;
import models.Record;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import pojo.RecordPojo;

/**
 *
 * @author edgar
 */
public class ModelRecord_Test{
    
    private Record record;
    private RecordPojo recordPojo;
    
    @Before
    public void initializeRecordInstance(){
        this.record = new Record();
        this.recordPojo = new RecordPojo();
    }
    
    @Test
    public void getRecordByNameSuccesfully() throws SQLException, NullPointerException, Exception{
        recordPojo = record.getRecordByName("Adair Benjamin");
        assertNotNull(recordPojo);
    }
}
