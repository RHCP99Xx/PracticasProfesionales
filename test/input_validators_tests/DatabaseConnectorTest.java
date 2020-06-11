/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_validators_tests;

import database.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adair Hernández
 */
public class DatabaseConnectorTest {
    
    public DatabaseConnectorTest() {
    }
    
    @Test
    public void getConnection() throws SQLException{
        DatabaseConnector dbc = new DatabaseConnector();
        Connection connection = dbc.getConnection();
    }
    
    @Test(expected = NullPointerException.class)
    public void closeConnection() throws SQLException{
        DatabaseConnector dbc = new DatabaseConnector();
        Connection connection = dbc.getConnection();
        connection.close();
        assertEquals(null, connection);
    }
    
}
