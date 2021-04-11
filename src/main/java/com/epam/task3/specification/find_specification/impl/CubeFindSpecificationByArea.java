package com.epam.task3.specification.find_specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.find_specification.CubeFindSpecificationInterface;

public class CubeFindSpecificationByArea implements CubeFindSpecificationInterface {
    private int desiredArea;

    public CubeFindSpecificationByArea(int desiredArea) {
        this.desiredArea = desiredArea;
    }

    @Override
    public boolean specified(Cube cube) {
        double cubeArea = cube.getSideLength() * cube.getSideLength() * 6;
        return cubeArea == desiredArea;
    }
}
