/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author Adair Hernández
 */
public class NonExistentUserException extends Exception{
    public NonExistentUserException(String message){
        super(message);
    }
}
