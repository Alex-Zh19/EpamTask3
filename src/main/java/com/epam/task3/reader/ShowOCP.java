package com.epam.task3.reader;

import com.epam.task3.exception.CubeException;
import com.epam.task3.reader.impl.CustomReaderImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ShowOCP extends CustomReaderImpl implements CustomReader{
    private static final Logger logger= LogManager.getLogger();

    @Override
    public List<String> readFile(String path) throws CubeException {
        beforeReading();
        String pathToFile="FilePath";
        List<String> list=super.readFile(pathToFile);
        afterReading();
        return list;
    }

    private void beforeReading(){
        logger.log(Level.INFO,"Hello");
    }
    private void afterReading(){
        logger.log(Level.INFO,"World!");
    }
}
