/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Adair Hernández
 */
public class DateFormatter {
    
    public Date getLocalDate(DatePicker datePicker){
        LocalDate localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);
        return date;
    }
    
    public LocalDate getLocalDate(Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
    
    public java.sql.Date getSqlDate(Date date){
        long time = date.getTime();
        return new java.sql.Date(time);
    }
    
}
