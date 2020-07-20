/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests_Edgar.models;

import java.io.IOException;
import java.sql.SQLException;
import models.Participation;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.Before;
import pojo.ParticipationPojo;

/**
 *
 * @author edgar
 */
public class ModelParticipationTest {
    
    private Participation participation;
    private ParticipationPojo participationPojo;
    
    @Before
    public void initializeInstances() {
        this.participation = new Participation();
        
    }
    
    @Test
    public void getParticipationTest() throws IOException, SQLException, Exception{
        participationPojo = participation.getParticipation("Adair Benjamin");
        assertNotNull(participationPojo.getOrganization());
        assertNotNull(participationPojo.getProject());
        assertNotNull(participationPojo.getStudent());
    }
}
