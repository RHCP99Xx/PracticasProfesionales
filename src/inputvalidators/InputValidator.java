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
public abstract class InputValidator {
    
    public static boolean isValid(String input, String pattern){
        Pattern validPattern = Pattern.compile(pattern);
        Matcher patternMatcher = validPattern.matcher(input);
        return patternMatcher.matches();
    }
}
