package com.epam.task3.validator;


public class CustomValidator {
    private static final String REG_EXP_TO_VALIDATE_STRING =
            "^\\w+\\s{0,4}[:]\\s{0,4}[(][-]?\\s{0,4}[0-9]+\\s{0,4}(,|;)[-]?\\s{0,4}[0-9]+\\s{0,4}(,|;)[-]?\\s{0,4}[0-9]+\\s{0,4}[)](,|;)\\s{0,4}[0-9]+$";
//сменить для даблов регэкспу
    public static boolean validateString(String str) {
        return str.matches(REG_EXP_TO_VALIDATE_STRING);
    }


}
