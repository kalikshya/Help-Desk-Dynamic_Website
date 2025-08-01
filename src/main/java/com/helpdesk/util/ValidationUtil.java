package com.helpdesk.util;

import java.util.regex.Pattern;

public class ValidationUtil {

    private static final String NAME_REGEX = "^[A-Za-z\\s]{2,50}$";

    public static boolean isValidFullName(String full_name) {
        return full_name != null && Pattern.matches(NAME_REGEX, full_name);
    }
    
    //  Check if string is null or empty
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    //  Validate if a string contains only letters
    public static boolean isAlphabetic(String value) {
        return value != null && value.matches("^[a-zA-Z]+$");
    }

    //  Validate if a string starts with a letter and is alphanumeric
    public static boolean isAlphanumericStartingWithLetter(String value) {
        return value != null && value.matches("^[a-zA-Z][a-zA-Z0-9]*$");
    }

    // 4. Validate email format
    private static final Pattern EMAIL_REGEX = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,6}$");
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_REGEX.matcher(email).matches();
    }
    
    // Validate if a password has at least 1 capital letter, 1 number, and 1 symbol
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password != null && password.matches(passwordRegex);
    }


    //  Validate if password and retype password match
    public static boolean doPasswordsMatch(String password, String retypePassword) {
        return password != null && password.equals(retypePassword);
    }
}


