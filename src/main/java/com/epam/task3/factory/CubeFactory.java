package com.epam.task3.factory;

import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;
import com.epam.task3.util.IdGenerator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CubeFactory {
    private final static Logger logger = LogManager.getLogger();
    private final String CUBE_SHAPE = "cube";
    private final String ANY_OTHER_SHAPE = "shape";

    public Cube createShape(String type, String name, int sideLength, double x, double y, double z) throws CubeException {
        name = checkCubeParameters(type, name, sideLength);
        CustomPoint centerPoint = createPoint(x, y, z);
        return chooseShapeAndCreateIt(type, name, sideLength, centerPoint);

    }

    public Cube createShape(String type, String name, int sideLength, CustomPoint centerPoint) throws CubeException {
        name = checkCubeParameters(type, name, sideLength);
        return chooseShapeAndCreateIt(type, name, sideLength, centerPoint);

    }

    public List<Cube> createShape(List<String[]> typeAndName, List<double[]> parametersList) throws CubeException {
        List<Cube> shapeList = new ArrayList<>();
        if (typeAndName == null) {
            throw new CubeException("type and name list cannot be null");
        }
        if (parametersList == null) {
            throw new CubeException("parameterList cannot be null");
        }
        if (parametersList.isEmpty()) {
            throw new CubeException("parameterList is empty");
        }
        if (typeAndName.isEmpty()) {
            throw new CubeException("type and name list is empty");
        }
        if (typeAndName.size() != parametersList.size()) {
            throw new CubeException("part of input data wrong");
        }
        for (int i = 0; i < typeAndName.size(); i++) {
            String[] dataTypeAndName = typeAndName.get(i);
            double[] dataParameter = parametersList.get(i);
            String type = dataTypeAndName[0];
            String name = dataTypeAndName[1];
            switch (type.toLowerCase()) {
                case CUBE_SHAPE://create cube
                    CustomPoint centerPoint = createPoint(dataParameter[0], dataParameter[1], dataParameter[2]);
                    double sideLength = dataParameter[dataParameter.length - 1];
                    Cube newCube = createCube(type, name, sideLength, centerPoint);
                    shapeList.add(newCube);
                    break;
                case ANY_OTHER_SHAPE://create other shape
                    logger.log(Level.INFO, "other shape");
                    break;
                default:
                    logger.log(Level.ERROR, "wrong data input. can't define type of shape : {} ", type);
                    throw new CubeException("wrong data input. can't define type of shape : " + type);
            }

        }
        return shapeList;
    }

    private String checkCubeParameters(String type, String name, int sideLength) throws CubeException {
        if (type == null) {
            logger.log(Level.ERROR, "shape without type cannot be created");
            throw new CubeException("shape without type cannot be created");
        }
        if (sideLength <= 0) {
            logger.log(Level.ERROR, "wrong data input. side length cannot be less than 0 : {}", sideLength);
            throw new CubeException("wrong data input. side length cannot be less than 0 :" + sideLength);
        }
        if (name == null) {
            name = "unnamed";
        }
        return name;
    }


    private Cube chooseShapeAndCreateIt(String type, String name, int sideLength, CustomPoint centerPoint) throws CubeException {
        switch (type.toLowerCase()) {
            case CUBE_SHAPE://create cube
                Cube newCube = createCube(type, name, sideLength, centerPoint);
                return newCube;
            case ANY_OTHER_SHAPE://create other shape
                logger.log(Level.INFO, "other shape");
            default:
                logger.log(Level.ERROR, "wrong data input. can't define type of shape : {} ", type);
                throw new CubeException("wrong data input. can't define type of shape : " + type);
        }
    }


    private Cube createCube(String type, String name, double sideLength, CustomPoint centerPoint) throws CubeException {
        String cubeId = IdGenerator.createId(type);
        Cube newCube = new Cube(cubeId, name, sideLength, centerPoint);
        return newCube;
    }


    private CustomPoint createPoint(double x, double y, double z) {
        return new CustomPoint(x, y, z);
    }
}
