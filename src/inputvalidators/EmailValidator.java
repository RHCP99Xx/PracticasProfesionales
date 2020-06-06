/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputvalidators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Adair Hernández
 */
public class EmailValidator {    
    private final Pattern validPattern;
    private Matcher patternMatcher;
    
    public EmailValidator(){
        this.validPattern = Pattern.compile("[a-zA-Z0-9]+@[a-z]+[.][a-z]+");
        
    }
    
    public boolean isValid(String email){
        this.patternMatcher = validPattern.matcher(email);
        return this.patternMatcher.matches();
    }
    
    
}
