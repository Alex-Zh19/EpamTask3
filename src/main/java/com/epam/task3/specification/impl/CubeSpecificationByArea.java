package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeSpecificationInterface;

public class CubeSpecificationByArea implements CubeSpecificationInterface {
    private int desiredArea;

    public CubeSpecificationByArea(int desiredArea) {
        this.desiredArea = desiredArea;
    }

    @Override
    public boolean specified(Cube cube) {
        double cubeArea = cube.getSideLength() * cube.getSideLength() * 6;
        return cubeArea == desiredArea;
    }
}
