package com.epam.task3.parser;

import com.epam.task3.exception.CubeException;

import java.util.List;

public interface CustomParser {
     List<String[]> parseStringsToGetTypesAndNames(List<String> validStrings) throws CubeException;

     List<double[]> parseStringsToGetDoubleArray(List<String> validStrings) throws CubeException;
}
