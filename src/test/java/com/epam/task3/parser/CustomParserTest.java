package com.epam.task3.parser;

import com.epam.task3.exception.CubeException;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomParserTest {

    @Test
    public void testParseStringsToGetTypeAndNames() {
        CustomParser parser = new CustomParser();
        List<String> list = new ArrayList<>();
        String str1 = " cube:   name   :   (43 ;45,  56),    1122    ";
        String str2 = " cube:   name1   :   (43 ;45,  -56),    11    ";
        String str3 = " cube:   name2   :   (43 ;-45,  56),    22    ";
        list.add(str1);
        list.add(str2);
        list.add(str3);

        String[] str1Exp = new String[2];
        str1Exp[0] = "cube";
        str1Exp[1] = "name";
        String[] str2Exp = new String[2];
        str2Exp[0] = "cube";
        str2Exp[1] = "name1";
        String[] str3Exp = new String[2];
        str3Exp[0] = "cube";
        str3Exp[1] = "name2";

        List<String[]> listExpected = new ArrayList<>();
        listExpected.add(str1Exp);
        listExpected.add(str2Exp);
        listExpected.add(str3Exp);
        try {
            List<String[]> listActual = parser.parseStringsToGetTypesAndNames(list);
            assertEquals(listActual, listExpected);
        } catch (CubeException e) {

        }
    }

    @Test
    public void testParseStringsToGetIntArray() {
        CustomParser parser = new CustomParser();
        List<String> list = new ArrayList<>();
        String str1 = " cube:   name   :   (43 ;45,  56),    1122";
        String str2 = " cube:   name1   :   (43 ;45,  -56),    11";
        String str3 = " cube:   name2   :   (43 ;-45,  56),    22";
        list.add(str1);
        list.add(str2);
        list.add(str3);

        List<double[]> listExpected = new ArrayList<>();
        double[] arr1 = new double[]{43, 45, 56, 1122};
        double[] arr2 = new double[]{43, 45, -56, 11};
        double[] arr3 = new double[]{43, -45, 56, 22};
        listExpected.add(arr1);
        listExpected.add(arr2);
        listExpected.add(arr3);

        try {
            List<double[]> listActual = parser.parseStringsToGetDoubleArray(list);
            assertEquals(listExpected, listActual);
        } catch (CubeException e) {

        }
    }
}