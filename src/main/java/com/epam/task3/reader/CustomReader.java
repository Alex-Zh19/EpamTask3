package com.epam.task3.reader;

import com.epam.task3.exception.CubeException;
import com.epam.task3.validator.CustomValidator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CustomReader {
    final static Logger logger= LogManager.getLogger();
    public List<String> readFile(String fileName) throws CubeException {
        if(fileName==null){
            logger.log(Level.ERROR,"Filepath is null");
            throw new CubeException("Filepath is null");
        }
        File file= new File(fileName);
        if(!file.isFile()||!file.exists()){
            logger.log(Level.ERROR,"file isn't exist :"+fileName);
            throw new CubeException("file isn't exist :"+fileName);
        }
        if(!file.canRead()){
            logger.log(Level.ERROR,"can't read file :"+fileName);
            throw new CubeException("can't read file :"+fileName);
        }
        if(file.length()==0){
            logger.log(Level.ERROR,"file is empty :"+fileName);
            throw new CubeException("file is empty :"+fileName);
        }
        List<String>validString=new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            validString.add(stream.filter(i -> CustomValidator.validateString(i)).toString());
        } catch (IOException exception) {
            throw new CubeException(exception);
        }
        if(validString.isEmpty()){
            logger.log(Level.ERROR,"incorrect data in file :"+fileName);
            throw new CubeException("incorrect data in file :"+fileName);
        }
        return validString;
    }
}
