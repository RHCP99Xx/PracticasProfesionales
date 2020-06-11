/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputvalidators;

import exceptions.FormInputException;
import javafx.scene.control.DatePicker;

/**
 *
 * @author Adair Hernández
 */
public class DatePickerValidator {
    public void validate(DatePicker datePicker) throws FormInputException{
        if(datePicker.getValue() == null){
            throw new FormInputException("DatePicker vacío");
        }
    }
}
