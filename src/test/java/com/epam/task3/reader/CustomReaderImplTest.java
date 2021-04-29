package com.epam.task3.reader;

import com.epam.task3.exception.CubeException;
import com.epam.task3.reader.impl.CustomReaderImpl;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

public class CustomReaderImplTest {
    final static String PATH_TO_FILE = "data/CubeTest.txt";


    @Test
    public void testReadFile() {
        CustomReaderImpl reader = new CustomReaderImpl();

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL pathToFileUrl = classLoader.getResource(PATH_TO_FILE);
        List<String> stringFormFileExpected = new ArrayList<>();
        String str1 = "cube  :  name   :  (  43  ;  45  ,  56  ),  1122.12";
        String str2 = "cube  : name :(43,45,65),12";
        String str3 = "cube:name:(  43.44 ,45.444,65.444),12";
        String str4 = "cube:name:(43,45,65);12";
        String str5 = "cube:   name   :   (   -43 ;45,-56),    1122";

        stringFormFileExpected.add(str1);
        stringFormFileExpected.add(str2);
        stringFormFileExpected.add(str3);
        stringFormFileExpected.add(str4);
        stringFormFileExpected.add(str5);

        try {
            List<String> stringFromFileActual =
                    reader.readFile(new File(pathToFileUrl.getFile()).getAbsolutePath());
            assertEquals(stringFromFileActual, stringFormFileExpected);
        } catch (CubeException e) {

        }

    }
}