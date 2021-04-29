package com.epam.task3.factory;

import com.epam.task3.entity.Cube;
import com.epam.task3.entity.CustomPoint;
import com.epam.task3.exception.CubeException;

import java.util.List;

public interface ShapeFactory {
    Cube createShape(String type, String name, int sideLength, double x, double y, double z) throws CubeException;

    Cube createShape(String type, String name, int sideLength, CustomPoint centerPoint) throws CubeException;

    List<Cube> createShape(List<String[]> typeAndName, List<double[]> parametersList) throws CubeException;
}
