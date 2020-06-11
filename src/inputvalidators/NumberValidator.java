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
public class NumberValidator {
    private final Pattern validPattern;
    private Matcher patternMatcher;
    
    public NumberValidator(){
        this.validPattern = Pattern.compile("[0-9]*");
    }
    
    public boolean isValid(String input) throws NullPointerException{
        if(input == null){
            throw new NullPointerException("");
        }
        this.patternMatcher = validPattern.matcher(input);
        return this.patternMatcher.matches();
    }
}
