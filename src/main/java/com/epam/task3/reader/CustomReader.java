package com.epam.task3.reader;

import com.epam.task3.exception.CubeException;

import java.util.List;

public interface CustomReader {
     List<String>readFile(String fileName)throws CubeException;
}
