package com.epam.task3.parser;

import com.epam.task3.exception.CubeException;

import java.util.ArrayList;
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

    public List<double[]> parseStringsToGetIntArray(List<String> validStrings) throws CubeException {
        if (validStrings == null) {
            throw new CubeException("Valid strings list is null");
        }
        List<double[]> values = new ArrayList<>();

        for (String string : validStrings) {
            String valueForCenter = string.substring(string.indexOf('(') + 1, string.indexOf(')'));
            double[] arrayForCenterPoint = createArrayForPoint(valueForCenter);
            double sideLength = findSideLengthInString(string);
            arrayForCenterPoint[arrayForCenterPoint.length - 1] = sideLength;
            values.add(arrayForCenterPoint);
        }
        return values;
    }


    private double[] createArrayForPoint(String valueForCenter) {
        String[] stringNumeralsForPoint = valueForCenter.split(REG_TO_CREATE_ARRAY_FOR_POINT);
        double[] numeralsForPoint = new double[4];
        for (int i = 0; i < 3; i++) {
            numeralsForPoint[i] = Double.parseDouble(stringNumeralsForPoint[i].trim());
        }
        return numeralsForPoint;
    }

    private double findSideLengthInString(String string) throws CubeException {
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
