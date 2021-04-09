package com.epam.task3.reader;

import com.epam.task3.exception.ShapeException;
import com.epam.task3.validator.CustomValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CustomReader {
    final static Logger logger= LogManager.getLogger();
    public String readFile(String fileName) throws ShapeException {
        if(fileName==null){
            logger.log(Level.ERROR,"Filepath is null");
            throw new ShapeException("Filepath is null");
        }
        File file= new File(fileName);
        if(!file.isFile()||!file.exists()){
            logger.log(Level.ERROR,"file isn't exist :"+fileName);
            throw new ShapeException("file isn't exist :"+fileName);
        }
        if(!file.canRead()){
            logger.log(Level.ERROR,"can't read file :"+fileName);
            throw new ShapeException("can't read file :"+fileName);
        }
        if(file.length()==0){
            logger.log(Level.ERROR,"file is empty :"+fileName);
            throw new ShapeException("file is empty :"+fileName);
        }
        String validString;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            validString = stream.filter(i -> CustomValidator.validateString(i)).findFirst().orElse(null);
        } catch (IOException exception) {
            throw new ShapeException(exception);
        }
        if(validString==null){
            logger.log(Level.ERROR,"incorrect data in file :"+fileName);
            throw new ShapeException("incorrect data in file :"+fileName);
        }
        return validString;
    }
}
