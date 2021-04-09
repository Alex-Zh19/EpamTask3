package com.epam.task3.validator;


public class CustomValidator {
    private static final String REG_EXP_TO_VALIDATE_STRING = "^((-)?([0]|[1-9]\\d*)\\,)*(-)?([0]|[1-9]\\d*)$";

    public static boolean validateString(String str) {
        return str.matches(REG_EXP_TO_VALIDATE_STRING);
    }


}
