package com.epam.task3.parser;

import com.epam.task3.exception.CubeException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CustomParser {
    private final String REG_TO_CREATE_ARRAY_FOR_POINT = "[,]|[;]";

    public List<String> parseStringsToGetNames(List<String> validStrings) throws CubeException {
        if (validStrings == null) {
            throw new CubeException("Valid strings list is null");
        }
        List<String> names = new ArrayList<>();
        for (String string : validStrings) {
            String name = string.substring(0, string.indexOf(':'));
            names.add(name.trim());

        }
        return names;
    }

    public List<int[]> parseStringsToGetIntArray(List<String> validStrings) throws CubeException {
        if (validStrings == null) {
            throw new CubeException("Valid strings list is null");
        }
        List<int[]> values = new ArrayList<>();

        for (String string : validStrings) {
            String valueForCenter = string.substring(string.indexOf('(') + 1, string.indexOf(')'));
            int[] arrayForCenterPoint = createArrayForPoint(valueForCenter);
            int sideLength = findSideLengthInString(string);
            arrayForCenterPoint[arrayForCenterPoint.length - 1] = sideLength;
            values.add(arrayForCenterPoint);
        }
        return values;
    }


    private int[] createArrayForPoint(String valueForCenter) {
        String[] stringNumeralsForPoint = valueForCenter.split(REG_TO_CREATE_ARRAY_FOR_POINT);
        int[] numeralsForPoint = new int[4];
        for (int i = 0; i < 3; i++) {
            numeralsForPoint[i] = Integer.parseInt(stringNumeralsForPoint[i].trim());
        }
        return numeralsForPoint;
    }

    private int findSideLengthInString(String string) throws CubeException {
        String lastSymbolsWithSideLength = string.substring(string.indexOf(')') + 1);
        int positionOfFirstSymbolOfRadius = 0;
        for (int i = lastSymbolsWithSideLength.length() - 1; i >= 0; i--) {
            if (lastSymbolsWithSideLength.charAt(i) == ';' || lastSymbolsWithSideLength.charAt(i) == ',') {
                positionOfFirstSymbolOfRadius = i;
            }
        }
        String value = lastSymbolsWithSideLength.substring(positionOfFirstSymbolOfRadius + 1);
        value = value.trim();
        Integer sideLength = Integer.parseInt(value);
        return sideLength;
    }
}
