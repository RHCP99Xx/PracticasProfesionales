/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_validators_tests;

import exceptions.NonExistentUserException;
import java.sql.SQLException;
import models.User;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adair Hernández
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @Test(expected = NonExistentUserException.class)
    public void getUserThrowsNonExistentUserException() 
            throws SQLException, NonExistentUserException{
        User user = new User();
        user.getUser(null, null);        
    }
    
    @Test
    public void getUser() throws SQLException, NonExistentUserException{
        User user = new User();
        user.getUser("adairho16@gmail.com", "123");
    }
    
}
