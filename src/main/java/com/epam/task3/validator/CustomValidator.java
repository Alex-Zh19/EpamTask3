package com.epam.task3.validator;


public class CustomValidator {
    private static final String REG_EXP_TO_VALIDATE_STRING_IN_FILE =
            "^\\w+\\s{0,4}[:]\\s{0,4}\\w+\\s{0,4}[:]\\s{0,4}" +//name and type
                    "[(]\\s{0,4}[-]?[0-9]+[.]?[0-9]+\\s{0,4}(,|;)" +//first coordinate
                    "\\s{0,4}[-]?[0-9]+[.]?[0-9]+\\s{0,4}(,|;)" +//second coordinate
                    "\\s{0,4}[-]?[0-9]+[.]?[0-9]+\\s{0,4}[)]" +//third coordinate
                    "(,|;)\\s{0,4}[0-9]+[.]?[0-9]+$";//side length

    public static boolean validateString(String str) {
        return str.matches(REG_EXP_TO_VALIDATE_STRING_IN_FILE);
    }


}
