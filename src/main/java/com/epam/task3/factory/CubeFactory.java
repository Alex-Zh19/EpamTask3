package com.epam.task3.factory;

import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.entity.Shape;
import com.epam.task3.exception.CubeException;

import java.util.ArrayList;
import java.util.List;

public class CubeFactory {
    private int id = 0;
    private final String CUBE_SHAPE = "cube";

    public Shape createShape(String type, String name, int sideLength, CustomPoint centerPoint) throws CubeException {
        if (type == null) {
            throw new CubeException("shape without type cannot be created");
        }
        if (sideLength <= 0) {
            throw new CubeException("wrong data input. side length cannot be less than 0 :" + sideLength);
        }
        if (name == null) {
            name = "unnamed";
        }
        switch (type) {
            case CUBE_SHAPE://create cube
                Shape newCube = createCube(type, name, sideLength, centerPoint);
                return newCube;
            default:
                throw new CubeException("wrong data input. can't define type of shape : " + type);
        }

    }

    public List<Shape> createShape(List<String[]> typeAndName, List<double[]> parametersList) throws CubeException {
        List<Shape> shapeList = new ArrayList<>();
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
            switch (type) {
                case CUBE_SHAPE://create cube
                    CustomPoint centerPoint = createPoint(dataParameter[0], dataParameter[1], dataParameter[2]);
                    double sideLength = dataParameter[dataParameter.length - 1];
                    Shape newCube = createCube(type, name, sideLength, centerPoint);
                    shapeList.add(newCube);
                    break;
                default:
                    throw new CubeException("wrong data input. can't define type of shape : " + type);
            }

        }
        return shapeList;
    }

    private Cube createCube(String type, String name, double sideLength, CustomPoint centerPoint) throws CubeException {
        String cubeId = createId(type);
        Cube newCube = new Cube(cubeId, name, sideLength, centerPoint);
        this.id++;
        return newCube;
    }

    private String createId(String type) {
        StringBuilder createId = new StringBuilder(type);
        createId = createId.append(id);
        return createId.toString();
    }


    private CustomPoint createPoint(double x, double y, double z) {
        return new CustomPoint(x, y, z);
    }
}
