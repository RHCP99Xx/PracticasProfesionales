/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input_validators_tests;

import inputvalidators.DateValidator;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;
import utils.DateFormatter;

/**
 *
 * @author Adair Hernández
 */
public class DateValidatorTest {

    public DateValidatorTest() {
    }

    @Test
    public void validateValidDates() throws ParseException {
        boolean expected = true;
        DateValidator dv = new DateValidator();
        Date date1 = new Date(2020, 6, 8);
        Date date2 = new Date(2020, 6, 20);
        LocalDate localDate1 = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        boolean result = dv.validateStartingAndEndingDate(localDate1, localDate2);
        assertEquals(expected, result);
    }

    @Test
    public void validateInvalidDates() throws ParseException {
        boolean expected = false;

        DateValidator dv = new DateValidator();
        DateFormatter df = new DateFormatter();

        Date date1 = new Date(2020, 6, 28);
        Date date2 = new Date(2020, 6, 20);

        LocalDate localDate1 = df.getLocalDate(date1);
        LocalDate localDate2 = df.getLocalDate(date2);

        boolean result = dv.validateStartingAndEndingDate(localDate1, localDate2);
        assertEquals(expected, result);
    }
    
    

}
