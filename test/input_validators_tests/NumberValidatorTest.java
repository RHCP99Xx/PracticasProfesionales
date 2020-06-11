/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_validators_tests;

import inputvalidators.NumberValidator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adair Hernández
 */
public class NumberValidatorTest {

    public NumberValidatorTest() {
    }

    @Test
    public void validateValidNumber() {
        boolean expected = true;
        NumberValidator nv = new NumberValidator();
        boolean result = nv.isValid("19");
        assertEquals(expected, result);
    }

    @Test
    public void validateInvalidNumber() {
        boolean expected = false;
        NumberValidator nv = new NumberValidator();
        boolean result = nv.isValid("1s");
        assertEquals(expected, result);
    }
    
    @Test(expected = NullPointerException.class)
    public void validationThrowsNullPointerException(){
        NumberValidator nv = new NumberValidator();
        nv.isValid(null);
    }

}
