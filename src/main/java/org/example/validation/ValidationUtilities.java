package org.example.validation;

public class ValidationUtilities {
    public static boolean isValidEmail(String email){
        // provides a basic validation for email string.
        // each email string must have '@' symbol and two parts (after and before the symbol)
        if(!email.contains("@")){
            return false;
        }

        String[] parts = email.split("@");
        return parts.length == 2;
    }
}
