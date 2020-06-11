/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

/**
 *
 * @author Adair Hernández
 */
class NoFileSpecifiedException extends Exception {
    public NoFileSpecifiedException(String message){
        super(message);
    }
}
