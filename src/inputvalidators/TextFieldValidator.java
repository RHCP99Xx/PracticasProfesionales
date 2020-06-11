/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputvalidators;

import exceptions.FormInputException;
import javafx.scene.control.TextField;

/**
 *
 * @author Adair Hernández
 */
public class TextFieldValidator {
    public void validate(TextField textField) throws FormInputException{
        if(textField.getText().equals("")){
            throw new FormInputException("Campo vacío");
        }
    }
}
