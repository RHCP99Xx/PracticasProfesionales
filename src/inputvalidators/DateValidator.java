/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputvalidators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author Adair Hernández
 */
public class DateValidator {    
    
    public boolean validateStartingAndEndingDate(LocalDate startingDate, LocalDate endingDate) throws ParseException{
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        
        String startingDateString = startingDate.format(dateTimeFormatter);
        String endingDateString = endingDate.format(dateTimeFormatter);
        
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        
        Date d = sdformat.parse(startingDateString);
        Date d2 = sdformat.parse(endingDateString);
        
        return d.compareTo(d2) < 0;               
    }
}
