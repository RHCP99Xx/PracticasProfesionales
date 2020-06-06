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
public class PhoneNumberValidator {
    
    private final Pattern validPattern;
    private Matcher patternMatcher;
    
    public PhoneNumberValidator(){
        this.validPattern = Pattern.compile("[0-9]{10}");
    }
    
    public boolean isValid(String phoneNumber){
        this.patternMatcher = validPattern.matcher(phoneNumber);
        return this.patternMatcher.matches();
    }
}
