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
import pojo.UserPojo;

/**
 *
 * @author Adair Hernández
 */
public class LoginControllerTest {

    public LoginControllerTest() {
    }

    @Test(expected = NonExistentUserException.class)
    public void getUserFromDatabaseThrowsNonExistentUserException() throws SQLException, NonExistentUserException {
        String email = "";
        String password = "";
        User user = new User();
        UserPojo myUser = user.getUser(email, password);
    }

    @Test
    public void getUserFromDatabase() throws SQLException, NonExistentUserException {
        String email = "adairho16@gmail.com";
        String password = "123";
        User user = new User();
        UserPojo myUser = user.getUser(email, password);
    }


}
