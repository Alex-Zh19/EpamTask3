package com.epam.task3.specification.impl;

import com.epam.task3.entity.Cube;
import com.epam.task3.specification.CubeFindSpecification;

public class CubeFindSpecificationByArea implements CubeFindSpecification {
    private int desiredArea;

    public CubeFindSpecificationByArea(int desiredArea) {
        this.desiredArea = desiredArea;
    }

    @Override
    public boolean specified(Cube cube) {
        double cubeArea = Math.pow(cube.getSideLength(), 2) * 6;
        return cubeArea == desiredArea;
    }
}
